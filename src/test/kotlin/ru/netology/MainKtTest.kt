package ru.netology
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import ru.netology.data.Comment
import ru.netology.data.Post
import ru.netology.exeptions.NotFoundException
import ru.netology.exeptions.PostNotFoundException
import ru.netology.service.WallService
import kotlin.io.println

class MainKtTest {
    @Before
    fun clearBeforeTest() {
        WallService().clear()
    }

    @Test
    fun addPost() {
        var original = Post(
            authorId = 2,
            authorName = "Нетология2",
            content = "Новая Нетология2",
            created = 1590075360,
            original = null,
            likes = 22,
            replyOwnerId = 5,
            replyPostId = 6,
            postType = "post",
            comments = Comment(11)
        )

        val service = WallService()
        val result = service.add(original)

        assertEquals(original ,result)
    }

    @Test
    fun repostNull() {
        var original = Post(
            authorId = 2,
            authorName = "Нетология2",
            content = "Новая Нетология2",
            created = 1590075360,
            original = null,
            likes = 22,
            replyOwnerId = 5,
            replyPostId = 6,
            postType = "post",
            comments = Comment(11)
        )

        val service = WallService()
        val result = service.repost(original)

        assertEquals(original ,result)
    }

    @Test
    fun repostNotNull() {
        var original2 = Post(
            authorId = 2,
            authorName = "Нетология2",
            content = "Новая Нетология2",
            created = 1590075360,
            original = null,
            likes = 22,
            replyOwnerId = 5,
            replyPostId = 6,
            postType = "post",
            comments = Comment(11)
        )
        val original = Post(
            authorId = 1,
            authorName = "Нетология",
            content = "Новая Нетология",
            created = 1590075360,
            original = original2,
            likes = 22,
            replyOwnerId = 5,
            replyPostId = 6,
            postType = "post",
            canPin = false,
            comments = Comment(22)
        )

        val service = WallService()
        val result = service.repost(original)

        assertEquals(original2 ,result)
    }

    @Test
    fun updatePost() {
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
            comments = Comment(22)
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
            id = 1,
            authorId = 3,
            authorName = "Нетология3",
            content = "Новая Нетология3",
            created = 1590075360,
            original = original,
            likes = 22,
            replyOwnerId = 5,
            replyPostId = 6,
            postType = "post",
            comments = Comment(11)
        )
        val result = service.update(original2)
        assertEquals(true ,result)
    }

    @Test
    fun updatePostFalse() {
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
            comments = Comment(22)
        )
        val service = WallService()
        service.add(original)
        val original2 = Post(
            id = 3,
            authorId = 3,
            authorName = "Нетология3",
            content = "Новая Нетология3",
            created = 1590075360,
            original = original,
            likes = 22,
            replyOwnerId = 5,
            replyPostId = 6,
            postType = "post",
            comments = Comment(11)
        )
        val result = service.update(original2)
        assertEquals(false ,result)
    }

    @Test
    fun createComment() {
        val comment1 = Comment(
            id = 1,
            text = "comment1"
        )
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
            comments = Comment(22)
        )

        val service = WallService()
        service.add(original)
        val result = service.createComment(0, comment1)
        assertEquals(comment1 ,result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val comment1 = Comment(
            id = 1,
            text = "comment1"
        )
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
            comments = Comment(22)
        )

        val service = WallService()
        service.add(original)
        val result = service.createComment(10, comment1)
    }

    @Test
    fun addReportComment() {
        val comment1 = Comment(
            id = 1,
            text = "comment1"
        )
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
            comments = Comment(22)
        )

        val service = WallService()
        service.add(original)
        service.createComment(0, comment1)
        val result = service.addReportComment(0, 0, 1, 1)
        assertEquals(true ,result)
    }

    @Test(expected = NotFoundException::class)
    fun shouldThrowReportReason() {
        val comment1 = Comment(
            id = 1,
            text = "comment1"
        )
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
            comments = Comment(22)
        )

        val service = WallService()
        service.add(original)
        service.createComment(0, comment1)
        val result = service.addReportComment(0, 0, 1, 10)
    }

    @Test(expected = NotFoundException::class)
    fun shouldThrowReportCommentId() {
        val comment1 = Comment(
            id = 1,
            text = "comment1"
        )
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
            comments = Comment(22)
        )

        val service = WallService()
        service.add(original)
        service.createComment(0, comment1)
        val result = service.addReportComment(0, 20, 1, 2)
    }

    @Test(expected = NotFoundException::class)
    fun shouldThrowReportPostId() {
        val comment1 = Comment(
            id = 1,
            text = "comment1"
        )
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
            comments = Comment(22)
        )

        val service = WallService()
        service.add(original)
        service.createComment(0, comment1)
        val result = service.addReportComment(20, 0, 1, 2)
    }


}