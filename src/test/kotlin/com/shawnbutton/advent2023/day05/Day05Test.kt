package com.shawnbutton.advent2023.day05

import com.shawnbutton.advent2023.loadFile
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day05Test {

    val lines = loadFile("/day05_sample.txt")

    @Test
    fun `should get planted seeds`() {
        assertEquals(getSeeds(lines), listOf(79, 14, 55, 13))
    }

    fun `should make range map`() {
        val range = makeRange("50 98 2")
        assertEquals(range, RangeMap(98, 99, -48))
    }

    val range = RangeMap(15, 20, -5)

    fun `should convert when found at start of range`() {
        assertEquals(10, transform(range, 15))
    }

    fun `should convert when found in range`() {
        assertEquals(10, transform(range, 15))
    }

    fun `should convert when found at end range`() {
        assertEquals(10, transform(range, 15))
    }

    fun `should return seed when not found in range`() {
        assertEquals(14, transform(range, 14))
        assertEquals(21, transform(range, 21))
    }


    fun `should get various structures`() {
        val maps = parseMaps(lines)
        assertEquals(maps).
    }


}
