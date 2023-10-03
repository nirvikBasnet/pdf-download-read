package com.nirvikbasnet.pdfreader.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nirvikbasnet.pdfreader.ui.screen.HomeScreen
import com.nirvikbasnet.pdfreader.ui.screen.LoadURLScreen

@Composable
fun PdfReaderNavigation(){

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            HomeScreen(navController)
        }
        composable("LoadURLScreen/{url}",
        arguments = listOf(navArgument("url"){type = NavType.StringType})
        ){
            LoadURLScreen(navController, it.arguments?.getString("url"))
        }
    }

}