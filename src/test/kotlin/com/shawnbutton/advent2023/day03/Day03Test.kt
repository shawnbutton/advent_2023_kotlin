package com.shawnbutton.advent2023.day03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day03Test {

    val line0 = "467..114.."
    val line1 = "...*......"
    val line2 = "..35..633."
    val line3 = "......#..."
    val line4 = "617*......"
    val line5 = ".....+.58."
    val line6 = "..592....."
    val line7 = "......755."
    val line8 = "...$.*...."
    val line9 = ".664.598.."

    @Test
    fun shouldMakeListOfSymbolsLocations() {
        assertEquals(listOf<Int>(), getPositionsOfSymbolsInString(""))
        assertEquals(listOf(0), getPositionsOfSymbolsInString("*"))
        assertEquals(listOf(0,1), getPositionsOfSymbolsInString("++"))
        assertEquals(listOf(1), getPositionsOfSymbolsInString(".+"))
        assertEquals(listOf(11), getPositionsOfSymbolsInString(".0123456789+"))
    }

    @Test
    fun shouldMakeListOfPartLocations() {
        assertEquals(listOf(Part(123, 0, 2)), getPositionsOfPartsInString("123"))
        assertEquals(listOf(Part(123, 0, 2)), getPositionsOfPartsInString("123"))
        assertEquals(listOf(Part(value=123, start=1, end=3), Part(value=45, start=5, end=6)), getPositionsOfPartsInString("#123$45%"))
    }


    @Test
    fun shouldDetermineIfSymbolForPart() {
        assertEquals(false,
            isSymbolForPart(Part(123, 10, 12), listOf(8)))

        assertEquals(true,
            isSymbolForPart(Part(123, 10, 12), listOf(9)))
        assertEquals(true,
            isSymbolForPart(Part(123, 10, 12), listOf(10)))
        assertEquals(true,
            isSymbolForPart(Part(123, 10, 12), listOf(11)))
        assertEquals(true,
            isSymbolForPart(Part(123, 10, 12), listOf(12)))
        assertEquals(true,
            isSymbolForPart(Part(123, 10, 12), listOf(13)))

        assertEquals(false,
            isSymbolForPart(Part(123, 10, 12), listOf(14)))
    }

}
