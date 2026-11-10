package com.example.master.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.master.R
import com.example.master.model.Character
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.remember
import com.example.master.model.Character.Companion.characters

/**
 * Lista de personajes ordenada alfabéticamente y agrupada por inicial.
 * Cada grupo tiene una cabecera fija (stickyHeader) que se queda arriba al hacer scroll.
 *
 * @param seleccionada personaje elegido actualmente; se resalta y lleva un icono de check.
 * @param onSelect se ejecuta con el personaje pulsado, para que quien la use actualice su estado.
 */
@Composable
fun CharacterList(
    seleccionada: Character?,
    onSelect: (Character) -> Unit,
    modifier: Modifier = Modifier
) {
    val agrupadas = remember {characters.sortedBy{it.nombre}
        .groupBy{it.nombre.first().uppercaseChar()}
    }

    LazyColumn(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start,
        userScrollEnabled = true,
        modifier = Modifier
            .width(180.dp)

    ) {
        agrupadas.forEach { (inicial, lista) ->
            stickyHeader(key = inicial) {
                Text(
                    text = inicial.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(id = R.color.sticky))
                        .padding(vertical = 5.dp),
                    textAlign = TextAlign.Center
                )

                HorizontalDivider(
                    thickness = 1.dp,
                    color = colorResource(id = R.color.moradoOscuro)
                )
            }

            items(lista, key = { it.id }) { character ->
                val estaSeleccionado = seleccionada?.id == character.id

                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                        .background(
                            if (estaSeleccionado)
                                colorResource(id = R.color.seleccionado)
                            else
                                Color.Transparent,
                        )
                        .padding(
                            start = 10.dp,
                            top = 5.dp,
                            bottom = 5.dp
                        )
                        .clickable {
                            onSelect(character)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (estaSeleccionado) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null
                        )
                    }

                    Text(
                        text = character.nombre
                    )
                }
            }
        }
    }
}