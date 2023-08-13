package br.joaquim.forum.service.topic

import br.joaquim.forum.model.topic.Topic
import br.joaquim.forum.model.topic.dto.TopicInput
import br.joaquim.forum.model.topic.dto.TopicUpdate

interface TopicService {
    fun findAll()
    fun findById(id: Long)
    fun create(entity: TopicInput)
    fun update(id: Long, dto: TopicUpdate)
    fun delete(entity: Topic)
    fun deleteById(id: Long)
}