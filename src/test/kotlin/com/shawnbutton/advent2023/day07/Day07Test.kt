package com.shawnbutton.advent2023.day07

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class Day07Test {

    val line1 = "32T3K 765"
    val line2 = "T55J5 684"
    val line3 = "KK677 28"
    val line4 = "KTJJT 220"
    val line5 = "QQQJA 483"

    val lines = listOf(line1, line2, line3, line4, line5)

    @Test
    fun `can parse a hand`() {
        val result = parseHand(line1)
        assertContentEquals(listOf("3", "2", "T", "3", "K"), result)
    }

    fun `can find a pair`() {
        val result = valueHand(listOf("A", "A", "2", "3", "4"))
        assertEquals(result, HandValue.Pair)
    }

    fun `can find two pair`() {
        val result = valueHand(listOf("A", "A", "2", "2", "3"))
        assertEquals(result, HandValue.TwoPair)
    }

    @Test
    fun `can find three of a kind`() {
        val result = valueHand(listOf("A", "A", "A", "2", "3"))
        assertEquals(result, HandValue.ThreeOfAKind)
    }

    @Test
    fun `can find full house`() {
        val result = valueHand(listOf("A", "A", "A", "2", "2"))
        assertEquals(result, HandValue.FullHouse)
    }

    @Test
    fun `can find four of a kind`() {
        val result = valueHand(listOf("A", "A", "A", "A", "2"))
        assertEquals(result, HandValue.FourOfAKind)
    }

    @Test
    fun `can find five of a kind`() {
        val result = valueHand(listOf("A", "A", "A", "A", "A"))
        assertEquals(result, HandValue.FiveOfAKind)
    }

}