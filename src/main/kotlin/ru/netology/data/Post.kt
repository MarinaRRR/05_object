package ru.netology.data

data class Post(
    override var id: Long = 0,
    val authorId: Long = 0,
    val authorName: String = "",
    val content: String = "",
    val created: Long = 0,
    val original: Post? = null,
    val likes: Int = 0,
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val postType: String = "",
    val signerId: Int = 0,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val comments: MutableList<Comment> = mutableListOf(),
    var attachment: List<Attachment>? = emptyList(),
): Item(id)



