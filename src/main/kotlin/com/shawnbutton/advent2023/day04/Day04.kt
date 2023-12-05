package com.shawnbutton.advent2023.day04

import com.shawnbutton.advent2023.loadFile
import java.lang.Math.pow
import kotlin.math.pow

data class Card(val cardNumber: Int, val winning: List<Int>, val yours: List<Int>, var copies: Int = 1, var wins: Int = 0)

fun parseLine(line: String): Card {
    val cardNumber = line.substringAfter("Card ").substringBefore(":").trim().toInt()
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
    val cards = lines
        .map(::parseLine)

    cards.withIndex().forEach { (index, card) ->
        val winning = countWinning(card.winning, card.yours)
        card.wins = winning

        val endRange = minOf(index + winning, cards.size - 1)
        for (i in index + 1..endRange) {
            cards[i].copies = cards[i].copies + card.copies // add a copy for every copy of this card
        }
    }

    return cards.sumOf { it.copies }

}

fun main() {
    val lines = loadFile("/day04.txt")

    print(doPart1(lines))
    print("\n")
    print(doPart2(lines))
}
