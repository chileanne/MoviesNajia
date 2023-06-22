package cub.sys.moviesnajia.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel


import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cub.sys.moviesnajia.screens.FavoriteScreen
import cub.sys.moviesnajia.screens.HomeScreen
import cub.sys.moviesnajia.presentation.screens.homescreen.homeScreenViewModel
import dagger.hilt.android.AndroidEntryPoint


@Composable

fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){

        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.favorite.route) {
            FavoriteScreen()
        }

    }


}