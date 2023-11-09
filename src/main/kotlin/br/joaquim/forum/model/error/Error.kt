package br.joaquim.forum.model.error

import java.time.LocalDateTime

data class Error(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    var message: String = ""
)
