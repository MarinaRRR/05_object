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
        authorId = 1,
        authorName = "Нетология",
        content = "Новая Нетология",
        created = 1590075360,
        likes = 22,
        reply_owner_id = 5,
        reply_post_id = 6,
        post_type = "post",
        can_pin = false,
        comments = Comment(22)
    )
    var original2 = Post(
        authorId = 2,
        authorName = "Нетология2",
        content = "Новая Нетология2",
        created = 1590075360,
        likes = 22,
        reply_owner_id = 5,
        reply_post_id = 6,
        post_type = "post",
        comments = Comment(11)
    )
    val service = WallService()
    service.add(original)
    service.add(original2)
    original2 = Post(
        authorId = 3,
        authorName = "Нетология3",
        content = "Новая Нетология3",
        created = 1590075360,
        likes = 22,
        reply_owner_id = 5,
        reply_post_id = 6,
        post_type = "post",
        comments = Comment(11)
    )
    service.update(original2)
    service.likeById(1)
    service.removeById(0)
    println(service.get(1))
    println(service.get(0))
}



