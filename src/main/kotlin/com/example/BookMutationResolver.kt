package com.example

import graphql.kickstart.tools.GraphQLMutationResolver

import javax.inject.Singleton
import javax.transaction.Transactional

@Singleton

open class BookMutationResolver(val bookRepository: BookRepository) : GraphQLMutationResolver {

    @Transactional
    open fun createBook(title: String): Book {
        val book = Book(title, 43)
        val savedBook = bookRepository.save(book)
        return savedBook
    }

}