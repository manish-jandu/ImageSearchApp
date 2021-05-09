package com.manishjandu.imagesearchapp.data

import androidx.paging.PagingSource
import com.manishjandu.imagesearchapp.api.UnsplashAPI
import com.manishjandu.imagesearchapp.api.UnsplashResponse
import retrofit2.HttpException
import java.io.IOException

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

class UnsplashPagingSource(
    private val unsplashApi: UnsplashAPI,
    private val query: String,
) : PagingSource<Int, UnsplashResponse>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashResponse> {
        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX

        return try {
            val response = unsplashApi.searchPhotos(query, position, params.loadSize)
            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if (position == UNSPLASH_STARTING_PAGE_INDEX) null else position - 1,
                nextKey  = if (photos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}