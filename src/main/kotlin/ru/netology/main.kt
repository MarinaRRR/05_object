package ru.netology
import ru.netology.data.*
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
    val vid = Video (5, 3, "video1", "/upload/video/video1.mov", "pum purum")
    val attachment: Attachment = VideoAttachment(vid)

    val original = Post(
        authorId = 1,
        authorName = "Нетология",
        content = "Новая Нетология",
        created = 1590075360,
        original = null,
        likes = 22,
        replyOwnerId = 5,
        replyPostId = 6,
        postType = "post",
        canPin = false,
        comments = Comment(22, 1)
    )
    var original2 = Post(
        authorId = 2,
        authorName = "Нетология2",
        content = "Новая Нетология2",
        created = 1590075360,
        original = original,
        likes = 22,
        replyOwnerId = 5,
        replyPostId = 6,
        postType = "post",
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
        original = original,
        likes = 22,
        replyOwnerId = 5,
        replyPostId = 6,
        postType = "post",
        comments = Comment(11),
        attachment = mutableListOf(attachment)
    )
    val comment1 = Comment(
        id = 1,
        text = "comment1"
    )

    service.update(original2)
    service.likeById(1)
    service.removeById(0)
    println(service.get(1))
    println(service.get(0))
    println(service.createComment(1, comment1))

}



