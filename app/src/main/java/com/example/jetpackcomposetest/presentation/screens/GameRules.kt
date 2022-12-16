package com.example.jetpackcomposetest.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.jetpackcomposetest.R
import com.example.jetpackcomposetest.textSizeResource

@Composable
fun GameRules(navController: NavController) {

    Column {

        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.game_rules),
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

        Text(
            text = stringResource(id = R.string.game_rules_text),
            color = colorResource(id = R.color.gray),
            fontSize = textSizeResource(
                id = R.dimen.medium_text_size
            ),
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.padding_16dp))
                .verticalScroll(
                    rememberScrollState()
                )
                .padding(top = dimensionResource(id = R.dimen.padding_16dp))
        )
    }

}