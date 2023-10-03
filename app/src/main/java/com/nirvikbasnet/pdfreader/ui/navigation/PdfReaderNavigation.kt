package com.nirvikbasnet.pdfreader.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nirvikbasnet.pdfreader.ui.screen.HomeScreen
import com.nirvikbasnet.pdfreader.ui.screen.LoadURLScreen

@Composable
fun PdfReaderNavigation(){

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            HomeScreen()
        }
        composable("LoadURLScreen"){
            LoadURLScreen()
        }
    }

}