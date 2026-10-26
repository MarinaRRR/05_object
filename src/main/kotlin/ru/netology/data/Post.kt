package ru.netology.data

data class
Post(
    var id: Long = 0,
    val authorId: Long,
    val authorName: String,
    val content: String,
    val created: Long,
    val original: Post?,
    val likes: Int = 0,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean = false,
    val postType: String,
    val signerId: Int = 0,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val comments: Comment,
    var attachment: List<Attachment>? = emptyList(),
)



