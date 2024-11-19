package com.rach.co.homeScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rach.co.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    title: String,
    modifier: Modifier,
    navController: NavController,
    onMenuIconClick: () -> Unit,
    scrollBehavior:TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(state = rememberTopAppBarState())
) {

    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = modifier.padding(start = 16.dp),
                fontWeight = FontWeight.SemiBold
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 12.dp),
        navigationIcon = {
            if (title == "Home") {
                IconButton(onClick = { onMenuIconClick() }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Home Menu")
                }
            } else {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Arrow Back"
                    )
                }
            }
        },
        actions = {
            if (title == "Home") {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = "Profile Account Home Screen Icons"
                    )
                }
            } else if (title =="Profile") {
                IconButton(onClick = {navController.navigate(Screens.HomeScreen.EditProifleUi.route)}) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Profile Edit Screen Icons"
                    )
                }
            }else{
                null
            }
        },
        scrollBehavior = scrollBehavior
    )
}