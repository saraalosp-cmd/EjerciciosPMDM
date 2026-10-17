package com.example.estadisticas

import android.R.attr.enabled
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.estadisticas.ui.theme.EstadisticasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EstadisticasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(innerPadding)
                }
            }
        }
    }
}


@Composable
fun Content(padding: PaddingValues) {
    var timesPersona by rememberSaveable { mutableStateOf(0) }
    var timesPatinetes by rememberSaveable { mutableStateOf(0) }
    var timesBicicletas by rememberSaveable { mutableStateOf(0) }
    var timesCoches by rememberSaveable { mutableStateOf(0) }
    var habilitado by rememberSaveable {mutableStateOf(false)}
    var timesTotal = timesPersona+timesPatinetes+timesBicicletas+timesCoches

    fun porcentaje (n: Int) = if (timesTotal > 0) n * 100 / timesTotal else 0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
            .padding(padding)
            .padding(horizontal = 16.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text (
            text = stringResource(id = R.string.titulo),
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold,
        )


        // Total: 0 Reiniciar
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text (
                text = stringResource(id = R.string.total, timesTotal),
                fontSize = 22.sp,
            )

            Button(
                onClick = {
                    timesPersona = 0
                    timesPatinetes = 0
                    timesBicicletas = 0
                    timesCoches = 0
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.slate)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.restart),
                )
            }

        }


        // Personas:
        Text (
            text = stringResource(id = R.string.personas),
            fontSize = 15.sp,
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text (
                text = stringResource(id = R.string.totalPersonas, timesPersona),
                fontSize = 15.sp
            )

            Button(
                onClick = {
                    if (timesPersona >= 0)
                        timesPersona++
                    else timesPersona = 0
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.sage)
                ),
            ){
                Text(
                    text = stringResource(id = R.string.añadir)
                )
            }

            Button(
                onClick = {
                    timesPersona --
                },
                colors = ButtonDefaults.buttonColors(
                    disabledContentColor = colorResource(id = R.color.gray_700),
                    containerColor = colorResource(id= R.color.clay)
                ),
                enabled = timesPersona > 0,
                ) {
                Text(
                    text = stringResource(id = R.string.restar)
                )
            }

            Button(
                onClick = {
                    timesPersona = 0
                },
                colors = ButtonDefaults.buttonColors(
                    disabledContentColor = colorResource(id = R.color.gray_700),
                    containerColor = colorResource(id= R.color.slate)
                ),
                enabled = timesPersona > 0,
            ) {
                Text(
                    text = stringResource(id = R.string.reset)
                )
            }
        }


        // Patinetes:

        Text (
            text = stringResource(id = R.string.patinetes),
            fontSize = 15.sp
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text (
                text = stringResource(id = R.string.totalPatinetes, timesPatinetes),
                fontSize = 15.sp
            )

            Button(
                onClick = {
                    if (timesPatinetes >= 0)
                        timesPatinetes++
                    else timesPatinetes = 0
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.sage)
                ),
            ){
                Text(
                    text = stringResource(id = R.string.añadir)
                )
            }

            Button(
                onClick = {
                    timesPatinetes --
                },
                colors = ButtonDefaults.buttonColors(
                    disabledContentColor = colorResource(id = R.color.gray_700),
                    containerColor = colorResource(id= R.color.clay)
                ),
                enabled = timesPatinetes > 0,
            ) {
                Text(
                    text = stringResource(id = R.string.restar)
                )
            }

            Button(
                onClick = {
                    timesPatinetes = 0
                },
                colors = ButtonDefaults.buttonColors(
                    disabledContentColor = colorResource(id = R.color.gray_700),
                    containerColor = colorResource(id= R.color.slate)
                ),
                enabled = timesPatinetes > 0,
            ) {Text(
                    text = stringResource(id = R.string.reset)
                )
            }
        }


        // Bicicletas:

        Text (
            text = stringResource(id = R.string.bicis),
            fontSize = 15.sp
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text (
                text = stringResource(id = R.string.totalBicicletas, timesBicicletas),
                fontSize = 15.sp
            )

            Button(
                onClick = {
                    if (timesBicicletas >= 0)
                        timesBicicletas++
                    else timesBicicletas = 0
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.sage)
                ),
            ){
                Text(
                    text = stringResource(id = R.string.añadir)
                )
            }

            Button(
                onClick = {
                    timesBicicletas --
                },
                colors = ButtonDefaults.buttonColors(
                    disabledContentColor = colorResource(id = R.color.gray_700),
                    containerColor = colorResource(id= R.color.clay)
                ),
                enabled = timesBicicletas > 0,
            ) {
                Text(
                    text = stringResource(id = R.string.restar)
                )
            }

            Button(
                onClick = {
                    timesBicicletas = 0
                },
                colors = ButtonDefaults.buttonColors(
                    disabledContentColor = colorResource(id = R.color.gray_700),
                    containerColor = colorResource(id= R.color.slate)
                ),
                enabled = timesBicicletas > 0,
            ) {Text(
                    text = stringResource(id = R.string.reset)
                )
            }
        }


        // Coches:

        Text (
            text = stringResource(id = R.string.coches),
            fontSize = 15.sp
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text (
                text = stringResource(id = R.string.totalCoches, timesCoches),
                fontSize = 15.sp
            )

            Button(
                onClick = {
                    if (timesCoches >= 0)
                        timesCoches++
                    else timesCoches = 0
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.sage)
                ),
            ){
                Text(
                    text = stringResource(id = R.string.añadir)
                )
            }

            Button(
                onClick = {
                    timesCoches --
                },
                colors = ButtonDefaults.buttonColors(
                    disabledContentColor = colorResource(id = R.color.gray_700),
                    containerColor = colorResource(id= R.color.clay)
                ),
                enabled = timesCoches > 0,
            ) {
                Text(
                    text = stringResource(id = R.string.restar)
                )
            }

            Button(
                onClick = {
                    timesCoches = 0
                },
                colors = ButtonDefaults.buttonColors(
                    disabledContentColor = colorResource(id = R.color.gray_700),
                    containerColor = colorResource(id= R.color.slate)
                ),
                enabled = timesCoches > 0,
            ) {Text(
                    text = stringResource(id = R.string.reset)
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Resultados
        Text (
            text = stringResource(id = R.string.app_name),
            fontWeight = FontWeight.SemiBold,
        )

        Text (
            text = stringResource(
                id = R.string.resulPersonas,
                porcentaje(timesPersona)),
        )

        Text (
            text = stringResource(
                id = R.string.resulPatinetes,
                porcentaje(timesPatinetes)),
        )

        Text (
            text = stringResource(
                id = R.string.resulBicis,
                porcentaje(timesBicicletas)),
        )

        Text (
            text = stringResource(
                id = R.string.resulCoches,
                porcentaje(timesCoches)),
        )
    }
}


@Preview(
    showBackground = true,
    apiLevel = 36
)
@Composable
fun ContentPreview() {
    EstadisticasTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Content(innerPadding)
        }
    }
}