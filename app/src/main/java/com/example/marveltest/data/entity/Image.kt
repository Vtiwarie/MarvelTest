package com.example.marveltest.data.entity

data class Image(
    val path: String?,
    val extension: String?
) {
    fun getFullImagePath() = path + extension
}