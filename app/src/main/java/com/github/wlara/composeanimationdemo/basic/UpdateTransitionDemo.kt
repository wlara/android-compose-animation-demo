package com.github.wlara.composeanimationdemo.basic

import android.content.res.Configuration
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
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
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.wlara.composeanimationdemo.R
import com.github.wlara.composeanimationdemo.ui.theme.ComposeAnimationDemoTheme

@Composable
fun UpdateTransitionDemo() {
    var activated by remember { mutableStateOf(false) }
    val transition = updateTransition(
        targetState = activated,
        label = "Shoe Transition"
    )
    val offsetY by transition.animateDp(label = "Shoe offsetY") { state ->
        if (state) 200.dp else 0.dp
    }
    val color by transition.animateColor(label = "Shoe color") { state ->
        if (state) Red else Blue
    }
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
            modifier = Modifier.offset(y = offsetY),
            colorFilter = ColorFilter.tint(color, BlendMode.Screen)
        )
    }
}

@Preview(name = "AnimateMultipleValues")
@Preview(name = "AnimateMultipleValues (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewAnimateMultipleValues() {
    ComposeAnimationDemoTheme {
        UpdateTransitionDemo()
    }
}
