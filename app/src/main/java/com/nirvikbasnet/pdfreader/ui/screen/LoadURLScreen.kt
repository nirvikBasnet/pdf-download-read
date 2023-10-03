package com.nirvikbasnet.pdfreader.ui.screen

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import java.net.URLDecoder


@Composable
fun LoadURLScreen(navController: NavController, url: String?){
    url?.let {
        val decodedUrl = URLDecoder.decode(url)
        MainContent(decodedUrl)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(url: String) {

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
        }) { MyContent(paddingValues = it,url) }

}


@Composable
fun MyContent(paddingValues: PaddingValues, url: String) {

    // Declare a string that contains a url
    val mUrl = url

    // Adding a WebView inside AndroidView
    // with layout as full screen
    AndroidView(
        modifier = Modifier.padding(paddingValues),
        factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient()
                loadUrl(mUrl)
            }
        }, update = {
            it.loadUrl(mUrl)
        })
}

@Preview(showBackground = true)
@Composable
fun MainContentPreview(){
    MainContent("https://www.geeksforgeeks.org")
}
