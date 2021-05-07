package com.manishjandu.imagesearchapp.data

import com.manishjandu.imagesearchapp.api.UnsplashAPI
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor(private val unsplashAPI: UnsplashAPI) {
}