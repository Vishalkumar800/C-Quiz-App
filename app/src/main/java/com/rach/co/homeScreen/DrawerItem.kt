package com.rach.co.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rach.co.navigation.Screens

@Composable
fun DrawerItem(
    selected: Boolean,
    item: Screens.DrawerScreen,
    onDrawerItemSelected: () -> Unit
) {

    val backgroundBrushColor = if (selected) {
        Brush.horizontalGradient(
            listOf(
                MaterialTheme.colorScheme.primary.copy(0.1f),
                MaterialTheme.colorScheme.primary.copy(0.3f)
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

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 12.dp)
            .clickable { onDrawerItemSelected() },
        shape = RoundedCornerShape(12.dp)
    ) {

        Row(
            modifier = Modifier
                .background(brush = backgroundBrushColor)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(item.icon), contentDescription = item.dTitle,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = item.dTitle,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium
            )
        }

    }

}