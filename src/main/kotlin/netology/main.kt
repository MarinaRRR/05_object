package ru.netology

import ru.netology.data.Comment
import ru.netology.data.Post
import ru.netology.service.WallService

fun main() {
//    val original = Post(
//        id = 1,
//        authorId = 1,
//        authorName = "Нетология",
//        content = "Новая Нетология",
//        created = 1590075360,
//        likes = 22
//    )
//    val liked = original.copy(likes = original.likes + 1)
//    println(liked)
//
//    val (id, _, author) = original
//    println("$id, $author")

    val original = Post(
        id = 1,
        authorId = 1,
        authorName = "Нетология",
        content = "Новая Нетология",
        created = 1590075360,
        likes = 22,
        reply_owner_id = 5,
        reply_post_id = 6,
        post_type = "post",
        comments = Comment(22)
    )
    val service = WallService()
    service.add(original)
}



