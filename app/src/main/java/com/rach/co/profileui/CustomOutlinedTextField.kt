package com.rach.co.profileui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomOutLinedTextField(
    modifier: Modifier,
    label:String,
    value:String,
    onValueChange:(String) -> Unit,
    showError:Boolean,
    singleLine:Boolean
){

    val isError = value.isEmpty() && showError

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = {Text(text = label)},
        isError = isError,
        singleLine = singleLine
    )

    if (isError){
        Text(text = "Please $label",
            color = MaterialTheme.colorScheme.error)
    }

}