package br.joaquim.forum.model.topic.dto

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class TopicUpdate(
    @field:NotNull(message = "title must not be null")
    @field:NotBlank(message = "title must not be blank")
    @field:Min(value = 3, message = "title is too short")
    @field:Max(value = 50, message = "title is too long")
    val title: String,

    @field:NotNull(message = "body text must not be null")
    @field:NotBlank(message = "body text must not be blank")
    @field:Min(value = 3, message = "body text is too short")
    val text: String
)
