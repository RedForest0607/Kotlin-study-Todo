package com.example.study2

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Study2Application

fun main(args: Array<String>) {
    runApplication<Study2Application>(*args){
        setBannerMode(Banner.Mode.OFF)
    }
}
