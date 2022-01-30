package com.github.wlara.composeanimationdemo.basic

import android.graphics.Typeface
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.wlara.composeanimationdemo.R

@Composable
fun NonAnimateContentSizeDemo() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .background(Color(0xffadd8e6))
            .padding(20.dp)
            .fillMaxWidth()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.shoe),
            contentDescription = null,
        )

        Text(
            text = "Air Jordan",
            fontFamily = FontFamily(typeface = Typeface.SANS_SERIF),
            fontSize = 40.sp,
            color = Color(0xff173d6e),
            modifier = Modifier
                .padding(top = 10.dp, bottom = 5.dp)
        )
        var expanded by remember { mutableStateOf(false) }
        Text(
            "Basketball Shoes",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .clickable { expanded = !expanded }
        )
        if (expanded) {
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
}