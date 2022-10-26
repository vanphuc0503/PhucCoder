package com.vanphuc.marvelapidemo.data.source.remote.enum_type

enum class EventsOrderByType(val value: String) {
    NAME("name"),
    MODIFIED("modified"),
    SORT_NAME("-name"),
    SORT_MODIFIED("-modified"),
    START_DATE("startDate"),
    SORT_START_DATE("-startDate"),
}