package com.example.jetpackcomposetest.screens

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.jetpackcomposetest.R
import com.example.jetpackcomposetest.textSizeResource

@Composable
fun PlayerParametersScreen(navController: NavController) {

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

    /* Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            modifier = Modifier.padding(5.dp),
            onClick = {
                navController.navigateUp()
            }
        ) {
            Text(
                text = "Назад",
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.button.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        }
    }
} */
}