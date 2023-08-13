package br.joaquim.forum.model.topic.dto

import br.joaquim.forum.model.topic.Topic

data class TopicUpdate(
    val title: String,
    val text: String
)
