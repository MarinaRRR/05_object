package ru.netology
import ru.netology.data.*
import ru.netology.service.NoteService
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
        attachment = mutableListOf(attachment)
    )
    val comment1 = Comment(
        id = 1,
        text = "comment1"
    )

    service.update(original2)
    service.likeById(1)
    //service.removeById(1, Post::class.java)
    //println(service.getById(0, Post::class.java))
    //println(service.getById(1, Post::class.java))
    //println(service.get(Post::class.java))
    //service.clear()
    //println(service.get(Post::class.java))
    //println(service.createComment(1, comment1))

    /*val noteService = NoteService
    noteService.add(Note(1))
    noteService.createComment(1, Comment(1, text = "Text"))
    noteService.createComment(1, Comment(2, text = "Text2"))
    println(noteService.getComments(1))
    noteService.deleteComment(1, 1)
    //noteService.print()
    noteService.restoreComment(1, 1)*/
    //noteService.print()noteService

}



