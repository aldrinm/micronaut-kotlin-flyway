package com.example

import javax.persistence.*

@Entity
data class Book(@Id
                @SequenceGenerator(name= "BOOK_SEQUENCE", sequenceName = "BOOK_SEQUENCE_ID", initialValue=1, allocationSize = 1)
                @GeneratedValue(strategy = GenerationType.AUTO, generator="BOOK_SEQUENCE")
                var id: Long?,
                var title: String,
                var pages: Int = 0) {
    constructor(title: String, pages: Int) : this(null, title, pages)
}