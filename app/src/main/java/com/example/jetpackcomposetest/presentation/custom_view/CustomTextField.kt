package com.example.jetpackcomposetest.presentation.custom_view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.jetpackcomposetest.R
import com.example.jetpackcomposetest.textSizeResource

@Composable
fun CustomTextField(
    value: String,
    error: Boolean,
    labelText: String,
    onValueChange: (String) -> Unit,
    focusManager: FocusManager = LocalFocusManager.current,
    keyboardActions: KeyboardActions = KeyboardActions(onNext = {
        focusManager.moveFocus(FocusDirection.Down)
    }),
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Number,
        imeAction = ImeAction.Next
    )
) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = labelText,
                color = colorResource(id = R.color.silver_chalice)
            )
        },
        trailingIcon = {
            if (error)
                Icon(
                    Icons.Filled.Info,
                    stringResource(id = R.string.edit_text_parameters_error),
                    tint = MaterialTheme.colors.error
                )
        },
        singleLine = true,
        isError = error,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
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
    if (error) {
        Text(
            text = stringResource(id = R.string.edit_text_parameters_error),
            color = MaterialTheme.colors.error,
            fontSize = textSizeResource(id = R.dimen.regular_text_size),
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_32dp))
        )
    }
}