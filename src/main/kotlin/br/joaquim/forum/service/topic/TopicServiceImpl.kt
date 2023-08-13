package br.joaquim.forum.service.topic

import br.joaquim.forum.model.topic.Topic
import br.joaquim.forum.model.topic.dto.TopicInput
import br.joaquim.forum.model.topic.dto.TopicUpdate
import br.joaquim.forum.repository.topic.TopicRepository
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(
    private val repository: TopicRepository
) : TopicService {
    override fun findAll(): List<Topic> {
        return repository.findAll()
    }

    override fun findById(id: Long): Topic {
        return repository.getReferenceById(id)
    }

    override fun create(dto: TopicInput): Topic {
        val topic = Topic().convertWhenCreate(dto)
        return repository.save(topic)
    }

    override fun update(id: Long, dto: TopicUpdate): Topic {
        val topic = repository.getReferenceById(id)
        topic.convertUpdate(dto)
        return repository.save(topic)
    }

    override fun delete(entity: Topic) {
        repository.delete(entity)
    }

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }

}