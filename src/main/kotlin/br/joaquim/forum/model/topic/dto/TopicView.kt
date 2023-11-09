package br.joaquim.forum.model.topic.dto

import br.joaquim.forum.model.topic.StatusTopic
import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val msg: String,
    val author: String,
    val category: String,
    val status: StatusTopic,
    val dateCreated: LocalDateTime
)
