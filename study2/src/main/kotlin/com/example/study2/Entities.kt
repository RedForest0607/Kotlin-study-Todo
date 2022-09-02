package com.example.study2

import java.time.LocalDateTime
import javax.persistence.*


class Entities {

    @Entity
    class Article(
        var title: String,
        val headline: String,
        var content: String,
        @ManyToOne var author: User,
        var slug: String = title.toSlug(),
        var addedAt: LocalDateTime = LocalDateTime.now(),
        @Id @GeneratedValue var id: Long?=null)

    @Entity
    class User(
        var login: String,
        var firstname: String,
        var lastname: String,
        var description: String?=null,
        @Id @GeneratedValue var id: Long?=null
    )
}