package com.rach.co.profileui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rach.co.homeScreen.HomeScreenPreview
import com.rach.co.navigation.Screens
import com.rach.co.ui.theme.CQuizAppTheme
import com.rach.co.viewModel.AppViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun EditProfileUi(navController: NavController, viewModel: AppViewModel) {
    val scrollState = rememberScrollState()
    val editFields by viewModel.editFields.collectAsState()
    val focusRequester = remember {
        FocusRequester()
    }
    val scope = rememberCoroutineScope()
    val isLoading by viewModel.isLoading.collectAsState()

    val colorBg = if (isSystemInDarkTheme()) {
        MaterialTheme.colorScheme.surfaceBright.copy(alpha = 0.6f)
    } else {
        Color.Blue.copy(alpha = 0.3f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        editFields.forEachIndexed { index, profileFields ->

            CustomOutLinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(if (index == 0) focusRequester else FocusRequester()),
                label = profileFields.label,
                value = profileFields.title,
                onValueChange = {
                    viewModel.updateFields(index, it)
                },
                singleLine = true,
                showError = profileFields.showError
            )

            Spacer(modifier = Modifier.height(16.dp))

        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                if (viewModel.validateFields()) {
                    scope.launch {
                        viewModel.profileSave()
                        delay(2000)
                        navController.navigate(Screens.DrawerScreen.Profile.route){
                            popUpTo(Screens.HomeScreen.EditProifleUi.route){
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorBg
            ),
            enabled = !isLoading
        ) {
            if (isLoading){
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    strokeWidth = 2.dp
                )

            }else{
                Text(
                    text = "Save Profile",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }


    }

}

@HomeScreenPreview
@Composable
private fun Preview() {
    CQuizAppTheme {
        EditProfileUi(
            navController = rememberNavController(),
            viewModel = AppViewModel()
        )
    }
}