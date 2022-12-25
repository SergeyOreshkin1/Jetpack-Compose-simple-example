package com.example.jetpackcomposetest.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposetest.presentation.screens.*
import com.example.jetpackcomposetest.presentation.viewmodel.ParametersViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {

    val viewModel: ParametersViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screens.Main.route
    )
    {
        composable(route = Screens.Main.route) {
            MainScreen(navController, viewModel)
        }
        composable(route = Screens.PlayerParameters.route) {
            PlayerParametersScreen(navController, viewModel)
        }
        composable(route = Screens.MonsterParameters.route) {
            MonsterParametersScreen(navController, viewModel)
        }
        composable(route = Screens.GameRules.route) {
            GameRules(navController)
        }
        composable(route = Screens.JetpackExample.route) {
            JetpackExample(navController)
        }
        composable(route = Screens.StartGame.route) {
            Game(navController)
        }
    }
}