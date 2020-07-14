package com.example

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import javax.inject.Inject

@Controller("/hello")
class HelloController {

    @Inject
    lateinit var bookRepository: BookRepository

    @Get(produces = [MediaType.TEXT_PLAIN])
    fun index(): String {
        return "Hello World"
    }

    @Get(value = "createbook")
    fun createBook(): String {
        println("bookRepository = ${bookRepository}")

        val book = Book(0, "The Stand", 1000)
        bookRepository.save(book)

        return "Hello World"
    }

    @Get(value = "allbooks")
    fun listBooks(): List<String> {
        return bookRepository.findAll().map { it.title }
    }
}

