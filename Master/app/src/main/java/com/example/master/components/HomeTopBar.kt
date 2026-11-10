package com.example.master.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.master.R

/**
 * Barra superior de la app, con el logo a la izquierda y el creador a la derecha.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(R.drawable.jujutsu),
                contentDescription = null,
                modifier = Modifier.height(50.dp),
                contentScale = ContentScale.Fit
            )
        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.moradoOscuro)
        ),

        actions = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.height(30.dp),
                    contentScale = ContentScale.Fit
                )

                Text(
                    text = stringResource(id = R.string.by),
                    color = colorResource(id = R.color.white),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    )

}