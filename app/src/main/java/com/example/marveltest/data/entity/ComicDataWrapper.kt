package com.example.marveltest.data.entity

data class ComicDataWrapper(
    val data: ComicDataContainer
)

data class ComicDataContainer(
    val results: List<Comic>
)