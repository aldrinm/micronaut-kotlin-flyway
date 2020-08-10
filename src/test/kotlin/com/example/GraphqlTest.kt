package com.example

import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class GraphqlTest {
    @Inject
    lateinit var client: GraphqlClient

    @Test
    fun `should say hello`() {
        val query = """
                query {
                    books {
                        id
                        title
                    }
                }
        """.trimIndent()
        assertEquals("{data={books=[]}}", client.postQuery(query).blockingGet().toString())
    }

}
