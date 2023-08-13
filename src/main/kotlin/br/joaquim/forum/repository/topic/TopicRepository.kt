package br.joaquim.forum.repository.topic

import br.joaquim.forum.model.topic.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository : JpaRepository<Topic, Long> {
}