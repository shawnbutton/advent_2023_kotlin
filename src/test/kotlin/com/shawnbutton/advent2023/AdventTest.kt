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
}