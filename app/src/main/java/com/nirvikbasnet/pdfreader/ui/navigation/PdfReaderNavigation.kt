package com.nirvikbasnet.pdfreader.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nirvikbasnet.pdfreader.ui.screen.HomeScreen
import com.nirvikbasnet.pdfreader.ui.screen.LoadURLScreen
import com.nirvikbasnet.pdfreader.ui.screen.viewModel.DownloadPdfViewModel

@Composable
fun PdfReaderNavigation(paddingValues: PaddingValues,viewModel: DownloadPdfViewModel){

    val navController = rememberNavController()


    NavHost(modifier = Modifier.padding(paddingValues), navController = navController, startDestination = "home"){
        composable("home"){
            HomeScreen(navController,viewModel)
        }
//        composable("LoadURLScreen/{url}",
//        arguments = listOf(navArgument("url"){type = NavType.StringType})
//        ){
//            LoadURLScreen(navController, it.arguments?.getString("url"))
//        }
    }

}