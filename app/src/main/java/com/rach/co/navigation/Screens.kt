package com.rach.co.navigation

import androidx.annotation.DrawableRes
import com.rach.co.R


sealed class Screens(val title: String, val route: String) {

    sealed class DrawerScreen(
        val dTitle: String,
        val dRoute: String,
        @DrawableRes val icon: Int
    ) : Screens(dTitle, dRoute) {

        object Home : DrawerScreen(
            dTitle = "Home",
            dRoute = "home",
            icon = R.drawable.outline_home_24
        )

        object Profile : DrawerScreen(
            dTitle = "Profile",
            dRoute = "profile",
            icon = R.drawable.outline_account_circle_24
        )

        object Share : DrawerScreen(
            dTitle = "Share",
            dRoute = "share",
            icon = R.drawable.outline_share_24
        )

        object PrivacyPolicy : DrawerScreen(
            dTitle = "Privacy Policy",
            dRoute = "privacyPolicy",
            icon = R.drawable.fire_icons
        )

        object Rating : DrawerScreen(
            dTitle = "Rate on PlayStore",
            dRoute = "rating",
            icon = R.drawable.rating
        )

    }

    sealed class BottomScreen(
        val bTitle:String,
        val bRoute:String,
        @DrawableRes val icon:Int
    ):Screens(bTitle,bRoute){

        object Home: BottomScreen(
            "Home",
            "home",
            R.drawable.outline_home_24
        )

        object Profile:BottomScreen(
            "Profile",
            "profile2",
            R.drawable.outline_account_circle_24
        )

        object SeeUpdates:BottomScreen(
            "Updates",
            "updates",
            R.drawable.fire_icons
        )
    }

    sealed class HomeScreen(
        val dTitle: String,
        val dRoute: String
    ):Screens(dTitle,dRoute){
        object QuizScreen:HomeScreen(
            "Quiz Screen",
            "quizScreen"
        )

        object EditProifleUi:HomeScreen(
            "Edit Profile",
            "editProfile"
        )

        object ScoreScren:HomeScreen(
            "Score Screen",
            "scoreScreen"
        )

    }




}

val drawersInScreens = listOf(
    Screens.DrawerScreen.Home,
    Screens.DrawerScreen.Profile,
    Screens.DrawerScreen.Share,
    Screens.DrawerScreen.PrivacyPolicy,
    Screens.DrawerScreen.Rating
)

val bottomBarInScreens = listOf(
    Screens.BottomScreen.Home,
    Screens.BottomScreen.Profile,
    Screens.BottomScreen.SeeUpdates
)

