package com.nirvikbasnet.pdfreader.ui.screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.nirvikbasnet.pdfreader.ui.navigation.PdfReaderNavigation
import com.nirvikbasnet.pdfreader.ui.navigation.bottomNavigation.BottomNavBar
import com.nirvikbasnet.pdfreader.ui.screen.viewModel.DownloadPdfViewModel
import com.nirvikbasnet.pdfreader.ui.screen.viewModel.PdfListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){

     val navController = rememberNavController()
     val downloadPdfViewModel: DownloadPdfViewModel = viewModel()
     val pdfListViewModel: PdfListViewModel = viewModel()

    Scaffold(

        bottomBar = { BottomNavBar(navController) }

    ){


        PdfReaderNavigation(it,navController,downloadPdfViewModel,pdfListViewModel)

    }

}