package com.github.wlara.composeanimationdemo.basic

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.github.wlara.composeanimationdemo.R

@Composable
fun AnimateDpAsStateDemo() {
    var activated by remember { mutableStateOf(false) }
    val offsetY by animateDpAsState(
        targetValue = if (activated) 200.dp else 0.dp,
        animationSpec = tween(durationMillis = 3000)
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { activated = !activated },
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = "Just Do It")
        }
        Image(
            painter = painterResource(R.drawable.shoe),
            contentDescription = null,
            Modifier.offset(y = offsetY)
        )
    }
}