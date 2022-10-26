package com.vanphuc.marvelapidemo.data.source.remote.enum_type

enum class CreatorsOrderByType(val value: String) {
    LAST_NAME("lastName"),
    FIRST_NAME("firstName"),
    MIDDLE_NAME("middleName"),
    SUFFIX("suffix"),
    MODIFIED("modified"),
    SORT_LAST_NAME("-lastName"),
    SORT_FIRST_NAME("-firstName"),
    SORT_MIDDLE_NAME("-middleName"),
    SORT_SUFFIX("-suffix"),
    SORT_MODIFIED("-modified"),
}