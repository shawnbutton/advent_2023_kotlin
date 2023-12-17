package com.shawnbutton.advent2023.day09

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day09Test {

    val line1 = "0 3 6 9 12 15"
    val line2 = "1 3 6 10 15 21"
    val line3 = "10 13 16 21 30 45"

//    val lines = listOf(line2, line3)
    val lines = listOf(line1, line2, line3)

    @Test
    fun `should parse history line`() {
        assertEquals(listOf(0, 3, 6, 9, 12, 15), parseHistory(line1))
    }

    @Test
    fun `should get change sequence`() {
        val values = parseHistory(line1)

        assertEquals(listOf(3, 3, 3, 3, 3), getChangeSequence(values))
    }

    @Test
    fun `should recursively get change sequence`() {
        val values = parseHistory(line1)

        val expected = listOf(
            listOf(0, 3, 6, 9, 12, 15, 18),
            listOf(3, 3, 3, 3, 3, 3),
            listOf(0, 0, 0, 0, 0)
        )

        assertEquals(expected, getChangeSequencyRecursively(values))
    }

    @Test
    fun doPartA() {

        assertEquals(114, doPartA(lines))
    }
}

//15
//18
//21
