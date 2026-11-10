package com.example.master

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.master.components.CharacterDetail
import com.example.master.components.CharacterList
import com.example.master.components.EmptyDetail
import com.example.master.components.HomeTopBar
import com.example.master.components.Info
import com.example.master.model.Character

/**
 * Pantalla principal de la app: lista de personajes a la izquierda y detalle a la derecha.
 *
 * Guarda el estado de la pantalla:
 * - `seleccionada`: personaje elegido en la lista (`null` si no hay ninguno).
 * - `mostrarInfo`: indica si se ve la ventana de perfil.
 *
 * Si no hay personaje seleccionado muestra EmptyDetail; si no lo hay CharacterDetail.
 * El botón flotante abre la ventana Info por encima del contenido, sin cubrir la barra superior.
 */
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    var seleccionada by remember { mutableStateOf<Character?>(null) }
    var mostrarInfo by remember { mutableStateOf(false)}


    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        HomeTopBar()

        Box(modifier = Modifier.fillMaxSize()) {

            Row(modifier = Modifier.fillMaxSize()) {

                CharacterList(
                    seleccionada = seleccionada,
                    onSelect = { seleccionada = it }
                )

                val personaje = seleccionada
                if (personaje == null) {
                    EmptyDetail(modifier = Modifier.weight(1f))
                } else {
                    CharacterDetail(
                        personaje = personaje,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            FloatingActionButton(
                onClick = {
                    mostrarInfo = true
                },
                contentColor = colorResource(id = R.color.degradado1),
                containerColor = colorResource(id = R.color.sticky),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            }

            if(mostrarInfo) {
                Info(onDismiss = { mostrarInfo = false })
            }
        }
    }
}

@Preview(showBackground = true,
    device = "spec:width=891dp,height=441dp,orientation=landscape")
@Composable
fun HomeScreenPreview() {
    AppContent { modifier -> HomeScreen(modifier) }
}