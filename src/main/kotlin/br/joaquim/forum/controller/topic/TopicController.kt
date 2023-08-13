package br.joaquim.forum.controller.topic

import br.joaquim.forum.model.topic.Topic
import br.joaquim.forum.service.topic.TopicService
import br.joaquim.forum.service.topic.TopicServiceImpl
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("topics")
class TopicController(
    private val service: TopicService
) {
    @GetMapping
    fun findAll(): ResponseEntity<List<Topic>> {
        val topics = service.findAll()
        return ResponseEntity.ok(topics)
    }
}