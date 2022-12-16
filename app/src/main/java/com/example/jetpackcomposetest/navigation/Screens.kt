package com.example.jetpackcomposetest.navigation

sealed class Screens(val route: String) {
    object Main: Screens("main_screen")
    object PlayerParameters: Screens("player_parameters_screen")
    object MonsterParameters: Screens("monster_parameters_screen")
    object GameRules: Screens("game_rules")
    object JetpackExample: Screens("jetpack_example")
    object StartGame: Screens("start_game")
}