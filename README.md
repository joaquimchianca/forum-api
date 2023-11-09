# Forum Rest API
## This repo was made for study purpose only
## Description
A forum Rest API with topics, responses for a topic, users and category features.
The project idea was based on a simple forum. The objective here is to train my skills
for backend programming using Kotlin instead of Java.
### Tech Stack
 - **Spring Boot**: a powerful backend framework who supports Kotlin language. Largely used
 - **Kotlin**: a JVM based programming language created by Jetbrains.
by the tech industry.
 - **H2 Database**: a lightweight in-memory database designed to simulate the behavior of a SQL
database. Most used in development environment.
### To-do
 - [ ] Pagination and cache in Topic Controller. Need to learn how to implement 
a real cache service (Cache must be here to be an API).
 - [ ] Fix bean validation on TopicUpdate
 - [ ] Filter on topic search (category)
 - [ ] CRUD User
 - [ ] CRUD Category
 - [ ] CRUD Answers
 - [ ] JWT Token (security)
 - [ ] Change DB. Create migrations