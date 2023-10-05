package com.nirvikbasnet.pdfreader.ui.navigation

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nirvikbasnet.pdfreader.ui.navigation.bottomNavigation.BottomNavItems
import com.nirvikbasnet.pdfreader.ui.screen.DownloadScreen
import com.nirvikbasnet.pdfreader.ui.screen.PdfListScreen
import com.nirvikbasnet.pdfreader.ui.screen.viewModel.DownloadPdfViewModel
import com.nirvikbasnet.pdfreader.ui.screen.viewModel.PdfListViewModel

@Composable
fun PdfReaderNavigation(paddingValues: PaddingValues, dir : Uri,
                        downloadPdfViewModel: DownloadPdfViewModel,
                        pdfListViewModel: PdfListViewModel){

     val context = LocalContext.current

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = BottomNavItems.List.route) {
        composable(BottomNavItems.Download.route) { DownloadScreen(navController,downloadPdfViewModel) }
        composable(BottomNavItems.List.route) { PdfListScreen(pdfListViewModel,dir,context) }

    }



}