package com.example.jetpackcomposetest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposetest.screens.*

@Composable
fun NavigationGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.Main.route)
    {
        composable(route = Screens.Main.route){
            MainScreen(navController)
        }
        composable(route = Screens.PlayerParameters.route){
            PlayerParametersScreen(navController)
        }
        composable(route = Screens.MonsterParameters.route){
            MonsterParametersScreen(navController)
        }
        composable(route = Screens.GameRules.route){
            GameRules(navController)
        }
        composable(route = Screens.JetpackExample.route){
            JetpackExample(navController)
        }
        composable(route = Screens.StartGame.route){
            Game(navController)
        }
    }
}