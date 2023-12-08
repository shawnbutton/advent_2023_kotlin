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

    val numPairs = groupedByCard.filter { it.value.size == 2 }.size

    val onePair = numPairs == 1
    val twoPairs = numPairs == 2
    val threeOfAKind = groupedByCard.any { it.value.size == 3 }
    val fourOfAKind = groupedByCard.any { it.value.size == 4 }
    val fiveOfAKind = groupedByCard.any { it.value.size == 5 }

    return when {
        fiveOfAKind -> HandValue.FiveOfAKind
        fourOfAKind  -> HandValue.FourOfAKind
        threeOfAKind  && onePair  -> HandValue.FullHouse
        threeOfAKind  -> HandValue.ThreeOfAKind
        twoPairs  -> HandValue.TwoPair
        onePair  -> HandValue.Pair
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
