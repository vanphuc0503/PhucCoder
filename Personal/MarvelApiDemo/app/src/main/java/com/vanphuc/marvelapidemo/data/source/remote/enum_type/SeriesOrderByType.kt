package com.vanphuc.marvelapidemo.data.source.remote.enum_type

enum class SeriesOrderByType(val value: String) {
    TITLE("title"),
    SORT_TITLE("-title"),
    START_YEAR("startYear"),
    MODIFIED("modified"),
    SORT_START_YEAR("-startYear"),
    SORT_MODIFIED("-modified"),
}