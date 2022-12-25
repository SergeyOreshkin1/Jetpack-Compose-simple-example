package com.example.jetpackcomposetest.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcomposetest.data.Bug
import com.example.jetpackcomposetest.data.Player
import com.example.jetpackcomposetest.utils.AppConstants

@Composable
fun Game(navController: NavController) {

    val player =
        navController.previousBackStackEntry?.savedStateHandle?.get<Player>(AppConstants.BUNDLE_KEY_PLAYER)
    val bug =
        navController.previousBackStackEntry?.savedStateHandle?.get<Bug>(AppConstants.BUNDLE_KEY_MONSTER)

    LaunchedEffect(key1 = player, key2 = bug) {
        Log.d("params", "$player")
        Log.d("params", "$bug")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Game",
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center
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
    }
}
