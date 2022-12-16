package com.example.jetpackcomposetest.presentation.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

@Composable
fun MonsterParametersScreen(navController: NavController) {

    val focusManager = LocalFocusManager.current
    val attack = remember { mutableStateOf("") }
    val protection = remember { mutableStateOf("") }
    val health = remember { mutableStateOf("") }
    val minDamage = remember { mutableStateOf("") }
    val maxDamage = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable { focusManager.clearFocus() }
    ) {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.bug_parameters),
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
                painter = painterResource(id = R.drawable.bug),
                contentDescription = "",
                modifier = Modifier
                    .padding(vertical = dimensionResource(id = R.dimen.padding_32dp))
                    .size(dimensionResource(id = R.dimen.image_size)),
                alignment = Alignment.Center
            )

            Text(
                text = stringResource(id = R.string.bug_description),
                color = colorResource(id = R.color.gray),
                fontSize = textSizeResource(id = R.dimen.medium_text_size),
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_16dp)),
            )

            TextField(
                value = attack.value,
                onValueChange = { attack.value = it },
                label = { Text(text = stringResource(id = R.string.attack_parameter),
                    color = colorResource(id = R.color.silver_chalice)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                singleLine = true,
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
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

            TextField(
                value = protection.value,
                onValueChange = { protection.value = it },
                label = { Text(text = stringResource(id = R.string.protection_parameter),
                    color = colorResource(id = R.color.silver_chalice)
                ) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                singleLine = true,
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
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

            TextField(
                value = health.value,
                onValueChange = { health.value = it },
                label = { Text(text = stringResource(id = R.string.health_parameter),
                    color = colorResource(id = R.color.silver_chalice)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                singleLine = true,
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
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

            TextField(
                value = minDamage.value,
                onValueChange = { minDamage.value = it },
                label = { Text(text = stringResource(id = R.string.min_damage),
                    color = colorResource(id = R.color.silver_chalice)) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                singleLine = true,
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }),
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

            TextField(
                value = maxDamage.value,
                onValueChange = { maxDamage.value = it },
                label = { Text(text = stringResource(id = R.string.max_damage),
                    color = colorResource(id = R.color.silver_chalice)) },
                singleLine = true,
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }),
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
                enabled = false
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