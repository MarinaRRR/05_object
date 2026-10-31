package ru.netology.data

data class Note (
    override var id: Long = 0,
    val ownerId: Int = 0,
    var title: String? = null,
    var text: String? = null,
    var delete:Boolean = false,
    val comments: MutableList<Comment> = mutableListOf()
): Item(id)