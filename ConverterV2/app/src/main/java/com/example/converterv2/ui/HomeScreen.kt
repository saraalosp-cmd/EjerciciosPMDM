package com.example.converterv2.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.converterv2.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val borderWidth = 4.dp
    var numero by remember {mutableStateOf("")}
    var switch by remember {mutableStateOf(false)}
    var resultado by remember {mutableStateOf("")}

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),

        ) {
        // Columna imagen y nombre
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.turbogranny),
                contentDescription = stringResource(id = R.string.turbo),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .border(
                        BorderStroke(borderWidth, colorResource(id = R.color.azul)),
                        CircleShape
                    )
                    .background(colorResource(id= R.color.amarillo), CircleShape)
                    .padding(borderWidth)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                stringResource(id = R.string.nombre),
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        HorizontalDivider(
            thickness = 2.dp,
            color = colorResource(id = R.color.amarillo)
        )

        Spacer(modifier = Modifier.height(15.dp))

        // Número entero
        Text (
            text = stringResource(R.string.introduce),
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = numero,
            onValueChange = {nuevoNum ->
                if (nuevoNum.all {it.isDigit()}) {
                    numero = nuevoNum
                }
            },
            label = {Text(stringResource(id= R.string.numero))},
            leadingIcon = {
                Icon (
                    imageVector = Icons.Default.Tag,
                    contentDescription = "Tag"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Switch
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Card (
                colors = CardDefaults.cardColors(
                    containerColor = if (switch) colorResource(id = R.color.azul)
                    else Color.Transparent,
                    contentColor = if (switch) colorResource(id = R.color.white)
                    else MaterialTheme.colorScheme.onSurface
                )
            ) {
                Text(
                    text = stringResource(id = R.string.aDec),
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Switch(
                checked = switch,
                onCheckedChange = {
                    switch = it
                }
            )

            Spacer(modifier = Modifier.width(10.dp))

            Card (
                colors = CardDefaults.cardColors(
                    containerColor = if (!switch) colorResource(id = R.color.azul)
                                    else Color.Transparent,
                    contentColor = if (!switch) colorResource(id = R.color.white)
                                    else MaterialTheme.colorScheme.onSurface
                )
            ) {
                Text(
                    text = stringResource(id = R.string.aBin),
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                )
            }
        }

        // Resultado
        Text (
            text = stringResource(id = R.string.conver)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text (
            text = stringResource(id = R.string.resul, resultado)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Botones
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Convertir
            Button (
                onClick = {
                    val num = if (switch) numero.toIntOrNull(2) else numero.toIntOrNull()

                    resultado = if (num == null) {
                        "Número no válido"
                    } else if (switch) {
                        num.toString()
                    } else {
                        num.toString(2)
                    }
                },
                enabled = numero.isNotEmpty(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.azul),

                )
            ) {
                Text(
                    text = stringResource(id = R.string.convertir)
                )
            }

            Spacer(modifier = Modifier.width(15.dp))

            // Borrar
            Button (
                onClick = {
                    numero = ""
                    resultado = ""
                },
                enabled = numero.isNotEmpty() || resultado.isNotEmpty(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.azul),

                )
            ) {
                Text(
                    text = stringResource(id = R.string.borrar)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AppContent { modifier -> HomeScreen(modifier) }
}