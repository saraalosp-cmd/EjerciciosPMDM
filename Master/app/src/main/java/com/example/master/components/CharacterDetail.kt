package com.example.master.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.master.R
import com.example.master.model.Character

/**
 * Detalle de un personaje: nombre, nombre original, imagen, datos básicos y descripción.
 * Tiene scroll vertical para las descripciones.
 *
 * @param personaje personaje que se muestra.
 */
@Composable
fun CharacterDetail(
    personaje: Character,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
    ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(
                    start = 10.dp,
                    top = 10.dp
                )
            ) {
                Text(
                    text = personaje.nombre,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )

                Spacer(Modifier.width(10.dp))

                Text(text = "(${personaje.real})")
            }

            HorizontalDivider(
                thickness = 2.dp,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // IMAGEN
                Image(
                    painter = painterResource(id = personaje.imagen),
                    contentDescription = personaje.nombre,
                    modifier = Modifier
                        .size(210.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Fit
                )

                // DATOS
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    InfoRow(label = stringResource(id = R.string.edad), value = personaje.edad)
                    InfoRow(label = stringResource(id = R.string.genero), value = personaje.genero)
                    InfoRow(label = stringResource(id = R.string.especie), value = personaje.especie)
                }
            }

        Spacer(Modifier.height(15.dp))

        Text(
            text = stringResource(id = R.string.info),
            fontSize = 30.sp,
            modifier = Modifier.padding(10.dp)
        )

        Text(
            text = personaje.info,
            fontSize = 17.sp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
            textAlign = TextAlign.Justify
        )
    }
}

/**
 * Fila con una etiqueta en negrita y su valor, alineados por la base del texto
 * aunque tengan distinto tamaño de letra.
 *
 * @param label nombre del dato.
 * @param value valor del dato.
 */
@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier= Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = Color.Black,
            modifier = Modifier
                .width(110.dp)
                .alignByBaseline(),
            textAlign = TextAlign.Start
        )

        Text(
            text = value,
            fontSize = 20.sp,
            color = Color.DarkGray,
            modifier = Modifier
                .weight(1f)
                .alignByBaseline(),
        )
    }
}