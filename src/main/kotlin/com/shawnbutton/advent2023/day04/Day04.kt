package com.shawnbutton.advent2023.day04

import com.shawnbutton.advent2023.loadFile

data class Card(val cardNumber: Int, val winning: List<Int>, val yours: List<Int>)

fun parseLine(line: String): Any {
    val cardNumber = line.substringAfter("Card ").substringBefore(":").toInt()
    val winning = line.substringAfter(": ").substringBefore(" | ").split(" ").map { it.toInt() }
    val yours = line.substringAfter(" | ").split(" ")
        .filter(String::isNotEmpty)
        .map { it.toInt() }

    return Card(cardNumber, winning, yours)
}


fun doPart1(lines: List<String>): Int {
    return -1

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
