package com.example.jetpackcomposetest.presentation.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.jetpackcomposetest.navigation.Screens
import com.example.jetpackcomposetest.R
import com.example.jetpackcomposetest.presentation.custom_view.CustomButton
import com.example.jetpackcomposetest.presentation.custom_view.ParametersContainer
import com.example.jetpackcomposetest.presentation.viewmodel.ParametersViewModel
import com.example.jetpackcomposetest.textSizeResource
import com.example.jetpackcomposetest.utils.AppConstants

@Composable
fun MainScreen(navController: NavController, viewModel: ParametersViewModel) {

    val checkMarkImagePlayer = remember {
        mutableStateOf(R.drawable.ic_check_mark_default)
    }

    val checkMarkImageBug = remember {
        mutableStateOf(R.drawable.ic_check_mark_default)
    }

    val player = viewModel.player
    val bug = viewModel.bug

    @Composable
    fun checkStartGameEnabled() {
        LaunchedEffect(key1 = player, key2 = bug) {
            player?.let {
                checkMarkImagePlayer.value = R.drawable.ic_check_mark_apply
            }
            bug?.let {
                checkMarkImageBug.value = R.drawable.ic_check_mark_apply
            }
            Log.d("param", "$player")
            Log.d("param", "$bug")
        }
    }

    checkStartGameEnabled()

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
                .padding(vertical = dimensionResource(id = R.dimen.padding_32dp))
                .size(dimensionResource(id = R.dimen.image_size)),
            alignment = Alignment.Center
        )

        Text(
            text = stringResource(id = R.string.prompt),
            fontSize = textSizeResource(id = R.dimen.medium_text_size),
            textAlign = TextAlign.Center
        )

        ParametersContainer(
            onClickBtn = {
                navController.navigate(Screens.PlayerParameters.route) {
                    launchSingleTop = true
                }
            },
            textBtn = stringResource(id = R.string.player_create),
            imagePainter = painterResource(checkMarkImagePlayer.value)
        )

        ParametersContainer(
            onClickBtn = {
                navController.navigate(Screens.MonsterParameters.route) {
                    launchSingleTop = true
                }
            },
            textBtn = stringResource(id = R.string.monster_create),
            imagePainter = painterResource(checkMarkImageBug.value)
        )

        CustomButton(
            onClick = {
                navController.run {
                    currentBackStackEntry
                        ?.savedStateHandle
                        ?.set(
                            key = AppConstants.BUNDLE_KEY_PLAYER,
                            player
                        )
                    currentBackStackEntry
                        ?.savedStateHandle
                        ?.set(
                            key = AppConstants.BUNDLE_KEY_MONSTER,
                            bug
                        )
                    navigate(Screens.StartGame.route) {
                        launchSingleTop = true
                    }
                }
            },
            text = stringResource(id = R.string.start_game),
            enabled = player != null && bug != null
        )

        CustomButton(
            onClick = {
                navController.navigate(Screens.GameRules.route) {
                    launchSingleTop = true
                }
            },
            text = stringResource(id = R.string.game_rules),
        )

        CustomButton(
            onClick = {
                navController.navigate(Screens.JetpackExample.route) {
                    launchSingleTop = true
                }
            },
            text = stringResource(id = R.string.compose_example),
            bottomPadding = dimensionResource(id = R.dimen.padding_16dp)
        )
    }
}