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

    @Test
    fun `should make range map`() {
        val range = makeRange("50 98 2")
        assertEquals(range, RangeMap(98, 99, -48))
    }

    val range = RangeMap(15, 20, -5)


    @Test
    fun `should convert when found at start of range`() {
        assertEquals(10, transform(range, 15))
    }


    @Test
    fun `should convert when found in range`() {
        assertEquals(10, transform(range, 15))
    }

    @Test
    fun `should convert when found at end range`() {
        assertEquals(10, transform(range, 15))
    }

    @Test
    fun `should return seed when not found in range`() {
        assertEquals(14, transform(range, 14))
        assertEquals(21, transform(range, 21))
    }


    @Test
    fun `should get various structures`() {
        val convertMaps = parseMaps(lines)

        assertEquals(7, convertMaps.size)

        val convertTypes = listOf("seed|soil", "soil|fertilizer", "fertilizer|water", "water|light", "light|temperature", "temperature|humidity", "humidity|location")
        assertEquals(convertTypes, convertMaps.map{ it.from + "|" + it.to} )

        assertEquals(2, convertMaps[0].rangeMap.size)
        val expected = listOf(RangeMap(sourceFrom=98, sourceTo=99, destinationOffset=-48), RangeMap(sourceFrom=50, sourceTo=97, destinationOffset=2))
        assertEquals(expected, convertMaps[0].rangeMap)
    }

}
