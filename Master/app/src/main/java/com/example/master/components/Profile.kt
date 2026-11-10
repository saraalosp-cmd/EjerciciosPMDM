package com.example.master.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.master.R

/**
 * Ventana de perfil que se abre con el botón flotante.
 *
 * Dibuja un fondo negro semitransparente sobre todo el contenido y, en el centro, un cuadro
 * con la foto circular y un texto con degradado.
 *
 * @param onDismiss se ejecuta al pulsar fuera del cuadro, para cerrar la ventana.
 */
@Composable
fun Info(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.6f))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onDismiss
            ),
        contentAlignment = Alignment.Center
    ) {
        Card (
            shape = RoundedCornerShape(6.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.fondo)),
            border = BorderStroke(2.dp, color = Color.Black),
            modifier = Modifier
                .widthIn(max = 320.dp)
                .padding(16.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = { }
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image (
                    painter = painterResource(id = R.drawable.perfil),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(72.dp)
                        .border(
                            BorderStroke(2.dp, colorResource(id= R.color.moradoOscuro)),
                            CircleShape
                        )
                        .background(colorResource(id = R.color.sticky), CircleShape)
                        .clip(CircleShape)
                )

                Spacer(Modifier.width(16.dp))

                Text(
                    text = stringResource(id = R.string.perfil),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    style = TextStyle(
                        brush= Brush.verticalGradient(listOf(
                            colorResource(id = R.color.degradadotext1),
                            colorResource(id = R.color.degradadotext2),
                            colorResource(id = R.color.degradadotext3))
                        )
                    )
                )
            }
        }
    }
}