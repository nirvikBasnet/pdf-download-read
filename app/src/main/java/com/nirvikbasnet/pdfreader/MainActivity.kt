package com.nirvikbasnet.pdfreader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nirvikbasnet.pdfreader.ui.navigation.PdfReaderNavigation
import com.nirvikbasnet.pdfreader.ui.theme.PDFREADERTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PDFREADERTheme {

                PdfReaderNavigation()
            }
        }
    }
}







