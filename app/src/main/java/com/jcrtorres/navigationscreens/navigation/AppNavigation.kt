package com.jcrtorres.navigationscreens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jcrtorres.navigationscreens.screens.FirstScreen
import com.jcrtorres.navigationscreens.screens.SecondScreen
import kotlinx.serialization.Serializable

object Screen {
    @Serializable
    object One

    @Serializable
    data class Two(val param: String)
}

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.One
    ){
        composable<Screen.One>{
            FirstScreen(navController)
        }
        composable<Screen.Two> {
            val args = it.toRoute<Screen.Two>()
            SecondScreen(navController,
                param = args.param,
            )
        }
    }

}