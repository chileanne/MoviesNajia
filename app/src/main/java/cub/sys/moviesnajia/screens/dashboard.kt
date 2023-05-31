package cub.sys.moviesnajia.screens


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cub.sys.moviesnajia.navigation.BottomBarScreen
import cub.sys.moviesnajia.navigation.BottomNavGraph
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import cub.sys.moviesnajia.R


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DashboardScreen(){
    val navController = rememberNavController();

  Scaffold(
      bottomBar = { BottomAppBars(navController = navController) }
  ) {
      BottomNavGraph(navController = navController)
  }
}


@Composable
fun BottomAppBars(navController: NavHostController){

    /** list of screens **/
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.favorite
    );

    val navBackStackEntry by navController.currentBackStackEntryAsState();
    val currentDestination = navBackStackEntry?.destination


    NavigationBar() {
         screens.forEach { screen ->
             AddItems(
                 screen = screen,
                 currentDestination = currentDestination,
                 navController = navController
             )
         }
    }


}


@Composable
fun RowScope.AddItems(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {

               Icon(
                 imageVector = ImageVector.vectorResource(id = screen.icon),
                   contentDescription = "Fucked",
                   modifier = Modifier
                       .size(24.dp)
               )

        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,

        onClick = {
            navController.navigate(screen.route) {
                /** when back button is pressed allows us to go back to start destination and if pressed again we leave the
                 * app **/
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },

//        colors = NavigationBarItemDefaults.colors(
//            selectedIconColor = Color.Blue,
//            selectedTextColor = Color.Yellow,
//            unselectedIconColor = Color.Green,
//            unselectedTextColor = Color.Red,
//        )
    )
}