package com.shawnbutton.advent2023

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day01Test {
    @Test
    fun should_calculate_value_of_line_from_digits() {
        assertEquals(13, calcDigits("x123x"))
        assertEquals(24, calcDigits("234x"))
        assertEquals(35, calcDigits("x345"))
        assertEquals(46, calcDigits("456"))
        assertEquals(77, calcDigits("x7x"))
        assertEquals(88, calcDigits("8"))
    }

    @Test
    fun should_sum_lines() {
        val lines = listOf("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7")
        assertEquals(sumAll(lines), 142)
    }

    val sampleB = listOf(
        "two1nine",
        "eightwothree",
        "abcone2threexyz",
        "xtwone3four",
        "4nineeightseven2",
        "zoneight234",
        "7pqrstsixteen"
    )

    @Test
    fun shouldConsiderSpelledLetters() {
        assertEquals(29, calcDigitsWithWords("two1nine"))
        assertEquals(83, calcDigitsWithWords("eightwothree"))
        assertEquals(13, calcDigitsWithWords("abcone2threexyz"))
        assertEquals(24, calcDigitsWithWords("xtwone3four"))
        assertEquals(42, calcDigitsWithWords("4nineeightseven2"))
        assertEquals(14, calcDigitsWithWords("zoneight234"))
        assertEquals(76, calcDigitsWithWords("7pqrstsixteen"))
    }

    @Test
    fun shouldGetPositionsInString() {
        assertEquals(getPositionsOfTokenInString("A", "A"), listOf(0))
        assertEquals(getPositionsOfTokenInString("AA", "A"), listOf(0, 1))
        assertEquals(getPositionsOfTokenInString("ABA", "A"), listOf(0, 2))
        assertEquals(getPositionsOfTokenInString("BABBBAB", "A"), listOf(1, 5))
        assertEquals(getPositionsOfTokenInString("4nineeightseven2", "nine"), listOf(1))
    }

    @Test
    fun shouldGetLowestListFromListOfListOfNumbers() {
        val list1 = listOf(3, 4)
        val listLowest = listOf(2, 6)
        val list3 = listOf(5, 7)

        assertEquals(firstToken(listOf(list1, listLowest, list3)), 1)
        assertEquals(firstToken(listOf(listLowest, list1, list3)), 0)
    }


    @Test
    fun shouldSumAllWithWords() {



    }

}
