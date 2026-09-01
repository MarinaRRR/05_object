package ru.netology
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import ru.netology.data.Comment
import ru.netology.data.Post
import ru.netology.service.WallService

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
            likes = 22,
            reply_owner_id = 5,
            reply_post_id = 6,
            post_type = "post",
            comments = Comment(11)
        )

        val service = WallService()
        val result = service.add(original)

        assertEquals(original ,result)
    }

    @Test
    fun updatePost() {
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
            likes = 22,
            reply_owner_id = 5,
            reply_post_id = 6,
            post_type = "post",
            can_pin = false,
            comments = Comment(22)
        )
        val service = WallService()
        service.add(original)
        val original2 = Post(
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
        val result = service.update(original2)
        assertEquals(false ,result)
    }
}