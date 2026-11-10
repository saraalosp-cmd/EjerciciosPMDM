package com.example.master

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.master.ui.theme.MasterTheme

@Composable
fun AppContent (content: @Composable (modifier: Modifier) -> Unit) {
    MasterTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            content(Modifier.padding(innerPadding))
        }
    }
}