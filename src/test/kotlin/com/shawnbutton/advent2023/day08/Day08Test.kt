package com.shawnbutton.advent2023.day08

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day08Test {

  val lines = listOf("A", "B", "C")

    @Test
    fun `do part a`() {
        val result = doPartA(lines)
        assertEquals(6440, result)
    }

    @Test
    fun `do part b`() {
        val result = doPartB(lines)
        assertEquals(5905, result)
    }
}