package com.shawnbutton.advent2023.day08

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.Ignore

class Day08Test {


    val lines = listOf(
        "RL",
        "",
        "AAA = (BBB, CCC)",
        "BBB = (DDD, EEE)",
        "CCC = (ZZZ, GGG)",
        "DDD = (DDD, DDD)",
        "EEE = (EEE, EEE)",
        "GGG = (GGG, GGG)",
        "ZZZ = (ZZZ, ZZZ)"
    )

    @Test
    fun `should get left right instructions`() {
        val leftRight = getIntructions(lines)
        assertEquals("RL", leftRight)
    }

    @Test
    fun `should get map of directions`() {
        val directions = getDirections(lines)
        val expected = mapOf(
            "AAA" to Pair("BBB", "CCC"),
            "BBB" to Pair("DDD", "EEE"),
            "CCC" to Pair("ZZZ", "GGG"),
            "DDD" to Pair("DDD", "DDD"),
            "EEE" to Pair("EEE", "EEE"),
            "GGG" to Pair("GGG", "GGG"),
            "ZZZ" to Pair("ZZZ", "ZZZ")
        )
        assertEquals(expected, directions)
    }

    @Test
    @Ignore
    fun `do part a`() {
        val result = doPartA(lines)
        assertEquals(6440, result)
    }

    @Test
    @Ignore
    fun `do part b`() {
        val result = doPartB(lines)
        assertEquals(5905, result)
    }
}