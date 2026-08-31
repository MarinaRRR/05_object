package ru.netology.domain

class Post(
    val id: Long,
    val authorId: Long,
    val authorName: String,
    val content: String,
    val created: Long,
    likes: Int = 0
) {
    var likes = likes
        set (value) {
            if (value < 0) {
                return
            }
            field = value
        }
}



