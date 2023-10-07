package com.nirvikbasnet.pdfreader.ui.screen

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.nirvikbasnet.pdfreader.data.PreferencesManager
import com.nirvikbasnet.pdfreader.ui.screen.viewModel.PdfListViewModel

@Composable
fun PdfListScreen(viewModel: PdfListViewModel,  context: Context) {
    val pdfFiles by viewModel.pdfFiles.collectAsState(emptyList())
    val preferencesManager = remember { PreferencesManager(context) }
    val data = remember { mutableStateOf(preferencesManager.getData("dir", "")) }

    val decodedDir = data.let { Uri.parse(data.value) }


    // List PDF files
    if (decodedDir != null) {
        viewModel.listPdfFiles(decodedDir, context)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Available PDFs",
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.labelMedium
        )
        LazyColumn {
            items(pdfFiles) { pdfFileUri ->
                PdfListItem(pdfFileUri)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PdfListItem(pdfFileUri: Uri) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle PDF item click */ },
        shadowElevation = 4.dp
    ) {
        ListItem(
            headlineText = { Text(text = pdfFileUri.lastPathSegment ?: "") },
            supportingText = { Text(text = pdfFileUri.toString()) }
        )
    }
}
