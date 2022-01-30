package com.github.wlara.composeanimationdemo.basic

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.github.wlara.composeanimationdemo.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedVisibilityDemo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var visible by remember { mutableStateOf(true) }
        Button(
            onClick = { visible = !visible },
            modifier = Modifier.padding(40.dp)
        ) {
            Text(text = "Just Do It")
        }
        AnimatedVisibility(visible) {
            Image(
                painter = painterResource(R.drawable.shoe),
                contentDescription = null
            )
        }
    }
}
