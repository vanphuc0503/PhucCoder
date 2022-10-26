package com.vanphuc.marvelapidemo.data.source.remote.enum_type

enum class ComicsOrderByType(val value: String) {
    FOC_DATE("focDate"),
    ONSALE_DATE("onsaleDate"),
    TITLE("title"),
    ISSUE_NUMBER("issueNumber"),
    MODIFIED("modified"),
    SORT_FOC_DATE("-focDate"),
    SORT_ONSALE_DATE("-onsaleDate"),
    SORT_TITLE("-title"),
    SORT_ISSUE_NUMBER("-issueNumber"),
    SORT_MODIFIED("-modified"),
}