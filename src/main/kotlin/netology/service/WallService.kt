package ru.netology.service

import ru.netology.data.Post

class WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, item) in posts.withIndex()) {
            if (item.id == post.id) {
                posts[index] = post
                return true
            }
        }
        return false
    }

    fun removeById(id: Long): Boolean {
        val mutablePosts = posts.toMutableList()
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                mutablePosts.remove(post)
                posts = mutablePosts.toTypedArray()
                return true
            }
        }
        return false
    }

    fun likeById(id: Long) {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(likes = post.likes + 1)
            }
        }
    }
}


