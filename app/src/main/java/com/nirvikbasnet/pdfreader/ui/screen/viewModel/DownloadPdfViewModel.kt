package com.nirvikbasnet.pdfreader.ui.screen.viewModel

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.documentfile.provider.DocumentFile
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.BufferedInputStream
import java.io.FileOutputStream
import java.net.URL

class DownloadPdfViewModel : ViewModel() {

    private val _downloadStatus = MutableStateFlow<DownloadStatus?>(null)
    val downloadStatus: StateFlow<DownloadStatus?> = _downloadStatus

    fun downloadPdf(context: Context, pdfUrl: String, pdfTitle: String, directoryUri: Uri?) {
        val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        val request = DownloadManager.Request(Uri.parse(pdfUrl))
            .setTitle(pdfTitle)
            .setMimeType("application/pdf")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)

        // Set the destination directory to the selected directory URI
        if (directoryUri != null) {
            val directory = DocumentFile.fromTreeUri(context, directoryUri)
            if (directory != null && directory.exists() && directory.isDirectory) {
                request.setDestinationInExternalFilesDir(
                    context,
                    Environment.DIRECTORY_DOWNLOADS,
                    pdfTitle
                )
            }
        }

        val downloadId = downloadManager.enqueue(request)

        // Store download status for observing in the Composable
        _downloadStatus.value = DownloadStatus(downloadId)
    }



}

data class DownloadStatus(val downloadId: Long)
