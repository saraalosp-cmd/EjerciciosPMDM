package com.example.profileyou.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.profileyou.R
import com.example.profileyou.ui.theme.ProfileYouTheme

@Composable
fun AppContent (content: @Composable (modifier: Modifier) -> Unit) {
    ProfileYouTheme {
        Scaffold(modifier = Modifier
            .fillMaxSize(),
            containerColor = colorResource(id= R.color.fondo)
            ) { innerPadding ->
            Box ( modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(innerPadding.calculateTopPadding())
                        .background(colorResource(id= R.color.moradoOscuro))
                )

                content(Modifier.padding(innerPadding))
            }
        }
    }
}