package ru.netology.service

import ru.netology.data.Comment
import ru.netology.data.Note
import ru.netology.exeptions.NotFoundException

object NoteService : CrudService<Note>() {

    //private var notes = mutableListOf<Note>()

    fun createComment(idEntity: Long, comment: Comment): Boolean {
        if (elements.find { it.id == idEntity }?.comments?.add(comment) == true)
            return true
        else throw NotFoundException("Комментарий не добавлен")
    }

    fun deleteComment(idEntity: Long, commentId: Long): Boolean {
        if (elements.find { it.id == idEntity }?.comments?.find { it.id == commentId }?.deleted == false){
            elements.find { it.id == idEntity }?.comments?.find { it.id == commentId }?.deleted = true
            return true
        }
        else throw NotFoundException("Комментарий не найден")
    }

    fun restoreComment(idEntity: Long, commentId: Long) {
        elements.find { it.id == idEntity }?.comments?.find { it.id == commentId }?.deleted = false
    }

    fun getComments(idEntity: Long): List<Comment>? {
        return elements.find { it.id == idEntity }?.comments
    }
}