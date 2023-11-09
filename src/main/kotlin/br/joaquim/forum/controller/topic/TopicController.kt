package br.joaquim.forum.controller.topic

import br.joaquim.forum.model.topic.Topic
import br.joaquim.forum.model.topic.dto.TopicInput
import br.joaquim.forum.model.topic.dto.TopicUpdate
import br.joaquim.forum.model.topic.dto.TopicView
import br.joaquim.forum.service.topic.TopicService
import br.joaquim.forum.service.topic.TopicServiceImpl
import jakarta.validation.Valid
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("topics")
class TopicController(
    private val service: TopicService
) {
    @GetMapping
    fun findAll(): ResponseEntity<List<TopicView>> {
        val topics = service.findAll()
        val views = topics.map { t -> t.mapToView() }
        return ResponseEntity.ok(views)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<TopicView> {
        val topic = service.findById(id)
        return ResponseEntity.ok(topic.mapToView())
    }

    @PostMapping
    fun create(@Valid @RequestBody dto: TopicInput): ResponseEntity<TopicView> {
        val topic = service.create(dto)
        val view = topic.mapToView()


        val uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(topic.id)
            .toUri()

        return ResponseEntity.created(uri).body(view)
    }

    @PutMapping("/{id}")
    fun update(@Valid @RequestBody dto: TopicUpdate, @PathVariable id: Long): ResponseEntity<TopicView> {
        val topic = service.update(id, dto)
        return ResponseEntity.ok(topic.mapToView())
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: Long) {
        service.deleteById(id)
    }


}