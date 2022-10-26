package com.vanphuc.marvelapidemo.data.source.remote.enum_type

enum class CharactersOrderByType(val value: String) {
    NAME("name"),
    MODIFIED("modified"),
    SORT_NAME("-name"),
    SORT_MODIFIED("-modified"),
}