package com.example

import graphql.kickstart.tools.GraphQLQueryResolver
import javax.inject.Singleton

//Note: Using Repositories directly here, but it might be better to use Services instead
@Singleton
class BookQueryResolver(val bookRepository: BookRepository) : GraphQLQueryResolver {

    fun books(): Iterable<Book> {
        return bookRepository.findAll()
    }

}