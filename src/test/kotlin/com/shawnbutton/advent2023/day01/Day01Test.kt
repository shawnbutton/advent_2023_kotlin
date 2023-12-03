package com.shawnbutton.advent2023.day01

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Day01Test {
    @Test
    fun should_calculate_value_of_line_from_digits() {
        Assertions.assertEquals(13, calcDigits("x123x"))
        Assertions.assertEquals(24, calcDigits("234x"))
        Assertions.assertEquals(35, calcDigits("x345"))
        Assertions.assertEquals(46, calcDigits("456"))
        Assertions.assertEquals(77, calcDigits("x7x"))
        Assertions.assertEquals(88, calcDigits("8"))
    }

    @Test
    fun should_sum_lines() {
        val lines = listOf("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7")
        Assertions.assertEquals(sumAll(lines), 142)
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
        Assertions.assertEquals(29, calcDigitsWithWords("two1nine"))
        Assertions.assertEquals(83, calcDigitsWithWords("eightwothree"))
        Assertions.assertEquals(13, calcDigitsWithWords("abcone2threexyz"))
        Assertions.assertEquals(24, calcDigitsWithWords("xtwone3four"))
        Assertions.assertEquals(42, calcDigitsWithWords("4nineeightseven2"))
        Assertions.assertEquals(14, calcDigitsWithWords("zoneight234"))
        Assertions.assertEquals(76, calcDigitsWithWords("7pqrstsixteen"))
    }

    @Test
    fun shouldGetPositionsInString() {
        Assertions.assertEquals(getPositionsOfTokenInString("A", "A"), listOf(0))
        Assertions.assertEquals(getPositionsOfTokenInString("AA", "A"), listOf(0, 1))
        Assertions.assertEquals(getPositionsOfTokenInString("ABA", "A"), listOf(0, 2))
        Assertions.assertEquals(getPositionsOfTokenInString("BABBBAB", "A"), listOf(1, 5))
        Assertions.assertEquals(getPositionsOfTokenInString("4nineeightseven2", "nine"), listOf(1))
    }

    @Test
    fun shouldGetLowestListFromListOfListOfNumbers() {
        val list1 = listOf(3, 4)
        val listLowest = listOf(2, 6)
        val list3 = listOf(5, 7)

        Assertions.assertEquals(firstToken(listOf(list1, listLowest, list3)), 1)
        Assertions.assertEquals(firstToken(listOf(listLowest, list1, list3)), 0)
    }


    @Test
    fun shouldSumAllWithWords() {



    }

}