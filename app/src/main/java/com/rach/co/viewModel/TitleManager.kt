package com.rach.co.viewModel

import com.rach.co.navigation.Screens

fun getCurrentTitleFromRoutes(route: String?): String {

    return when (route) {
        Screens.DrawerScreen.Home.dRoute -> "Home"
        Screens.DrawerScreen.Profile.dRoute -> Screens.DrawerScreen.Profile.dTitle
        Screens.DrawerScreen.Rating.dRoute -> Screens.DrawerScreen.Rating.dTitle
        Screens.BottomScreen.Home.bRoute -> "Home"
        Screens.BottomScreen.Profile.bRoute -> Screens.BottomScreen.Profile.bTitle
        Screens.DrawerScreen.Share.dRoute -> Screens.DrawerScreen.Share.dTitle
        Screens.HomeScreen.QuizScreen.dRoute -> Screens.HomeScreen.QuizScreen.dTitle
        Screens.HomeScreen.EditProifleUi.route -> Screens.HomeScreen.EditProifleUi.dTitle
        Screens.HomeScreen.ScoreScren.dRoute -> Screens.HomeScreen.ScoreScren.dTitle
        Screens.BottomScreen.SeeUpdates.bRoute -> "Update Screen"
        else -> "Home"
    }

}