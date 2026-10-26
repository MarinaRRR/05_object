package ru.netology.service
import ru.netology.data.Comment
import ru.netology.data.Post
import ru.netology.data.ReportComment
import ru.netology.exeptions.NotFoundException
import ru.netology.exeptions.PostNotFoundException


class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reports = emptyArray<ReportComment>()
    private var postId: Long = 0
    private var commentId: Long = 0

    fun clear() {
        posts = emptyArray()
        postId = 0
        commentId = 0
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
        post.id = postId
        postId++
        posts += post
        return posts.last()
    }

    fun addReportComment(idPost: Long, commentId: Long, ownerId: Int, reasonCode: Int): Boolean {
        for (post in posts) {
            if (idPost == post.id) {
                for (comment in comments) {
                    if (comment.id == commentId) {
                        if(reasonCode > 8)
                            throw NotFoundException("Такой причины не существует")
                        val reportComment = ReportComment(ownerId, commentId, reasonCode)
                        reports += reportComment
                        return true
                    }
                }
                throw NotFoundException("Комментарий с id $commentId - не найден")
            }
        }
        throw NotFoundException("Пост с id $idPost - не найден")
    }

    fun addComment(comment: Comment): Comment {
        comment.id = commentId
        commentId++
        comments += comment
        return comments.last()
    }

    fun createComment(postId: Long, comment: Comment): Comment {
        for (post in posts) {
            if (post.id == postId) {
                addComment(comment)
                return comments.last()
            }
        }
    throw PostNotFoundException("Пост с id: $postId не найден")
    }

    fun repost(post: Post): Post {
        val original = post.original ?: post
        return add(original)
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


