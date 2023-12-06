package com.shawnbutton.advent2023.day05

import com.shawnbutton.advent2023.loadFile
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class Day05Test {

    val lines = loadFile("/day05_sample.txt")

    @Test
    fun `should get planted seeds`() {
        assertEquals(getSeeds(lines), listOf(79L, 14, 55, 13))
    }

    @Test
    fun `should make range map`() {
        val range = makeRange("50 98 2")
        assertEquals(range, RangeMap(98, 99, -48))
    }

    val range = RangeMap(15, 20, -5)


    @Test
    fun `should convert when found at start of range`() {
        assertEquals(10, transformOneRange(range, 15))
    }


    @Test
    fun `should convert when found in range`() {
        assertEquals(10, transformOneRange(range, 15))
    }

    @Test
    fun `should convert when found at end range`() {
        assertEquals(10, transformOneRange(range, 15))
    }

    @Test
    fun `should return seed when not found in range`() {
        assertEquals(14, transformOneRange(range, 14))
        assertEquals(21, transformOneRange(range, 21))
    }

    @Test
    fun `should transform through multiple ranges`() {
        val range1 = RangeMap(5, 10, 15)
        val range2 = RangeMap(20, 24, 20)
        val ranges = listOf(range1, range2)

        assertEquals(16, transformAll(ranges, 16)) // miss entirely
        assertEquals(22, transformAll(ranges, 7))  // hit first
        assertEquals(43, transformAll(ranges, 23)) // hit second
    }

    @Test
    fun `should use the first transform of overlappiong ranges`() {
        val range1 = RangeMap(5, 20, 10)
        val range2 = RangeMap(10, 30, 20)
        val ranges = listOf(range1, range2)

        assertEquals(25, transformAll(ranges, 15)) // miss entirely
    }

    @Test
    fun `should get various structures`() {
        val convertMaps = parseMaps(lines)

        assertEquals(7, convertMaps.size)

        val convertTypes = listOf(
            "seed|soil",
            "soil|fertilizer",
            "fertilizer|water",
            "water|light",
            "light|temperature",
            "temperature|humidity",
            "humidity|location"
        )
        assertEquals(convertTypes, convertMaps.map { it.from + "|" + it.to })

        assertEquals(2, convertMaps[0].rangeMap.size)
        val expected = listOf(
            RangeMap(sourceFrom = 98, sourceTo = 99, destinationOffset = -48),
            RangeMap(sourceFrom = 50, sourceTo = 97, destinationOffset = 2)
        )
        assertEquals(expected, convertMaps[0].rangeMap)
    }

    @Test
    fun `all mappings should work`() {
        val convertMaps = parseMaps(lines)

        val seed = 79L

        val soil = transformAll(convertMaps[0].rangeMap, seed)
        assertEquals(81, soil)

        val fertilizer = transformAll(convertMaps[1].rangeMap, soil)
        assertEquals(81, fertilizer)

        val water = transformAll(convertMaps[2].rangeMap, fertilizer)
        assertEquals(81, water)

        val light = transformAll(convertMaps[3].rangeMap, water)
        assertEquals(74, light)

        val temperature = transformAll(convertMaps[4].rangeMap, light)
        assertEquals(78, temperature)

        val humidity = transformAll(convertMaps[5].rangeMap, temperature)
        assertEquals(78, humidity)

        val location = transformAll(convertMaps[6].rangeMap, humidity)
        assertEquals(82, location)
    }

    @Test
    fun `should do multiple mappings`() {
        val convertMaps = parseMaps(lines)
        assertEquals(43, performAllTransforms(convertMaps, 14))
    }

    @Test
    fun `get seeds as ranges`() {
        val expectedA = Pair(79L, 92)
        val expectedB = Pair(55L, 67)
        val expected: List<Pair<Long, Int>> = listOf(expectedA, expectedB)

        val result = getSeedsAsRanges(lines)
        assertEquals(2, result.size)
    }

    @Test
    fun `should do part 1`() {
        assertEquals(35, doPart1(lines))

    }
    @Test
    fun `should do part 2`() {
        assertEquals(46, doPart2(lines))
    }

}
