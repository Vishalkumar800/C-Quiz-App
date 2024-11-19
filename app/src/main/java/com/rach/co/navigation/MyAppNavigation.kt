package com.rach.co.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rach.co.homeScreen.HomeScreenLayout
import com.rach.co.homeScreen.QuizScreen
import com.rach.co.homeScreen.ScoreScreen
import com.rach.co.homeScreen.SeeUpdates
import com.rach.co.profileui.EditProfileUi
import com.rach.co.profileui.ProfileUi
import com.rach.co.viewModel.AppViewModel

@Composable
fun MyAppNavigation(
    navController: NavController,
    viewModel: AppViewModel,
    paddingValues: PaddingValues
) {

    NavHost(
        navController = navController as NavHostController,
        startDestination = Screens.DrawerScreen.Home.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(Screens.DrawerScreen.Home.route) {
            HomeScreenLayout(navController = navController, viewModel = viewModel)
        }

        composable(Screens.DrawerScreen.Profile.route) {
            ProfileUi(viewModel = AppViewModel())
        }

        composable(Screens.BottomScreen.Home.bRoute){
            HomeScreenLayout(navController = navController,viewModel = viewModel)

        }

        composable(Screens.BottomScreen.Profile.bRoute){
            ProfileUi(viewModel = AppViewModel())
        }

        composable(Screens.BottomScreen.SeeUpdates.bRoute){
            SeeUpdates(navController = navController)
        }

        composable(Screens.DrawerScreen.Share.route){
            ProfileUi(viewModel = AppViewModel())
        }

        composable(Screens.HomeScreen.QuizScreen.route){
            QuizScreen(navController= navController ,viewModel = viewModel)
        }

        composable(Screens.HomeScreen.EditProifleUi.route){
            EditProfileUi(navController = navController ,viewModel = viewModel)
        }

        composable(Screens.HomeScreen.ScoreScren.route){
            ScoreScreen(navController = navController , appViewModel = viewModel)
        }
    }

}