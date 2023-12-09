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
        assertEquals("32T3K", result)
    }

    fun `can find a pair`() {
        val result = getHandType("AA234")
        assertEquals(result, HandValue.Pair)
    }

    fun `can find two pair`() {
        val result = getHandType("AA223")
        assertEquals(result, HandValue.TwoPair)
    }

    @Test
    fun `can find three of a kind`() {
        val result = getHandType("AAA23")
        assertEquals(result, HandValue.ThreeOfAKind)
    }

    @Test
    fun `can find full house`() {
        val result = getHandType("AAA22")
        assertEquals(result, HandValue.FullHouse)
    }

    @Test
    fun `can find four of a kind`() {
        val result = getHandType("AAAA2")
        assertEquals(result, HandValue.FourOfAKind)
    }

    @Test
    fun `can find five of a kind`() {
        val result = getHandType("AAAAA")
        assertEquals(result, HandValue.FiveOfAKind)
    }

    @Test
    fun `can find high card`() {
        val result = getHandType("A2345")
        assertEquals(result, HandValue.HighCard)
    }

//    @Test
//    fun `same type - highest first card wins`() {
//        val hand1 = listOf("A")
//        val hand2 = listOf("K")
//
//        assertEquals(0, largestWithinRank(hand1, hand2))
//    }
//
//    @Test
//    fun `same type - if first same, second card wins`() {
//        val hand1 = listOf("A", "3")
//        val hand2 = listOf("A", "2")
//
//        assertEquals(0, largestWithinRank(hand1, hand2))
//    }
//
//    @Test
//    fun `same type - third card wins`() {
//        val hand1 = listOf("A", "A", "2")
//        val hand2 = listOf("A", "A", "3")
//
//        assertEquals(1, largestWithinRank(hand1, hand2))
//    }
//
//    @Test
//    fun `rank hands`() {
//        val valuedHands = lines
//            .map { parseHand(it) }
//            .map { getHandType(it) }
//
//        val result = valuedHands
//            .map { it.ordinal }
//            .joinToString("")
//
//        assertEquals("13223", result)
//    }

    @Test
    fun `should sort hands by rank`() {
        val hand1 = Hand("AA234", HandValue.Pair, 111)
        val hand2 = Hand("AA234", HandValue.TwoPair, 111)
        val hand3 = Hand("AA234", HandValue.FullHouse, 111)

        val list1 = listOf(hand1, hand2, hand3).sorted()
        val list2 = listOf(hand3, hand2, hand1).sorted()

        assertContentEquals(listOf(hand1, hand2, hand3), list1)

        assertContentEquals(list1, list2)
    }

    @Test
    fun `should sort hands of same range by card`() {
        val hand1 = Hand("T2222", HandValue.Pair, 111)
        val hand2 = Hand("42222", HandValue.Pair, 111)
        val hand3 = Hand("A2222", HandValue.Pair, 111)

        val sorted = listOf(hand1, hand2, hand3).sorted()

        assertContentEquals(listOf(hand2, hand1, hand3), sorted)
    }

    @Test
    fun `should replace J with all possible cards`() {
        val result1 = allPossibleHands("AKQJT")
        assertEquals(12, result1.size)

        val result2 = allPossibleHands("AKJQJ")
        assertEquals(144, result2.size)
    }

    @Test
    fun `do part a`() {
        val result = doPartA(lines)
        assertEquals(6440, result)
    }

    @Test
    fun `do part b`() {
        val result = doPartB(lines)
        assertEquals(5905, result)
    }
}