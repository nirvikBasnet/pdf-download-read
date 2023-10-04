package com.nirvikbasnet.pdfreader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.nirvikbasnet.pdfreader.ui.navigation.PdfReaderNavigation
import com.nirvikbasnet.pdfreader.ui.screen.viewModel.DownloadPdfViewModel

class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    text = "PDF Reader",
                                    color = Color.White,
                                    fontSize = 20.sp

                                )
                            },
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Blue)
                        )
                    }){
                    val viewModel = ViewModelProvider(this).get(DownloadPdfViewModel::class.java)

                    PdfReaderNavigation(it,viewModel)
                }


            }
        }
    }








