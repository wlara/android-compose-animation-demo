package com.github.wlara.composeanimationdemo.basic

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.with
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

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentWithTransitionsDemo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var count by remember { mutableStateOf(0) }
        Button(
            onClick = { count++ },
            modifier = Modifier.padding(40.dp)
        ) {
            Text(text = "Just Do It")
        }
        val slowTween = tween<Float>(durationMillis = 1000)
        AnimatedContent(
            targetState = count,
            transitionSpec = {
                //fadeIn() + scaleIn() with fadeOut() + scaleOut()
                fadeIn(slowTween) + scaleIn(slowTween) with fadeOut(slowTween) + scaleOut(slowTween)
            }
        ) {
            Text(
                text = "Total Clicks: $count",
                fontSize = 48.sp
            )
        }
    }
}
