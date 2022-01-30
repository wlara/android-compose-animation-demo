package com.github.wlara.composeanimationdemo.advanced

import android.graphics.Typeface
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.wlara.composeanimationdemo.R
import kotlinx.coroutines.delay

@Composable
fun LoadingOverlayAnimationDemo() {
    val isLoading = remember { mutableStateOf(true) }
    Box(
        Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .clickable {
                isLoading.value = false
            }) {
        ActualContent()
        LoadingOverlay(isLoading = isLoading)
    }
    // Add a 10-second time out on the loading animation
    LaunchedEffect(Unit) {
        delay(10_000)
        isLoading.value = false
    }
}

@Composable
fun ActualContent() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            shape = RoundedCornerShape(10.dp),
        ) {
            val painter = painterResource(R.drawable.shoe)
            Image(
                painter,
                contentDescription = null,
            )
        }
        Text(
            text = "Air Jordan",
            fontFamily = FontFamily(typeface = Typeface.SANS_SERIF),
            fontSize = 40.sp,
            color = Color(0xff173d6e),
            modifier = Modifier
                .padding(top = 10.dp, bottom = 5.dp)
        )
        Text(
            "Basketball Shoes",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            "Thirty-five models of the Air Jordan and an intuition like no other have " +
                    "led to this moment. Like family members who come before us, the Air Jordan " +
                    "represents a legacy of innate greatness that continues to be built upon. " +
                    "And while each design helps inform the next, the Jordan VI has a special " +
                    "place in the family tree, as it was the sneaker worn by MJ when he won his " +
                    "first of six championships in 1991. Paying homage to the Jordan VI and his " +
                    "six rings, the Air Jordan XXXVI \"Psychic Energy\" is an acknowledgement " +
                    "of the Jordan legacy and the extrasensory perception of those who carry it."
        )
    }
}

val GradientColor: Color = Color(0xff173d6e)
val BackgroundColor: Color = Color(0xffdbe5ef)

@Composable
fun LoadingOverlay(
    isLoading: State<Boolean>
) {
    val fraction = remember { Animatable(0f) }
    var reveal by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        while (isLoading.value) {
            fraction.animateTo(1f, tween(2000))
            fraction.snapTo(0f)
        }
        reveal = true
        fraction.animateTo(1f, tween(1000))
    }

    if (!reveal) { // Draw a cover
        Box(
            Modifier
                .fillMaxSize()
                .background(BackgroundColor)
        )
    }

    // Draw gradient..
    Box(
        Modifier
            .fillMaxSize()
            .drawWithCache {
                val gradient = Brush.verticalGradient(
                    listOf(
                        Color.Transparent,
                        GradientColor.copy(alpha = 0.2f),
                        BackgroundColor
                    ),
                    startY = size.height * (fraction.value - 0.1f),
                    endY = size.height * (fraction.value + 0.1f)
                )
                onDrawWithContent {
                    drawRect(gradient)
                }
            }
    )
}
