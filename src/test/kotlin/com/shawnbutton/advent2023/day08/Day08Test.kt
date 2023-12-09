package com.shawnbutton.advent2023.day08

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.Ignore

class Day08Test {


    val lines = listOf(
        "RRRLR",
        "",
        "AAA = (BBB, CCC)",
        "BBB = (DDD, EEE)",
        "CCC = (ZZZ, GGG)",
        "DDD = (EEE, DDD)",
        "EEE = (EEE, ZZZ)",
        "GGG = (GGG, DDD)",
        "ZZZ = (ZZZ, ZZZ)"
    )

    @Test
    fun `should get left right instructions`() {
        val leftRight = getIntructions(lines)
        assertEquals("RRRLR", leftRight)
    }

    @Test
    fun `should get map of directions`() {
        val graph = getGraph(lines)
        val expected = mapOf(
            "AAA" to Pair("BBB", "CCC"),
            "BBB" to Pair("DDD", "EEE"),
            "CCC" to Pair("ZZZ", "GGG"),
            "DDD" to Pair("EEE", "DDD"),
            "EEE" to Pair("EEE", "ZZZ"),
            "GGG" to Pair("GGG", "DDD"),
            "ZZZ" to Pair("ZZZ", "ZZZ")
        )
        assertEquals(expected, graph)
    }

    @Test
    fun `do part a`() {
        val result = doPartA(lines)
        assertEquals(5, result)
    }

    @Test
    fun `do part a with repeating instructions`() {
        val lines6Turns = listOf(
            "LLR",
            "",
            "AAA = (BBB, BBB)",
            "BBB = (AAA, ZZZ)",
            "ZZZ = (ZZZ, ZZZ)"
        )

        val result = doPartA(lines6Turns)
        assertEquals(6, result)
    }

    @Test
    @Ignore
    fun `do part b`() {
        val result = doPartB(lines)
        assertEquals(5905, result)
    }
}