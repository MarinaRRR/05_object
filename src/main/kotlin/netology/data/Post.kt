package ru.netology.data

data class
Post(
    val id: Long,
    val authorId: Long,
    val authorName: String,
    val content: String,
    val created: Long,
    val likes: Int = 0,
    val reply_owner_id: Int,
    val reply_post_id: Int,
    val friends_only: Boolean = false,
    val post_type: String,
    val signer_id: Int = 0,
    val can_pin: Boolean = true,
    val can_delete: Boolean = true,
    val can_edit: Boolean = true,
    val comments: Comment
)



