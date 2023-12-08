package com.shawnbutton.advent2023.day07

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class Day07Test {

    val line1 = "32T3K 765" // pair
    val line2 = "T55J5 684" // three of a kind
    val line3 = "KK677 28" // two pair
    val line4 = "KTJJT 220" // two pair
    val line5 = "QQQJA 483" // three of a kind

    val lines = listOf(line1, line2, line3, line4, line5)

    @Test
    fun `can parse a hand`() {
        val result = parseHand(line1)
        assertContentEquals(listOf("3", "2", "T", "3", "K"), result)
    }

    fun `can find a pair`() {
        val result = rankHand(listOf("A", "A", "2", "3", "4"))
        assertEquals(result, HandValue.Pair)
    }

    fun `can find two pair`() {
        val result = rankHand(listOf("A", "A", "2", "2", "3"))
        assertEquals(result, HandValue.TwoPair)
    }

    @Test
    fun `can find three of a kind`() {
        val result = rankHand(listOf("A", "A", "A", "2", "3"))
        assertEquals(result, HandValue.ThreeOfAKind)
    }

    @Test
    fun `can find full house`() {
        val result = rankHand(listOf("A", "A", "A", "2", "2"))
        assertEquals(result, HandValue.FullHouse)
    }

    @Test
    fun `can find four of a kind`() {
        val result = rankHand(listOf("A", "A", "A", "A", "2"))
        assertEquals(result, HandValue.FourOfAKind)
    }

    @Test
    fun `can find five of a kind`() {
        val result = rankHand(listOf("A", "A", "A", "A", "A"))
        assertEquals(result, HandValue.FiveOfAKind)
    }

    @Test
    fun `can find high card`() {
        val result = rankHand(listOf("A", "2", "3", "4", "5"))
        assertEquals(result, HandValue.HighCard)
    }

    @Test
    fun `same rank - highest first card wins`() {
        val hand1 = listOf("A")
        val hand2 = listOf("K")

        assertEquals(0, largestWithinRank(hand1, hand2))
    }

    @Test
    fun `same rank - if first same, second card wins`() {
        val hand1 = listOf("A", "3")
        val hand2 = listOf("A", "2")

        assertEquals(0, largestWithinRank(hand1, hand2))
    }

    @Test
    fun `same rank - third card wins`() {
        val hand1 = listOf("A", "A", "2")
        val hand2 = listOf("A", "A", "3")

        assertEquals(1, largestWithinRank(hand1, hand2))
    }

    @Test
    fun `rank hands`() {
        val valuedHands = lines
            .map { parseHand(it) }
            .map { rankHand(it) }

        val result = valuedHands
            .map { it.ordinal }
            .joinToString("")

        assertEquals("13223", result)
    }

}