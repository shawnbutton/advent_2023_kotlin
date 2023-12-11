package com.shawnbutton.advent2023.day09

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day09Test {

    val line1 = "0 3 6 9 12 15"
    val line2 = "1 3 6 10 15 21"
    val line3 = "10 13 16 21 30 45"

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
            listOf(0, 3, 6, 9, 12, 15),
            listOf(3, 3, 3, 3, 3),
            listOf(0, 0, 0, 0)
        )

        assertEquals(expected, getChangeSequencyRecursively(values))
    }

    @Test
    fun doPartA() {
//        val lines = loadFile("/day09.txt")
//        assertEquals(542529149, doPartA(lines))
    }
}