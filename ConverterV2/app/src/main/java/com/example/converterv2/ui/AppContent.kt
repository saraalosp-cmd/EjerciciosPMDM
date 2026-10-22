package com.example.converterv2.ui

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
import com.example.converterv2.R
import com.example.converterv2.ui.theme.ConverterV2Theme


@Composable
fun AppContent (content: @Composable (modifier: Modifier) -> Unit) {
    ConverterV2Theme {
        Scaffold(modifier = Modifier
            .fillMaxSize(),
            containerColor = colorResource(id= R.color.fondo)
        ) { innerPadding ->
            Box ( modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(innerPadding.calculateTopPadding())
                        .background(colorResource(id= R.color.azul))
                )

                content(Modifier.padding(innerPadding))
            }
        }
    }
}