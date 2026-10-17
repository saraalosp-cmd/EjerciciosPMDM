package com.example.profileyou.ui


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.PersonAddAlt1
import androidx.compose.material.icons.filled.PersonRemove
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SportsMartialArts
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profileyou.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    // Imagen
    val borderWidth = 4.dp
    var siguiendo by remember { mutableStateOf (false)}
    var seleccionadoIzq by remember {mutableStateOf(false)}
    var seleccionadoDcha by remember {mutableStateOf(false)}
    var mensajes by remember {mutableIntStateOf(0)}

    // COLUMNA PPAL
    Column(
        // con minúscula recibe el modifier de AppContent
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // IMAGEN Y DATOS
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.okarun),
                contentDescription = stringResource(id = R.string.okarun),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .border(
                        BorderStroke(borderWidth, colorResource(id= R.color.rojo)),
                        CircleShape
                    )
                    .padding(borderWidth)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {

                Text(
                    stringResource(id = R.string.nombre),
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // follow
                    Button(
                        onClick = {
                            siguiendo = !siguiendo
                        },
                        border = if (siguiendo) BorderStroke(2.dp,
                            colorResource(id = R.color.moradoOscuro)) else null,
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (siguiendo) colorResource(id = R.color.fondo)
                                    else colorResource(id = R.color.moradoClaro)
                        )

                    ) {
                        Icon(
                            imageVector = if (siguiendo) Icons.Default.PersonRemove
                                    else Icons.Default.PersonAddAlt1,
                            contentDescription = null,
                            tint = colorResource(id = R.color.black),
                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = if (siguiendo) stringResource(id = R.string.dejarSeguir) else stringResource(id = R.string.seguir),
                            color = colorResource(id = R.color.black),
                            maxLines = 1
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    // correo
                    BadgedBox(
                        badge = {
                            Badge {
                                Text(stringResource(id = R.string.mensajes, mensajes))
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Mail,
                            contentDescription = "Mail"
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        HorizontalDivider(
            thickness = 2.dp,
            color = colorResource(id = R.color.rojo)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // HOBBIES
        Column(
            modifier = Modifier.padding(start = 35.dp),
        ) {
            Text (
                text = stringResource(id = R.string.hobbies),
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp,
            )

            Spacer(modifier = Modifier.height(2.dp))

            Row (
                modifier = Modifier.padding(horizontal = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon (
                    imageVector = Icons.Default.Search,
                    contentDescription = "Android",
                    tint = colorResource(id = R.color.rojo)
                )

                Text (
                    text = stringResource(id = R.string.hobbie1)
                )
            }

            Spacer(modifier = Modifier.height(3.dp))

            Row (
                modifier = Modifier.padding(horizontal = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon (
                    imageVector = Icons.Default.Android,
                    contentDescription = "Android",
                    tint = colorResource(id = R.color.rojo)
                )

                Text (
                    text = stringResource(id = R.string.hobbie2)
                )
            }

            Spacer(modifier = Modifier.height(3.dp))

            Row (
                modifier = Modifier.padding(horizontal = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon (
                    imageVector = Icons.Default.AutoStories,
                    contentDescription = "Android",
                    tint = colorResource(id = R.color.rojo)
                )

                Text (
                    text = stringResource(id = R.string.hobbie3)
                )
            }

            Spacer(modifier = Modifier.height(3.dp))

            Row (
                modifier = Modifier.padding(horizontal = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon (
                    imageVector = Icons.Default.Quiz,
                    contentDescription = "Android",
                    tint = colorResource(id = R.color.rojo)
                )

                Text (
                    text = stringResource(id = R.string.hobbie4)
                )
            }

            Spacer(modifier = Modifier.height(3.dp))

            Row (
                modifier = Modifier.padding(horizontal = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon (
                    imageVector = Icons.Default.SportsMartialArts,
                    contentDescription = "Android",
                    tint = colorResource(id = R.color.rojo)
                )

                Text (
                    text = stringResource(id = R.string.hobbie5)
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        HorizontalDivider(
            thickness = 2.dp,
            color = colorResource(id = R.color.rojo)
        )

        Spacer(modifier = Modifier.height(40.dp))
        
        // IMAGENES
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box (

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ok1),
                    contentDescription = stringResource(id = R.string.okarun),
                    modifier = Modifier
                        .size(150.dp)
                )

                IconToggleButton(
                    checked = seleccionadoIzq,
                    onCheckedChange = { seleccionadoIzq = !seleccionadoIzq},
                    modifier= Modifier.align(Alignment.BottomEnd)
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Like",
                        tint = if (seleccionadoIzq) colorResource(id = R.color.rojo) else colorResource(id = R.color.black),
                        modifier = Modifier.size(40.dp)
                    )
                }
            }


            Box (

            ) {

                Image(
                    painter = painterResource(id = R.drawable.oka),
                    contentDescription = stringResource(id = R.string.okarun),
                    modifier = Modifier
                        .size(150.dp)
                )

                IconToggleButton(
                    checked = seleccionadoDcha,
                    onCheckedChange = { seleccionadoDcha = !seleccionadoDcha},
                    modifier= Modifier.align(Alignment.BottomEnd)
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Like",
                        tint = if (seleccionadoDcha) colorResource(id = R.color.rojo) else colorResource(id = R.color.black),
                        modifier = Modifier.size(40.dp)
                    )
                }
            }

        }

        Spacer(modifier = Modifier.height(30.dp))

        Button (
            onClick = {
                mensajes++
            },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.moradoOscuro)
            )

        ) {
            Text (
                text = stringResource(id = R.string.add, 1)
            )
        }
    }
}

@Preview(showBackground =true)
@Composable
fun HomeScreenPreview() {
    AppContent { modifier -> HomeScreen(modifier,)}
}