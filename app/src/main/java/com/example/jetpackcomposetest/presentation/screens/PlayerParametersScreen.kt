package com.example.jetpackcomposetest.presentation.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.example.jetpackcomposetest.R
import com.example.jetpackcomposetest.textSizeResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcomposetest.presentation.viewmodel.ParametersViewModel

@Composable
fun PlayerParametersScreen(navController: NavController) {

    val focusManager = LocalFocusManager.current
    val viewModel = viewModel<ParametersViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable { focusManager.clearFocus() },

        ) {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.player_parameters),
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
                    TextField(
                        value = attack,
                        onValueChange = {
                            if (it.length <= 2) attack = it
                            isAttackFieldError = false
                            validateAttackField(attack)
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.attack_parameter),
                                color = colorResource(id = R.color.silver_chalice)
                            )
                        },
                        trailingIcon = {
                            if (isAttackFieldError)
                                Icon(
                                    Icons.Filled.Info,
                                    stringResource(id = R.string.edit_text_parameters_error),
                                    tint = MaterialTheme.colors.error
                                )
                        },
                        singleLine = true,
                        isError = isAttackFieldError,
                        keyboardActions = KeyboardActions(onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = dimensionResource(id = R.dimen.padding_16dp),
                                vertical = dimensionResource(id = R.dimen.padding_16dp)
                            )
                            .background(colorResource(id = R.color.control)),
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = colorResource(id = R.color.hh_color)
                        )
                    )
                    if (isAttackFieldError) {
                        Text(
                            text = stringResource(id = R.string.edit_text_parameters_error),
                            color = MaterialTheme.colors.error,
                            fontSize = textSizeResource(id = R.dimen.regular_text_size),
                            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_32dp))
                        )
                    }

                    TextField(
                        value = protection,
                        onValueChange = {
                            if (it.length <= 2) protection = it
                            isProtectionFieldError = false
                            validateProtectionField(protection)
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.protection_parameter),
                                color = colorResource(id = R.color.silver_chalice)
                            )
                        },
                        trailingIcon = {
                            if (isProtectionFieldError)
                                Icon(
                                    Icons.Filled.Info,
                                    stringResource(id = R.string.edit_text_parameters_error),
                                    tint = MaterialTheme.colors.error
                                )
                        },
                        singleLine = true,
                        isError = isProtectionFieldError,
                        keyboardActions = KeyboardActions(onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = dimensionResource(id = R.dimen.padding_16dp),
                                vertical = dimensionResource(id = R.dimen.padding_16dp)
                            )
                            .background(colorResource(id = R.color.control)),
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = colorResource(id = R.color.hh_color)
                        )
                    )
                    if (isProtectionFieldError) {
                        Text(
                            text = stringResource(id = R.string.edit_text_parameters_error),
                            color = MaterialTheme.colors.error,
                            fontSize = textSizeResource(id = R.dimen.regular_text_size),
                            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_32dp))
                        )
                    }

                    TextField(
                        value = health,
                        onValueChange = {
                            if (it.length <= 3) health = it
                            isHealthFieldError = false
                            validateHealthField(health)
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.health_parameter),
                                color = colorResource(id = R.color.silver_chalice)
                            )
                        },
                        trailingIcon = {
                            if (isHealthFieldError)
                                Icon(
                                    Icons.Filled.Info,
                                    stringResource(id = R.string.edit_text_parameters_error),
                                    tint = MaterialTheme.colors.error
                                )
                        },
                        singleLine = true,
                        isError = isHealthFieldError,
                        keyboardActions = KeyboardActions(onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = dimensionResource(id = R.dimen.padding_16dp),
                                vertical = dimensionResource(id = R.dimen.padding_16dp)
                            )
                            .background(colorResource(id = R.color.control)),
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = colorResource(id = R.color.hh_color)
                        )
                    )
                    if (isHealthFieldError) {
                        Text(
                            text = stringResource(id = R.string.edit_text_parameters_error),
                            color = MaterialTheme.colors.error,
                            fontSize = textSizeResource(id = R.dimen.regular_text_size),
                            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_32dp))
                        )
                    }

                    TextField(
                        value = minDamage,
                        onValueChange = {
                            if (it.length <= 1) minDamage = it
                            isMinDamageFieldError = false
                            validateMinDamageField(minDamage)
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.min_damage),
                                color = colorResource(id = R.color.silver_chalice)
                            )
                        },
                        trailingIcon = {
                            if (isMinDamageFieldError)
                                Icon(
                                    Icons.Filled.Info,
                                    stringResource(id = R.string.edit_text_parameters_error),
                                    tint = MaterialTheme.colors.error
                                )
                        },
                        singleLine = true,
                        isError = isMinDamageFieldError,
                        keyboardActions = KeyboardActions(onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = dimensionResource(id = R.dimen.padding_16dp),
                                vertical = dimensionResource(id = R.dimen.padding_16dp)
                            )
                            .background(colorResource(id = R.color.control)),
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = colorResource(id = R.color.hh_color)
                        )
                    )
                    if (isMinDamageFieldError) {
                        Text(
                            text = stringResource(id = R.string.edit_text_parameters_error),
                            color = MaterialTheme.colors.error,
                            fontSize = textSizeResource(id = R.dimen.regular_text_size),
                            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_32dp))
                        )
                    }

                    TextField(
                        value = maxDamage,
                        onValueChange = {
                            if (it.length <= 1) maxDamage = it
                            isMaxDamageFieldError = false
                            validateMaxDamageField(maxDamage)
                        },
                        label = {
                            Text(
                                text = stringResource(id = R.string.max_damage),
                                color = colorResource(id = R.color.silver_chalice)
                            )
                        },
                        trailingIcon = {
                            if (isMaxDamageFieldError)
                                Icon(
                                    Icons.Filled.Info,
                                    stringResource(id = R.string.edit_text_parameters_error),
                                    tint = MaterialTheme.colors.error
                                )
                        },
                        singleLine = true,
                        isError = isMaxDamageFieldError,
                        keyboardActions = KeyboardActions(onDone = {
                            focusManager.clearFocus()
                        }),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = dimensionResource(id = R.dimen.padding_16dp),
                                vertical = dimensionResource(id = R.dimen.padding_16dp)
                            )
                            .background(colorResource(id = R.color.control)),
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = colorResource(id = R.color.hh_color)
                        )
                    )
                    if (isMaxDamageFieldError) {
                        Text(
                            text = stringResource(id = R.string.edit_text_parameters_error),
                            color = MaterialTheme.colors.error,
                            fontSize = textSizeResource(id = R.dimen.regular_text_size),
                            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_32dp))
                        )
                    }

                    Button(
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.hh_color),
                            disabledBackgroundColor = colorResource(id = R.color.btn_primary_disabled)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = dimensionResource(id = R.dimen.padding_16dp))
                            .padding(bottom = dimensionResource(id = R.dimen.padding_16dp))
                            .padding(top = dimensionResource(id = R.dimen.padding_16dp)),
                        onClick = {
                            navController.navigateUp()
                        },
                        enabled = btnApplyIsEnable()
                    ) {
                        Text(
                            text = stringResource(id = R.string.apply),
                            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_8dp)),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}