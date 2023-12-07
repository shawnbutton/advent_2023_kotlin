package com.shawnbutton.advent2023.day07

import com.shawnbutton.advent2023.day06.Race

enum class HandValue {
    HighCard,
    Pair,
    TwoPair,
    ThreeOfAKind,
    FullHouse,
    FourOfAKind,
    FiveOfAKind
}

fun parseHand(line: String): List<String> {
    return line.substringBefore(" ").toList().map { it.toString() }
}

fun valueHand(hand: List<String>): HandValue {
    val groupedByCard = hand.groupBy { it }
    val pairs = groupedByCard.filter { it.value.size == 2 }.size

    return when (pairs) {
        1 -> HandValue.Pair
        2 -> HandValue.TwoPair
        else -> HandValue.HighCard
    }

}


fun doPartA(races: List<Race>): Long {
    return -1L
}

fun doPartB(race: Race): Long {
    return -1L
}

fun main() {
//    print(doPart1(races))
    print("\n")

//    print(doPart2(bigRace))
    print("\n")
}
