package com.example.jetpackcomposetest.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.jetpackcomposetest.navigation.Screens
import com.example.jetpackcomposetest.R
import com.example.jetpackcomposetest.textSizeResource

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(horizontal = dimensionResource(id = R.dimen.padding_16dp))
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.hh_logo),
            contentDescription = "",
            modifier = Modifier
                .padding(vertical = dimensionResource(id = R.dimen.padding_16dp))
                .size(dimensionResource(id = R.dimen.image_size)),
            alignment = Alignment.Center
        )

        Text(
            text = stringResource(id = R.string.prompt),
            fontSize = textSizeResource(id = R.dimen.medium_text_size),
            textAlign = TextAlign.Center
        )

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
                onClick = {
                    navController.navigate(Screens.PlayerParameters.route) {
                        launchSingleTop = true
                    }
                }
            ) {
                Text(
                    text = stringResource(id = R.string.player_create),
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_8dp)),
                    fontWeight = FontWeight.Bold
                )
            }

            Image(
                painter = painterResource(id = R.drawable.ic_check_mark_default),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = dimensionResource(id = R.dimen.padding_16dp))
                    .size(dimensionResource(id = R.dimen.image_size_small))
            )
        }

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
                onClick = {
                    navController.navigate(Screens.MonsterParameters.route) {
                        launchSingleTop = true
                    }
                }
            ) {
                Text(
                    text = stringResource(id = R.string.monster_create),
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_8dp)),
                    fontWeight = FontWeight.Bold
                )
            }

            Image(
                painter = painterResource(id = R.drawable.ic_check_mark_default),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = dimensionResource(id = R.dimen.padding_16dp))
                    .size(dimensionResource(id = R.dimen.image_size_small))
            )
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.hh_color),
                disabledBackgroundColor = colorResource(id = R.color.btn_primary_disabled)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.padding_16dp)),
            onClick = {
                navController.navigate(Screens.StartGame.route) {
                    launchSingleTop = true
                }
            },
            enabled = false
        ) {
            Text(
                text = stringResource(id = R.string.start_game),
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_8dp)),
                fontWeight = FontWeight.Bold
            )
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.hh_color),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.padding_16dp)),
            onClick = {
                navController.navigate(Screens.GameRules.route) {
                    launchSingleTop = true
                }
            },
        ) {
            Text(
                text = stringResource(id = R.string.game_rules),
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_8dp)),
                fontWeight = FontWeight.Bold
            )
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.hh_color),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(id = R.dimen.padding_16dp)),
            onClick = {
                navController.navigate(Screens.JetpackExample.route) {
                    launchSingleTop = true
                }
            },
        ) {
            Text(
                text = stringResource(id = R.string.compose_example),
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_8dp)),
                fontWeight = FontWeight.Bold
            )
        }
    }
}