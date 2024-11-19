package com.rach.co.homeScreen

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rach.co.navigation.MyAppNavigation
import com.rach.co.navigation.bottomBarInScreens
import com.rach.co.navigation.drawersInScreens
import com.rach.co.ui.theme.CQuizAppTheme
import com.rach.co.viewModel.AppViewModel
import com.rach.co.viewModel.getCurrentTitleFromRoutes
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(state = rememberTopAppBarState())

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val viewModel: AppViewModel = viewModel()


    val navController = rememberNavController()
    val navControllerStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navControllerStackEntry?.destination?.route

    val currentScreens = remember {
        viewModel.currentScreens.value
    }

    val title = remember {
        mutableStateOf(currentScreens.title)
    }

    // Bottom App Bar
    val context = LocalContext.current

    title.value = getCurrentTitleFromRoutes(currentRoute)

    val bottomRoutes = bottomBarInScreens.map { it.bRoute }

    val bottomAppBar: @Composable () -> Unit = {

        if (currentRoute in bottomRoutes) {
            NavigationBar(modifier = Modifier.wrapContentSize()) {
                bottomBarInScreens.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.bRoute,
                        onClick = {
                            navController.navigate(item.bRoute)
                        },
                        icon = {
                            Icon(
                                painter = painterResource(item.icon),
                                contentDescription = item.bTitle
                            )
                        },
                        label = { Text(text = item.bTitle) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)

                        )
                    )
                }
            }
        }

    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                LazyColumn(
                    modifier = Modifier.padding(16.dp)
                ) {

                    items(drawersInScreens) { item ->

                        DrawerItem(
                            selected = currentRoute == item.dRoute, item = item
                        ) {
                            coroutineScope.launch {
                                drawerState.close()
                            }

                            when (item.dRoute) {
                                "home" -> {
                                    navController.navigate(item.dRoute)

                                }

                                "profile" -> {
                                    navController.navigate(item.dRoute)
                                }

                                "share" -> {

                                    coroutineScope.launch {
                                        drawerState.close()
                                    }


                                    val appLink =
                                        "https://play.google.com/store/apps/details?id=com.rach.co"
                                    val shareIntent = Intent(Intent.ACTION_SEND).apply {
                                        type = "text/plain"
                                        putExtra(
                                            Intent.EXTRA_TEXT,
                                            "Check Out This Amazing app! $appLink"
                                        )
                                        putExtra(Intent.EXTRA_SUBJECT, "Amazing App")
                                    }
                                    context.startActivity(
                                        Intent.createChooser(
                                            shareIntent,
                                            "Share via"
                                        )
                                    )

                                }

                                "privacyPolicy" -> {

                                    coroutineScope.launch {
                                        drawerState.close() // Drawer close karein
                                    }
                                    val privacyPolicyUrl =
                                        "https://sites.google.com/view/universitypreparation/home" // Replace with your privacy policy URL

                                    // Intent to open the URL
                                    val intent = Intent(Intent.ACTION_VIEW).apply {
                                        data = Uri.parse(privacyPolicyUrl)
                                    }
                                    context.startActivity(intent)

                                }

                                else -> {
                                    null
                                }

                            }
                        }

                    }

                }
            }
        }
    ) {
        Scaffold(
            modifier = Modifier,
            topBar = {
                CustomTopAppBar(
                    title = title.value, modifier = Modifier,
                    navController = navController,
                    onMenuIconClick = {
                        coroutineScope.launch {
                            drawerState.open()
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            },
            bottomBar = bottomAppBar

        ) { paddingValues ->
            MyAppNavigation(
                navController = navController,
                viewModel = viewModel,
                paddingValues = paddingValues
            )
        }
    }


}

@Preview(name = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
annotation class HomeScreenPreview


@HomeScreenPreview
@Composable
private fun Preview() {
    CQuizAppTheme {
        HomeScreen()
    }
}