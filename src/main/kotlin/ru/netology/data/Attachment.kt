package ru.netology.data

sealed class Attachment(val type: String)

data class VideoAttachment(val video: Video) : Attachment("video")
data class PhotoAttachment(val photo: Photo) : Attachment("photo")
data class AudioAttachment(val audio: Audio) : Attachment("audio")

class Photo(
    val id: Long,
    val ownerId: Long,
    val title: String,
    val url: String,
    val description: String
)

class Audio(
    val id: Long,
    val ownerId: Long,
    val title: String,
    val url: String,
    val description: String
)

class Video(
    val id: Long,
    val ownerId: Long,
    val title: String,
    val url: String,
    val description: String
)
fun main() {
    val vid = Video (5, 3, "video1", "/upload/video/video1.mov", "pum purum")
    val attachment: Attachment = VideoAttachment(vid)
    println(attachment.type)
}