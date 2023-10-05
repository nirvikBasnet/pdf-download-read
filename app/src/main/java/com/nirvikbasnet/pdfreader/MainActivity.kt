package com.nirvikbasnet.pdfreader

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.lifecycle.ViewModelProvider
import com.nirvikbasnet.pdfreader.ui.navigation.PdfReaderNavigation
import com.nirvikbasnet.pdfreader.ui.screen.viewModel.DownloadPdfViewModel
import com.nirvikbasnet.pdfreader.ui.screen.viewModel.PdfListViewModel

class MainActivity : ComponentActivity() {

    private val dir : Uri
        get() {
            TODO()
        }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Scaffold(

                ){
                    val downloadPdfViewModel = ViewModelProvider(this).get(DownloadPdfViewModel::class.java)
                    val pdfListViewModel = ViewModelProvider(this).get(PdfListViewModel::class.java)

                    PdfReaderNavigation(it,dir,downloadPdfViewModel,pdfListViewModel)

                }


            }
        }
    }








