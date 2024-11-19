package com.rach.co.homeScreen


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.rach.co.dataClass.AdConstants
import com.rach.co.navigation.Screens
import com.rach.co.ui.theme.CQuizAppTheme
import com.rach.co.ui.theme.Green
import com.rach.co.viewModel.AppViewModel

@Composable
fun QuizScreen(navController: NavController, viewModel: AppViewModel) {

    val currentQuiz = viewModel.currentQuiz.collectAsState().value
    val currentQuestionIndex = viewModel.currentQuestionIndex.collectAsState().value


    val question = currentQuiz!!.questionList[currentQuestionIndex]
    val options = question.option
    val correctOptions = question.correct

    var selectedOptionIndex by remember { mutableStateOf<Int?>(null) }



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        item {
            LinearProgressIndicator(
                progress = { (currentQuestionIndex + 1) / currentQuiz.questionList.size.toFloat() },
                modifier = Modifier.fillMaxWidth(),
                color = Color.Red.copy(alpha = 0.6f),
                trackColor = Color.Red.copy(alpha = 0.2f)
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        item {
            AndroidView(
                modifier = Modifier.fillMaxWidth(),
                factory = {context ->
                    AdView(context).apply {
                        setAdSize(AdSize.BANNER)
                        adUnitId = AdConstants.BANNER_AD_UNIT_ID
                        loadAd(AdRequest.Builder().build())
                    }
                }
            )
        }

        item {
            Text(
                text = "Question ${currentQuestionIndex + 1}",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = question.question,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 16.dp)
            )

        }

        items(options) { option ->
            val isSelected = options.indexOf(option) == selectedOptionIndex
            val isCorrect = correctOptions.contains(option)

            OptionCard(
                text = option,
                backgroundColor = when {
                    isSelected && isCorrect -> Green
                    isSelected && !isCorrect -> Color.Red.copy(alpha = 0.7f)
                    else -> MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                },
                isSelected = isSelected,
                isCorrect = isCorrect,
                onClick = {
                    selectedOptionIndex = options.indexOf(option)
                    viewModel.handleAnswer(option)
                }
            )
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = {
                    viewModel.goToPreviousQuestion()
                    selectedOptionIndex = null
                }) {
                    Text("Back")
                }

                Button(onClick = {
                    if (currentQuestionIndex == currentQuiz.questionList.size - 1) {
                        navController.navigate(Screens.HomeScreen.ScoreScren.route)
                    } else {
                        viewModel.goToNextQuestion()
                        selectedOptionIndex = null
                    }
                }) {
                    Text("Next")
                }
            }

        }


    }

}


@Composable
fun OptionCard(
    text: String,
    backgroundColor: Color,
    isSelected: Boolean,
    isCorrect: Boolean,
    onClick: () -> Unit
) {
    val icon = when {
        isSelected && isCorrect -> Icons.Default.Done
        isSelected && !isCorrect -> Icons.Default.Close
        else -> null
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(enabled = !isSelected) { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )

            icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = "Icon",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@HomeScreenPreview
@Composable
private fun Preview() {
    CQuizAppTheme {
        QuizScreen(navController = rememberNavController(), viewModel = AppViewModel())
    }
}