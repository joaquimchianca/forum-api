package br.joaquim.forum.model.topic

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "tb_topic")
data class Topic(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
    val title: String,
    val text: String,
    val author: String,
    val category: String,
    @Enumerated(EnumType.STRING)
    val status: StatusTopic
) {
    @CreationTimestamp
    val dateCreated: LocalDateTime
        get() = Local
    @OneToMany
    val answers: List<String>
        get() {
            TODO()
        }
}