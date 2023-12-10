package com.shawnbutton.advent2023.day08

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

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
        assertEquals(5L, result)
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
        assertEquals(6L, result)
    }

    @Test
    fun `do part b`() {
        val linesB = listOf(
            "LRLR",
            "",
            "11A = (11B, XXX)",
            "11B = (XXX, 11Z)",
            "11Z = (11B, XXX)",
            "22A = (22B, XXX)",
            "22B = (22C, 22C)",
            "22C = (22Z, 22Z)",
            "22Z = (22B, 22B)",
            "XXX = (XXX, XXX)",
            "SSA = (SSB, SSA)",
            "SSB = (SSB, SSC)",
            "SSC = (SSD, SSC)",
            "SSD = (SSD, SSE)",
            "SSE = (SSF, SSE)",
            "SSF = (SSF, SSZ)",
            "SSZ = (SSA, SSA)",
        )

        val result = doPartB(linesB)
        assertEquals(6L, result)
    }
}