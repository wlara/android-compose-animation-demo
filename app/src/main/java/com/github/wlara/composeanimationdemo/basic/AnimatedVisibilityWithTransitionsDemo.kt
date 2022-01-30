package com.github.wlara.composeanimationdemo.basic

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.wlara.composeanimationdemo.R
import com.github.wlara.composeanimationdemo.ui.theme.ComposeAnimationDemoTheme


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedVisibilityWithTransitionsDemo() {   // DEMO INTERRUPTION
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
        val slowTween = tween<Float>(durationMillis = 3000)
        AnimatedVisibility(
            visible = visible,
            //enter = fadeIn() + scaleIn(),
            //exit = fadeOut() + scaleOut(),
            enter = fadeIn(slowTween) + scaleIn(slowTween),
            exit = fadeOut(slowTween) + scaleOut(slowTween),
        ) {
            Image(
                painter = painterResource(R.drawable.shoe),
                contentDescription = null
            )
        }
    }
}

@Preview(name = "ToggleVisibilityAnimatedWithTransitions")
@Preview(name = "ToggleVisibilityAnimatedWithTransitions (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewToggleVisibilityAnimatedWithTransitions() {
    ComposeAnimationDemoTheme {
        AnimatedVisibilityWithTransitionsDemo()
    }
}
