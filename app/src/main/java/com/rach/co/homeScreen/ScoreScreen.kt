package com.rach.co.homeScreen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.rach.co.dataClass.AdConstants
import com.rach.co.navigation.Screens
import com.rach.co.ui.theme.CQuizAppTheme
import com.rach.co.viewModel.AppViewModel
import com.rach.co.R

@Composable
fun ScoreScreen(navController: NavController, appViewModel: AppViewModel) {
    val score by appViewModel.score.collectAsState()
    val currentQuiz by appViewModel.currentQuiz.collectAsState()
    val totalQuestions = currentQuiz?.questionList?.size.toString()



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

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

        // Score Text
        Text(
            text = "Out of $totalQuestions Questions,",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "you got $score correct!",
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))


        Image(
            painter = painterResource(R.drawable.maintence),
            contentDescription = "Confetti",
            modifier = Modifier.size(200.dp),
            colorFilter = ColorFilter.tint(
                color = MaterialTheme.colorScheme.onBackground
            )
        )

        Spacer(modifier = Modifier.height(32.dp))


        Button(
            onClick = {
                navController.navigate(Screens.DrawerScreen.Home.route){
                    popUpTo(Screens.HomeScreen.QuizScreen.route){
                        inclusive = true

                    }
                    launchSingleTop = true

                }
            },
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .height(50.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text("Try Again")
        }
    }
}


@HomeScreenPreview
@Composable
private fun Preview() {
    CQuizAppTheme {
        ScoreScreen(navController = rememberNavController(), appViewModel = AppViewModel())
    }
}