package com.shawnbutton.advent2023.day10

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class Day10Test {

    val line1 = "....."
    val line2 = ".S-7."
    val line3 = ".|.|."
    val line4 = ".L-J."
    val line5 = "....."

    val line1Array = arrayOf('.', '.', '.', '.', '.')
    val line3Array = arrayOf('.', '|', '.', '|', '.')

    @Test
    fun `can parse line`() {
        assertContentEquals(line1Array, parseLine(line1))
        assertContentEquals(line3Array, parseLine(line3))
    }

    @Test
    fun `can make a grid`() {
        val lines = listOf(line1, line3)

        val result = createGrid(lines)

        assertContentEquals(line1Array, result[0])
        assertContentEquals(line3Array, result[1])

        assertEquals('|', result[1][1])
    }

    @Test
    fun `can navigate based on character`() {
        val symbolLoc = Coord(5, 5)

        assertEquals(Pair(Coord(5, 4), Coord(5, 6)), connections(symbolLoc, '|'))
        assertEquals(Pair(Coord(4, 5), Coord(6, 5)), connections(symbolLoc, '-'))
        assertEquals(Pair(Coord(6, 6), Coord(4, 4)), connections(symbolLoc, 'L'))
        assertEquals(Pair(Coord(4, 6), Coord(6, 4)), connections(symbolLoc, 'J'))
        assertEquals(Pair(Coord(4, 4), Coord(6, 6)), connections(symbolLoc, '7'))
        assertEquals(Pair(Coord(6, 4), Coord(4, 6)), connections(symbolLoc, 'F'))
    }


//    @Test
//    fun doPartA() {
//        assertEquals(-1, doPartA())
//    }
//
//    @Test
//    fun doPartB() {
//
//        assertEquals(-1, doPartA(line1))
//    }
}
