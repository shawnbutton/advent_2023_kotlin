package com.shawnbutton.advent2023

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AdventTest {
    @Test
    fun should_calculate_sum() {
        val advent = Advent()

        val result = advent.sum(1, 2)

        assertEquals(3, result)
    }

    @Test
    fun should_calculate_value_of_line_from_digits() {
        val advent = Advent()

        assertEquals(13, advent.calcDigits("x123x"))
        assertEquals(24, advent.calcDigits("234x"))
        assertEquals(35, advent.calcDigits("x345"))
        assertEquals(46, advent.calcDigits("456"))
        assertEquals(77, advent.calcDigits("x7x"))
        assertEquals(88, advent.calcDigits("8"))
    }

}
