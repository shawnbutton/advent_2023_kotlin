package com.shawnbutton.advent2023.day03

import com.shawnbutton.advent2023.day02.game1
import com.shawnbutton.advent2023.day02.parseGame
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
    fun shouldListOfSymbolsLocations() {
        assertEquals(listOf<Int>(), getPositionsOfSymbolsInString(""))
        assertEquals(listOf(0), getPositionsOfSymbolsInString("*"))
        assertEquals(listOf(0,1), getPositionsOfSymbolsInString("++"))
        assertEquals(listOf(1), getPositionsOfSymbolsInString(".+"))
        assertEquals(listOf(11), getPositionsOfSymbolsInString(".0123456789+"))

    }



}
