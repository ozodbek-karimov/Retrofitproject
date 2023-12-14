package com.devtides.retrofitproject.model

const val TYPE_ITEM = 0
const val TYPE_CATEGORY = 1

data class Item(
    val key: String,
    val value: String,
    val type: Int
)