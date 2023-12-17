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
    fun `should get change sequence to 0`() {
        val values = parseHistory(line1)

        val expected = listOf(
            listOf(0, 0, 0, 0),
            listOf(3, 3, 3, 3, 3),
            listOf(0, 3, 6, 9, 12, 15)
        )

        assertEquals(expected, extendSequenceTo0(values))
    }

    @Test
    fun `should extend change sequence to right`() {
        val values = parseHistory(line1)

        val expected = listOf(
            listOf(0, 3, 6, 9, 12, 15, 18),
            listOf(3, 3, 3, 3, 3, 3),
            listOf(0, 0, 0, 0, 0)
        )

        assertEquals(expected, extendChangeSequencyToRight(values))
    }

    @Test
    fun `should extend change sequence to left`() {
        val values = parseHistory(line3)

        val expected = listOf(
            listOf(5, 10, 13, 16, 21, 30, 45),
            listOf(5, 3, 3, 5, 9, 15),
            listOf(-2, 0, 2, 4, 6),
            listOf(2, 2, 2, 2),
            listOf(0, 0, 0)
        )

        assertEquals(expected, extendChangeSequencyToLeft(values))
    }

    @Test
    fun doPartA() {

        assertEquals(114, doPartA(lines))
    }
}

//15
//18
//21
