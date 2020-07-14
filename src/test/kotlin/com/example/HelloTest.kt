package com.example

import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class HelloTest {
    @Inject
    lateinit var client: HelloClient

    @Test
    fun `should say hello`() {
        assertEquals("Hello World", client.hello().blockingGet())
    }

}
