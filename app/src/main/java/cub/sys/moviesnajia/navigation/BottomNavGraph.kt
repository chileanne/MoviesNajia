package cub.sys.moviesnajia.navigation

import androidx.compose.runtime.Composable


import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cub.sys.moviesnajia.screens.FavoriteScreen
import cub.sys.moviesnajia.screens.HomeScreen



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