package com.example.floatingbottomnavigationbar.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

@Composable
fun Screen3() {

    SetStatusBarColor(
        statusBarColor = Color.Blue.copy(0.2f),
        navigationBarColor = Color.Blue.copy(0.2f)
    )

    Box(modifier = Modifier
        .fillMaxSize()
        .systemBarsPadding()
        .background(Color.Blue.copy(0.2f))) {
        Text(
            text = "Screen 3",
            fontSize = 30.sp,
            letterSpacing = 0.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black,
            softWrap = false,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}