package com.manishjandu.imagesearchapp.data

import android.graphics.pdf.PdfDocument
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.manishjandu.imagesearchapp.api.UnsplashAPI
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor(private val unsplashAPI: UnsplashAPI) {

    fun getSearchResults(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnsplashPagingSource(unsplashAPI, query) }
        ).liveData
}