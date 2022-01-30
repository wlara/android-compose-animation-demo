package com.github.wlara.composeanimationdemo

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.github.wlara.composeanimationdemo.advanced.HeartIconAnimationDemo
import com.github.wlara.composeanimationdemo.advanced.LoadingOverlayAnimationDemo
import com.github.wlara.composeanimationdemo.advanced.ShrineCartDemo
import com.github.wlara.composeanimationdemo.basic.AnimateContentSizeDemo
import com.github.wlara.composeanimationdemo.basic.UpdateTransitionDemo
import com.github.wlara.composeanimationdemo.basic.AnimateDpAsStateDemo
import com.github.wlara.composeanimationdemo.basic.AnimatedContentDemo
import com.github.wlara.composeanimationdemo.basic.AnimatedContentWithTransitionsDemo
import com.github.wlara.composeanimationdemo.basic.NonAnimatedContentDemo
import com.github.wlara.composeanimationdemo.basic.AnimatedVisibilityDemo
import com.github.wlara.composeanimationdemo.basic.AnimatedVisibilityWithTransitionsDemo
import com.github.wlara.composeanimationdemo.basic.CrossfadeDemo
import com.github.wlara.composeanimationdemo.basic.NonAnimateContentSizeDemo
import com.github.wlara.composeanimationdemo.basic.NonAnimatedVisibilityDemo
import com.github.wlara.composeanimationdemo.basic.NonCrossfadeDemo

enum class Screen {
    Home,
    NonAnimatedVisibilityDemo,
    AnimatedVisibilityDemo,
    AnimatedVisibilityWithTransitionsDemo,
    NonAnimatedContentDemo,
    AnimatedContentDemo,
    AnimatedContentWithTransitionsDemo,
    NonAnimateContentSizeDemo,
    AnimateContentSizeDemo,
    NonCrossfadeDemo,
    CrossfadeDemo,
    AnimateDpAsStateDemo,
    UpdateTransitionDemo,
    ShrineCartDemo,
    HeartIconAnimationDemo,
    LoadingOverlayAnimationDemo
}

// A simple Navigation composable. Rather that using the Navigation components, I created
// this just for the fun of it. Don't try this in a more serious App, just use the
// Navigation components.
@Composable
fun Navigation() {
    var screen by remember { mutableStateOf(Screen.Home) }
    if (screen != Screen.Home) {
        BackHandler { screen = Screen.Home }
    }
    when (screen) {
        Screen.Home -> HomeScreen { screen = it }
        Screen.NonAnimatedVisibilityDemo -> NonAnimatedVisibilityDemo()
        Screen.AnimatedVisibilityDemo -> AnimatedVisibilityDemo()
        Screen.AnimatedVisibilityWithTransitionsDemo -> AnimatedVisibilityWithTransitionsDemo()
        Screen.NonAnimatedContentDemo -> NonAnimatedContentDemo()
        Screen.AnimatedContentDemo -> AnimatedContentDemo()
        Screen.AnimatedContentWithTransitionsDemo -> AnimatedContentWithTransitionsDemo()
        Screen.NonAnimateContentSizeDemo -> NonAnimateContentSizeDemo()
        Screen.AnimateContentSizeDemo -> AnimateContentSizeDemo()
        Screen.NonCrossfadeDemo -> NonCrossfadeDemo()
        Screen.CrossfadeDemo -> CrossfadeDemo()
        Screen.AnimateDpAsStateDemo -> AnimateDpAsStateDemo()
        Screen.UpdateTransitionDemo -> UpdateTransitionDemo()
        Screen.ShrineCartDemo -> ShrineCartDemo()
        Screen.HeartIconAnimationDemo -> HeartIconAnimationDemo()
        Screen.LoadingOverlayAnimationDemo -> LoadingOverlayAnimationDemo()
    }
}