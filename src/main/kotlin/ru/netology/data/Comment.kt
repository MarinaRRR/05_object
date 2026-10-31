package ru.netology.data

import java.time.LocalDateTime

data class Comment(
    var id: Long = 0,
    val fromId: Long = 0,
    val date: LocalDateTime? = null,
    val text: String = "",
    var deleted: Boolean = false
)
data class ReportComment(
    val ownerId: Int = 0,
    val commentId: Long = 0,
    var reasonCode: Int = 0
)