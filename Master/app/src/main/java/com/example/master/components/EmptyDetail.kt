package com.example.master.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.master.R

/**
 * Tarjeta que se muestra en la zona de detalle mientras no hay ningún personaje seleccionado.
 * Tiene esquinas cortadas, borde con degradado y un mensaje entre dos iconos de aviso.
 */
@Composable
fun EmptyDetail(modifier: Modifier = Modifier) {
    Card(
        shape = CutCornerShape(16.dp),
        border = BorderStroke(
            width = 4.dp,
            brush= Brush.linearGradient(listOf(
                colorResource(id = R.color.degradado3),
                colorResource(id = R.color.degradado2),
                colorResource(id = R.color.degradado1))
            )
        ),
        colors = CardDefaults.cardColors(colorResource(id = R.color.card)),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Icon (
            imageVector = Icons.Outlined.Warning,
            contentDescription = null,
            tint = colorResource(id= R.color.amarillo),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(30.dp)
                .size(50.dp)
        )

        Text(
            text = stringResource(id = R.string.select),
            color = Color.DarkGray,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()

        )

        Icon (
            imageVector = Icons.Outlined.Warning,
            contentDescription = null,
            tint = colorResource(id= R.color.amarillo),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(30.dp)
                .size(50.dp)
        )
    }
}