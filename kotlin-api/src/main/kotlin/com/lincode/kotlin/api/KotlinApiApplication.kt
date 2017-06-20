package com.lincode.kotlin.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@EnableAutoConfiguration
open class KotlinApiApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinApiApplication::class.java, *args)
}