package com.shawnbutton.advent2023.day04

import com.shawnbutton.advent2023.loadFile
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day04Test {

    val line0 = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"
    val line1 = "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19"
    val line2 = "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1"
    val line3 = "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83"
    val line4 = "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36"
    val line5 = "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11"

    val lines = listOf(line0, line1, line2, line3, line4, line5)

    @Test
    fun `should parse the line`() {
        val expected = Card(
            1,
            listOf(41, 48, 83, 86, 17),
            listOf(83, 86, 6, 31, 17, 9, 48, 53)
        )

        val response = parseLine(line0)

        assertEquals(expected, response)

    }


}
