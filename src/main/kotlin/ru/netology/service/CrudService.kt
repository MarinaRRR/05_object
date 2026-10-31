package ru.netology.service

import ru.netology.data.Comment
import ru.netology.data.Item
import ru.netology.data.Note
import ru.netology.data.Post
import ru.netology.exeptions.NotFoundException
import ru.netology.exeptions.PostNotFoundException


abstract class CrudService<T : Item> {
    protected val elements = mutableListOf<T>()
    private var postId: Long = 0
    private var noteId: Long = 0

    fun add(elem: T): T {
        when (elem) {
            is Post -> {
                elem.id = postId
                postId++
            }

            is Note -> {
                elem.id = noteId
                noteId++

            }
            else -> throw NotFoundException("Неизвестная сущность")
        }
        elements += elem
        return elements.last()
    }

    fun delete(elem: Item): Boolean {
        return elements.remove(elem)
    }

    /* edit */
    fun update(elem: T): Boolean {
        for ((index, item) in elements.withIndex()) {
            if (item.id == elem.id) {
                elements[index] = elem
                return true
            }
        }
        return false
    }

    fun get(entityType: Class<out T>): List<T>{
        if(elements.isNotEmpty())
            return elements
        else
            when (entityType) {
            Post::class.java -> throw NotFoundException("У вас нет постов")
            Note::class.java -> throw NotFoundException("У вас нет заметок")
            else -> throw NotFoundException("Неизвестная сущность")
        }
    }

    fun getById(idEntity: Long, entityType: Class<out T>): T{
        for (item in elements) {
            if (idEntity == item.id) {
                return item
            }
        }
        when (entityType) {
            Post::class.java -> throw NotFoundException("Пост с id: $idEntity не найден")
            Note::class.java -> throw NotFoundException("Заметка с id: $idEntity не найдена")
            else -> throw NotFoundException("Неизвестная сущность")
        }
    }

    fun removeById(idEntity: Long, entityType: Class<out T>): Boolean {
        //val mutablePosts = posts
        for (item in elements) {
            if (item.id == idEntity) {
                elements.remove(item)
                return true
            }
        }
        when (entityType) {
            Post::class.java -> throw NotFoundException("Пост с id: $idEntity не найден")
            Note::class.java -> throw NotFoundException("Заметка с id: $idEntity не найдена")
            else -> throw NotFoundException("Неизвестная сущность")
        }
    }



    fun clear() {
        //elements.clear()
        postId = 0
        noteId = 0
    }
}