package ru.netology.data

data class
Comment(
    val count: Int,
    val can_post: Boolean = true,
    val groups_can_post: Boolean = true,
    val can_close: Boolean = true,
    val can_open: Boolean = true
)