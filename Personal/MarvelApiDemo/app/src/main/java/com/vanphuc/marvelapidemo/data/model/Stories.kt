package com.vanphuc.marvelapidemo.data.model

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<Story>,
    val returned: Int
)