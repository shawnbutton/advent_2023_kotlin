package com.shawnbutton.advent2023.day04

import com.shawnbutton.advent2023.loadFile
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day04Test {


    @Test
    fun `test part 1`() {
        val lines = loadFile("/day04.txt")

        assertEquals(0, doPart1(lines))
    }

    @Test
    fun `test part 2`() {
        val lines = loadFile("/day04.txt")

        assertEquals(0, doPart2(lines))
    }

}
