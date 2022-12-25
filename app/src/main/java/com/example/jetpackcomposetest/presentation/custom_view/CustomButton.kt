package com.example.jetpackcomposetest.presentation.custom_view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import com.example.jetpackcomposetest.R

@Composable
fun CustomButton(
    onClick: () -> Unit,
    text: String,
    bottomPadding: Dp = dimensionResource(id = R.dimen.padding_0dp),
    topPadding: Dp = dimensionResource(id = R.dimen.padding_16dp),
    horizontalPadding: Dp = dimensionResource(id = R.dimen.padding_0dp),
    enabled: Boolean = true,
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.hh_color),
            disabledBackgroundColor = colorResource(id = R.color.btn_primary_disabled)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = topPadding)
            .padding(bottom = bottomPadding)
            .padding(horizontal = horizontalPadding),
        enabled = enabled,
        onClick = onClick,

        ) {
        Text(
            text = text,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_8dp)),
            fontWeight = FontWeight.Bold
        )
    }
}