package br.joaquim.forum.model.topic

import br.joaquim.forum.model.topic.dto.TopicInput
import br.joaquim.forum.model.topic.dto.TopicUpdate
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "tb_topic")
data class Topic(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    private var title: String = "",
    @Column(columnDefinition = "TEXT")
    private var text: String = "",
    private var author: String = "",
    private var category: String = "",
    @Enumerated(EnumType.STRING)
    private var status: StatusTopic = StatusTopic.OPEN,
    @CreationTimestamp
    private val dateCreated: LocalDateTime = LocalDateTime.now(),
    private var answers: List<String> = listOf()
) {
    fun convertWhenCreate(dto: TopicInput): Topic {
        this.title = dto.title
        this.text = dto.text
        this.author = dto.author
        this.category = dto.category
        this.answers = listOf()
        this.status = StatusTopic.OPEN
        return this
    }

    fun convertUpdate(dto: TopicUpdate) {
        this.title = dto.title
        this.text = dto.text
    }
}