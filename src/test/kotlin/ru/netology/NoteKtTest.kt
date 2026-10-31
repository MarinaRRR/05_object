package ru.netology

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import ru.netology.data.Comment
import ru.netology.data.Note
import ru.netology.exeptions.NotFoundException
import ru.netology.service.NoteService

class NoteKtTest {
    @Before
    fun clearBeforeTest() {
        NoteService.clear()
    }

    @Test
    fun addNote() {
        val noteService = NoteService
        val result = noteService.add(Note(0))
        assertEquals(Note(0) ,result)
    }

    @Test
    fun updateNote() {
        val noteService = NoteService
        noteService.add(Note(0))
        val result = noteService.update(Note(0, text = "bla bla bla"))
        assertEquals(true ,result)
    }

    @Test
    fun updateNoteFalse() {
        val noteService = NoteService
        noteService.add(Note(1))
        val result = noteService.update(Note(5, text = "bla bla bla"))
        assertEquals(false ,result)
    }

    @Test
    fun createNoteComment() {
        val noteService = NoteService
        noteService.add(Note(0))
        val result = noteService.createComment(0, Comment(1, text = "Text"))
        assertEquals(true  ,result)
    }

    @Test(expected = NotFoundException::class)
    fun createNoteCommentFalse() {
        val noteService = NoteService
        noteService.add(Note(1))
        val result = noteService.createComment(5, Comment(1, text = "Text"))
    }

    @Test
    fun deleteNoteComment() {
        val noteService = NoteService
        noteService.add(Note(0))
        noteService.createComment(0, Comment(1, text = "Text"))
        val result = noteService.deleteComment(0, 1)
        assertEquals(true  ,result)
    }

    @Test(expected = NotFoundException::class)
    fun deleteNoteCommentFalse() {
        val noteService = NoteService
        noteService.add(Note(1))
        noteService.createComment(1, Comment(1, text = "Text"))
        val result = noteService.deleteComment(5, 1)
    }

}