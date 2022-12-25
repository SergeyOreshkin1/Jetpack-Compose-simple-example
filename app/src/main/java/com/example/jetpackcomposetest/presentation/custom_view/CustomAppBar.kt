package com.example.jetpackcomposetest.presentation.custom_view

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.jetpackcomposetest.R
import com.example.jetpackcomposetest.textSizeResource

@Composable
fun CustomAppBar(
    navController: NavController,
    text: String
) {
    TopAppBar(
        title = {
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = textSizeResource(id = R.dimen.large_text_size),
                color = colorResource(id = R.color.black)
            )
        },
        backgroundColor = colorResource(id = R.color.hh_color),
        navigationIcon = {
            IconButton(onClick = {
                navController.navigateUp()
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Navigation icon",
                    tint = colorResource(
                        id = R.color.black
                    )
                )
            }
        }
    )
}