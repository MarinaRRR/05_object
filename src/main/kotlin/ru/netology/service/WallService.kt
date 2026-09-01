package ru.netology.service

import ru.netology.data.Post

class WallService {
    private var posts = emptyArray<Post>()
    private var post_id: Long = 0

    fun clear() {
        posts = emptyArray()
        post_id = 0
    }

    fun get(id: Long): Any {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                return post
            }
        }
        return false
    }

    fun add(post: Post): Post {
        post.id = post_id
        post_id++
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


