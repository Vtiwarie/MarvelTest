package com.example.marveltest.data.entity

data class CreatorList(
    val available: Int?
) {
    var items: ArrayList<CreatorSummary>? = null
}