package com.rach.co.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.rach.co.R
import com.rach.co.dataClass.AdConstants
import com.rach.co.dataClass.DummyQuestionData
import com.rach.co.dataClass.QuestionDataClass
import com.rach.co.navigation.Screens
import com.rach.co.ui.theme.CQuizAppTheme
import com.rach.co.viewModel.AppViewModel



@Composable
fun HomeScreenLayout(navController: NavController ,viewModel: AppViewModel) {



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {
            AndroidView(
                modifier = Modifier
                    .fillMaxWidth(),
                factory = { context ->
                    AdView(context).apply {
                       setAdSize(AdSize.BANNER)
                        adUnitId = AdConstants.BANNER_AD_UNIT_ID
                        loadAd(com.google.android.gms.ads.AdRequest.Builder().build())
                    }
                }
            )
        }


        item {
            Text(
                "Ready to test your C++ skills?",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Cursive
            )
            Text(
                "Quizzes",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                fontFamily = FontFamily.Cursive
            )
        }

        item {
            Spacer(modifier = Modifier.height(25.dp))
        }

        items(DummyQuestionData.itemList) { quiz ->
            QuizCard(
                modifier = Modifier
                    .fillMaxWidth(),
                quiz = quiz,
                onClick = {
                    viewModel.updateCurrentQuiz(quiz)
                    navController.navigate(Screens.HomeScreen.QuizScreen.route)
                }
            )
        }

    }

}


@Composable
fun QuizCard(modifier: Modifier, quiz: QuestionDataClass, onClick: () -> Unit) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { onClick() }
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.fire_icons),
                contentDescription = "Fire Icon"
            )

            Spacer(modifier = Modifier.width(15.dp))

            Column {
                Text(
                    text = quiz.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${quiz.numberOfQuestion} questions",
                    fontSize = 14.sp
                )
            }

        }

    }
}


@Composable
fun DifficultySelectedChips() {

    val difficultyLevel = listOf("Easy", "Medium", "Hard")

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        items(difficultyLevel) { index ->
            ChipsDesign(
                label = index,
                selected = index == "Easy"
            )
        }

    }

}

@Composable
fun ChipsDesign(
    label: String,
    selected: Boolean
) {

    val backgroundBrushColor = if (selected) {
        Brush.horizontalGradient(
            listOf(
                MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
            )
        )
    } else {
        Brush.horizontalGradient(
            listOf(
                MaterialTheme.colorScheme.surface,
                MaterialTheme.colorScheme.surface
            )
        )
    }

    Box(
        modifier = Modifier
            .background(backgroundBrushColor, shape = MaterialTheme.shapes.medium)
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        FilterChip(
            selected = selected,
            onClick = {},
            label = { Text(text = label) },
            leadingIcon = if (selected) {

                { Icon(imageVector = Icons.Default.Check, contentDescription = "Chips Check") }

            } else {
                null
            }
        )
    }

}

@HomeScreenPreview
@Composable
private fun Preview() {
    CQuizAppTheme {
        HomeScreenLayout(navController = rememberNavController(), viewModel = AppViewModel())
    }
}