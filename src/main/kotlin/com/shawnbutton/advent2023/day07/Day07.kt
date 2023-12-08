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
    val threeOfAKind = groupedByCard.filter { it.value.size == 3 }.size
    val fourOfAKind = groupedByCard.filter { it.value.size == 4 }.size
    val fiveOfAKind = groupedByCard.filter { it.value.size == 5 }.size

    return when {
        fiveOfAKind == 1 -> HandValue.FiveOfAKind
        fourOfAKind == 1 -> HandValue.FourOfAKind
        threeOfAKind == 1 && pairs == 1 -> HandValue.FullHouse
        threeOfAKind == 1 -> HandValue.ThreeOfAKind
        pairs == 2 -> HandValue.TwoPair
        pairs == 1 -> HandValue.Pair
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
