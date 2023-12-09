package com.shawnbutton.advent2023.day08

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.Ignore

class Day08Test {

  val lines = listOf("A", "B", "C")

    @Test
    @Ignore
    fun `do part a`() {
        val result = doPartA(lines)
        assertEquals(6440, result)
    }

    @Test
    @Ignore
    fun `do part b`() {
        val result = doPartB(lines)
        assertEquals(5905, result)
    }
}