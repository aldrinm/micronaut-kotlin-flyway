package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import javax.inject.Inject

@Controller("/books")
class BookController {

    @Inject
    lateinit var bookRepository: BookRepository

    @Post
    fun createBook(book: Book): Book {
        val savedBook = bookRepository.save(book)

        return savedBook
    }

    @Get
    fun listBooks(): List<Book> {
        return bookRepository.findAll().toList()
    }
}

