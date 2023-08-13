package br.joaquim.forum.model.topic.dto

data class TopicInput(
    val title: String,
    val text: String,
    val author: String,
    val category: String
)
