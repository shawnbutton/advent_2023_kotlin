package com.shawnbutton.advent2023.day10

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class Day10Test {

    val line1 = "....."
    val line2 = ".S-7."
    val line3 = ".|.|."
    val line4 = ".L-J."
    val line5 = "....."

    @Test
    fun `can parse line`() {
        assertContentEquals(arrayOf('.', '.', '.', '.', '.'), parseLine(line1))
        assertContentEquals(arrayOf('.', '|', '.', '|', '.'), parseLine(line3))
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
