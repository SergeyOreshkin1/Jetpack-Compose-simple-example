package com.example.jetpackcomposetest

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DimenRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.input.ImeAction.Companion.Next
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.*
import com.example.jetpackcomposetest.ui.theme.CustomItem
import com.example.jetpackcomposetest.data.PersonRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                LoginForm()
                ListItems()
            }
        }
    }
}

@Preview
@Composable
fun LoginForm() {

    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_16dp))
            .verticalScroll(rememberScrollState())
            .clickable { focusManager.clearFocus() },
         verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .background(colorResource(R.color.purple_100))
                .padding(dimensionResource(id = R.dimen.padding_8dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(dimensionResource(id = R.dimen.img_logo_size))
            )
        }

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_16dp)))

        Text(
            text = stringResource(id = R.string.login_form),
            fontWeight = FontWeight.Bold,
            fontSize = textSizeResource(id = R.dimen.login_from_title_size)
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_16dp)))

        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text(text = stringResource(id = R.string.sign_in_email)) },
            placeholder = { Text(text = stringResource(id = R.string.email_placeholder)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = Next
            ),
            singleLine = true,
            keyboardActions = KeyboardActions(onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }),
            modifier = Modifier
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text(text = stringResource(id = R.string.sign_in_password)) },
            placeholder = { Text(text = stringResource(id = R.string.password_placeholder)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
            ),
            keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.padding_16dp))
        )

        Button(
            onClick = {
                if (email.value.isEmpty()) {
                    Toast.makeText(context, R.string.email_toast, Toast.LENGTH_SHORT).show()
                } else if (password.value.isEmpty()) {
                    Toast.makeText(context, R.string.password_toast, Toast.LENGTH_SHORT).show()
                } else {
                    showMessage(context, message = R.string.success)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.padding_16dp)),
            colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_700))
        ) {
            Text(
                text = stringResource(id = R.string.sign_in_submit),
                fontSize = textSizeResource(id = R.dimen.login_from_btn_text_size),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun ListItems() {

    val personRepository = PersonRepository()
    val getAllData = personRepository.getAllData()

    LazyColumn(
        contentPadding = PaddingValues(
            dimensionResource(id = R.dimen.padding_16dp)
        )
    ) {
        items(items = getAllData) { person ->
            CustomItem(person = person)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_8dp)))
        }
    }
}

fun showMessage(context: Context, message: Int) =
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

@OptIn(ExperimentalUnitApi::class)
@Composable
@ReadOnlyComposable
fun textSizeResource(@DimenRes id: Int): TextUnit {
    val context = LocalContext.current
    val density = LocalDensity.current
    val pxValue = context.resources.getDimension(id)
    return TextUnit(pxValue / density.density, TextUnitType.Sp)
}
