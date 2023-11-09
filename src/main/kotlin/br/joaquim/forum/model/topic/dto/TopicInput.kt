package br.joaquim.forum.model.topic.dto

import jakarta.validation.constraints.*

data class TopicInput(
    @field:NotNull(message = "title must not be null")
    @field:NotBlank(message = "title must not be blank")
    @field:Size(min = 3, max = 50,  message = "title must be between 3 and 50 characters")
    val title: String,

    @field:NotNull(message = "body text must not be null")
    @field:NotBlank(message = "body text must not be blank")
    @field:Size(min=10, message = "body text is too short")
    val text: String,

    @field:NotNull(message = "author must not be null")
    @field:NotBlank(message = "author must have a name")
    @field:Size(min = 3, message = "author name is too short")
    val author: String,

    @field:NotNull(message = "category must not be null")
    @field:NotBlank(message = "category must have a name")
    val category: String
)
