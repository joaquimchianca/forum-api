package br.joaquim.forum.service.topic

import br.joaquim.forum.model.topic.Topic
import br.joaquim.forum.model.topic.dto.TopicUpdate
import br.joaquim.forum.repository.topic.TopicRepository
import org.springframework.stereotype.Service

@Service
class TopicServiceImpl(
    private val repository: TopicRepository
) : TopicService {
    override fun findAll() {
        repository.findAll()
    }

    override fun findById(id: Long) {
        repository.getReferenceById(id)
    }

    override fun create(entity: Topic) {
        repository.save(entity)
    }

    override fun update(id: Long, dto: TopicUpdate) {
        val old = repository.getReferenceById(id)
        val new = Topic(
            id = old.id,
            title = dto.title,
            text = dto.text,
            dateCreated = old.dateCreated,
            status = old.status,
            author = old.author,
            category = old.category,
            answers = old.answers
        )
        repository.delete(old)
        repository.save(new)
    }

    override fun delete(entity: Topic) {
        repository.delete(entity)
    }

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }

}