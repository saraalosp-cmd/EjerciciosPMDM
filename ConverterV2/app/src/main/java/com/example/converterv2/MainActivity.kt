package com.example.converterv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.converterv2.ui.AppContent
import com.example.converterv2.ui.HomeScreen
import com.example.converterv2.ui.theme.ConverterV2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConverterV2Theme {
                AppContent { modifier ->
                    HomeScreen(modifier)
                }
            }
        }
    }
}
