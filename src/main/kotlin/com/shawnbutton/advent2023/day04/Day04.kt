package com.shawnbutton.advent2023.day04

import com.shawnbutton.advent2023.loadFile
import java.lang.Math.pow
import kotlin.math.pow

data class Card(val cardNumber: Int, val winning: List<Int>, val yours: List<Int>)

fun parseLine(line: String): Card {
    val cardNumber = line.substringAfter("Card ").substringBefore(":").toInt()
    val winning = line.substringAfter(": ").substringBefore(" | ").split(" ")
        .filter(String::isNotEmpty)
        .map { it.toInt() }
    val yours = line.substringAfter(" | ").split(" ")
        .filter(String::isNotEmpty)
        .map { it.toInt() }

    return Card(cardNumber, winning, yours)
}

fun countWinning(winning: List<Int>, yours: List<Int>): Int {
    return winning
        .filter { yours.contains(it) }
        .count()
}


fun doPart1(lines: List<String>): Int {
    return lines
        .map(::parseLine)
        .map { countWinning(it.winning, it.yours) }
        .map{ (2.0).pow(it - 1).toInt() }
        .sumOf { it}
}


fun doPart2(lines: List<String>): Int {
    return -1
}

fun main() {
    val lines = loadFile("/day04.txt")

    print(doPart1(lines))
    print("\n")
    print(doPart2(lines))
}
