package com.example.jetpackcomposetest.presentation.custom_view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import com.example.jetpackcomposetest.R

@Composable
fun ParametersContainer(
    onClickBtn: () -> Unit,
    textBtn: String,
    imagePainter: Painter
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(id = R.dimen.padding_16dp)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.hh_color),
            ),
            modifier = Modifier
                .weight(1f),
            onClick = onClickBtn
        ) {
            Text(
                text = textBtn,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_8dp)),
                fontWeight = FontWeight.Bold
            )
        }

        Image(
            painter = imagePainter,
            contentDescription = "",
            modifier = Modifier
                .padding(start = dimensionResource(id = R.dimen.padding_16dp))
                .size(dimensionResource(id = R.dimen.image_size_small))
        )
    }
}