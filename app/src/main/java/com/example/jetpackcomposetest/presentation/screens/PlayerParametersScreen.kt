package com.example.jetpackcomposetest.presentation.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.example.jetpackcomposetest.R
import com.example.jetpackcomposetest.textSizeResource
import com.example.jetpackcomposetest.data.Player
import com.example.jetpackcomposetest.presentation.custom_view.CustomAppBar
import com.example.jetpackcomposetest.presentation.custom_view.CustomButton
import com.example.jetpackcomposetest.presentation.custom_view.CustomTextField
import com.example.jetpackcomposetest.presentation.viewmodel.ParametersViewModel

@Composable
fun PlayerParametersScreen(navController: NavController, viewModel: ParametersViewModel) {

    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable(interactionSource = interactionSource,indication = null) {
                focusManager.clearFocus()
            }
    ) {

        CustomAppBar(
            navController = navController,
            text = stringResource(id = R.string.player_parameters)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            Image(
                painter = painterResource(id = R.drawable.player),
                contentDescription = "",
                alignment = Alignment.Center,
                modifier = Modifier
                    .padding(vertical = dimensionResource(id = R.dimen.padding_32dp))
                    .size(dimensionResource(id = R.dimen.image_size)),
            )

            Text(
                text = stringResource(id = R.string.player_description),
                color = colorResource(id = R.color.gray),
                fontSize = textSizeResource(id = R.dimen.medium_text_size),
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_16dp)),
            )

            Column {
                Text(
                    modifier = Modifier
                        .padding(top = dimensionResource(id = R.dimen.padding_16dp))
                        .padding(start = dimensionResource(id = R.dimen.padding_16dp)),
                    text = stringResource(id = R.string.special_skill_title),
                    color = colorResource(id = R.color.gray),
                    fontSize = textSizeResource(id = R.dimen.medium_text_size),
                    fontWeight = FontWeight.Bold,
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.java_emblem),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = dimensionResource(id = R.dimen.padding_16dp))
                            .size(dimensionResource(id = R.dimen.image_size_medium)),
                    )

                    Text(
                        text = stringResource(id = R.string.special_skill),
                        color = colorResource(id = R.color.green),
                        fontSize = textSizeResource(id = R.dimen.medium_text_size)
                    )
                }
            }
            Column()
            {
                with(viewModel) {

                    CustomTextField(
                        value = attack,
                        error = isAttackFieldError,
                        labelText = stringResource(id = R.string.attack_parameter),
                        onValueChange = {
                            if (it.length <= 2) attack = it
                            isAttackFieldError = false
                            validateAttackField(attack)
                        }
                    )

                    CustomTextField(
                        value = protection,
                        error = isProtectionFieldError,
                        labelText = stringResource(id = R.string.protection_parameter),
                        onValueChange = {
                            if (it.length <= 2) protection = it
                            isProtectionFieldError = false
                            validateProtectionField(protection)
                        }
                    )

                    CustomTextField(
                        value = health,
                        error = isHealthFieldError,
                        labelText = stringResource(id = R.string.health_parameter),
                        onValueChange = {
                            if (it.length <= 3) health = it
                            isHealthFieldError = false
                            validateHealthField(health)
                        }
                    )

                    CustomTextField(
                        value = minDamage,
                        error = isMinDamageFieldError,
                        labelText = stringResource(id = R.string.min_damage),
                        onValueChange = {
                            if (it.length <= 1) minDamage = it
                            isMinDamageFieldError = false
                            validateMinDamageField(minDamage)
                        }
                    )

                    CustomTextField(
                        value = maxDamage,
                        error = isMaxDamageFieldError,
                        labelText = stringResource(id = R.string.max_damage),
                        onValueChange = {
                            if (it.length <= 1) maxDamage = it
                            isMaxDamageFieldError = false
                            validateMaxDamageField(maxDamage)
                        },
                        keyboardActions = KeyboardActions(onDone = {
                            focusManager.clearFocus()
                        }),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                        )
                    )

                    CustomButton(
                        onClick = {
                            addPlayer(
                                Player(
                                    attack = attack.toInt(),
                                    protection = protection.toInt(),
                                    health = health.toInt(),
                                    minDamage = minDamage.toInt(),
                                    maxDamage = maxDamage.toInt(),
                                    maxHealth = health.toInt()
                                )
                            )
                            focusManager.clearFocus()
                            navController.navigateUp()
                        },
                        text = stringResource(id = R.string.apply),
                        enabled = btnApplyIsEnable(),
                        bottomPadding = dimensionResource(id = R.dimen.padding_16dp),
                        horizontalPadding = dimensionResource(id = R.dimen.padding_16dp)
                    )
                }
            }
        }
    }
}