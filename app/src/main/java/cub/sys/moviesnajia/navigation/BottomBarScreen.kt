package cub.sys.moviesnajia.navigation

import cub.sys.moviesnajia.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
){

    object Home : BottomBarScreen(
      route = "Home",
        title ="Home",
        icon = R.drawable.home

    )


    object favorite : BottomBarScreen(
        route = "favorite",
        title ="favorite",
        icon = R.drawable.favorite

    )

}
