package com.github.wlara.composeanimationdemo.basic

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CrossfadeDemo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var page by remember { mutableStateOf(1) }
        Button(
            onClick = { if (++page > 3) page = 1 },
            modifier = Modifier.padding(40.dp)
        ) {
            Text(text = "Just Do It")
        }
        Crossfade(
            targetState = page,
            animationSpec = tween(1000)
        ) { targetPage ->
            when (targetPage) {
                1 -> Text("One", fontSize = 56.sp)
                2 -> Text("Two", fontSize = 56.sp)
                3 -> Text("Three", fontSize = 56.sp)
            }
        }
    }
}
