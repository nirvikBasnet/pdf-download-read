package com.nirvikbasnet.pdfreader.ui.screen.viewModel

import android.content.Context
import android.net.Uri
import androidx.documentfile.provider.DocumentFile
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PdfListViewModel : ViewModel() {
    private val _pdfFiles = MutableStateFlow<List<Uri>>(emptyList())
    val pdfFiles: StateFlow<List<Uri>> = _pdfFiles

    fun listPdfFiles(directoryUri: Uri, context: Context) {
        viewModelScope.launch {
            val pdfFilesList = mutableListOf<Uri>()
            val directory = DocumentFile.fromTreeUri(context, directoryUri)

            if (directory != null && directory.isDirectory) {
                val files = directory.listFiles()
                for (file in files) {
                    if (file.type == "application/pdf") {
                        pdfFilesList.add(file.uri)
                    }
                }
            }

            _pdfFiles.value = pdfFilesList
        }
    }
}
