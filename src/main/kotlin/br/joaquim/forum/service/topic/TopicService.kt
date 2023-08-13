package br.joaquim.forum.service.topic

import br.joaquim.forum.model.topic.Topic
import br.joaquim.forum.model.topic.dto.TopicInput
import br.joaquim.forum.model.topic.dto.TopicUpdate

interface TopicService {
    fun findAll(): List<Topic>
    fun findById(id: Long): Topic
    fun create(dto: TopicInput): Topic
    fun update(id: Long, dto: TopicUpdate): Topic
    fun delete(entity: Topic)
    fun deleteById(id: Long)
}