package com.example.study2.repository

import com.example.study2.Entities
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Entities.Article, Long> {
    fun findBySlug(slug: String): Entities.Article?
    fun findAllByOrderByAddedAtDesc(): Iterable<Entities.Article>
}

interface UserRepository : CrudRepository<Entities.User, Long> {
    fun findByLogin(login: String): Entities.User?
}