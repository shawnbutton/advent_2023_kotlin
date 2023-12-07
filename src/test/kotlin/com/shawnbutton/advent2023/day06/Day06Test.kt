package com.shawnbutton.advent2023.day06

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day06Test {

    val race1 = Race(7, 9)
    val race2 = Race(15, 40)
    val race3 = Race(30, 200)

    @Test
    fun `should count ways to win`() {
        assertEquals(4, waysToWin(race1))
        assertEquals(8, waysToWin(race2))
        assertEquals(9, waysToWin(race3))
    }

    @Test
    fun `should do part 1`() {
        assertEquals(288, doPart1(listOf(race1, race2, race3)))
    }

}