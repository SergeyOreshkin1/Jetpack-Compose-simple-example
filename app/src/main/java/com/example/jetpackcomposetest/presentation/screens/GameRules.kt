package com.example.jetpackcomposetest.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.jetpackcomposetest.R
import com.example.jetpackcomposetest.presentation.custom_view.CustomAppBar
import com.example.jetpackcomposetest.textSizeResource

@Composable
fun GameRules(navController: NavController) {

    Column {

        CustomAppBar(
            navController = navController,
            text = stringResource(id = R.string.game_rules)
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