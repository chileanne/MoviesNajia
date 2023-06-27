package cub.sys.moviesnajia.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cub.sys.moviesnajia.screens.FavoriteScreen
import cub.sys.moviesnajia.screens.HomeScreen
import cub.sys.moviesnajia.presentation.screens.homescreen.homeScreenViewModel


@Composable

fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){

        composable(route = BottomBarScreen.Home.route) {
           val viewModel: homeScreenViewModel = hiltViewModel()
            HomeScreen(
                state = viewModel.state,
                onEvent =viewModel::onEvent
            )
        }
        composable(route = BottomBarScreen.favorite.route) {
            FavoriteScreen()
        }

    }


}