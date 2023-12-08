package com.shawnbutton.advent2023.day07

import com.shawnbutton.advent2023.day06.Race
import com.shawnbutton.advent2023.loadFile

data class Hand(val cards: List<String>, val type: HandValue, val bid: Int) : Comparable<Hand> {
    override fun compareTo(other: Hand) =
        compareValuesBy(
            this, other,
            { it.type.ordinal },
            { rankMap[it.cards[0]] },
            { rankMap[it.cards[1]] },
            { rankMap[it.cards[2]] },
            { rankMap[it.cards[3]] },
            { rankMap[it.cards[4]] },
        )
}

enum class HandValue {
    HighCard,
    Pair,
    TwoPair,
    ThreeOfAKind,
    FullHouse,
    FourOfAKind,
    FiveOfAKind
}

val rankMap = mapOf(
    "A" to 14,
    "K" to 13,
    "Q" to 12,
    "J" to 11,
    "T" to 10,
    "9" to 9,
    "8" to 8,
    "7" to 7,
    "6" to 6,
    "5" to 5,
    "4" to 4,
    "3" to 3,
    "2" to 2
)

fun parseHand(line: String): List<String> {
    return line.substringBefore(" ").toList().map { it.toString() }
}

fun getHandType(hand: List<String>): HandValue {
    val groupedByCard = hand.groupBy { it }

    val numPairs = groupedByCard.filter { it.value.size == 2 }.size

    val onePair = numPairs == 1
    val twoPairs = numPairs == 2
    val threeOfAKind = groupedByCard.any { it.value.size == 3 }
    val fourOfAKind = groupedByCard.any { it.value.size == 4 }
    val fiveOfAKind = groupedByCard.any { it.value.size == 5 }

    return when {
        fiveOfAKind -> HandValue.FiveOfAKind
        fourOfAKind -> HandValue.FourOfAKind
        threeOfAKind && onePair -> HandValue.FullHouse
        threeOfAKind -> HandValue.ThreeOfAKind
        twoPairs -> HandValue.TwoPair
        onePair -> HandValue.Pair
        else -> HandValue.HighCard
    }
}

//fun largestWithinRank(hand1: List<String>, hand2: List<String>): Int {
//    hand1
//        .zip(hand2)
//        .first { it.first != it.second }
//        .let { (card1, card2) ->
//            return getCardValue(card1).compareTo(getCardValue(card2))
//        }
//}

private fun getCardValue(card: String): Int {
    print("card: $card")
    return rankMap.get(card)!!
}

fun doPartA(lines: List<String>): Int {
    val hands = lines.map { parseHand(it) }
    val bids = lines.map { it.substringAfter(" ").toInt() }

    val total = hands.zip(bids)
        .map {
            Hand(it.first, getHandType(it.first), it.second)
        }
        .sorted()
        .withIndex()
        .sumOf {
            (it.index + 1) * it.value.bid
        }

    return total
}


fun doPartB(race: Race): Long {
    return -1L
}

fun main() {
    val lines = loadFile("/day07.txt")

    print(doPartA(lines))
    print("\n")

//    print(doPart2(bigRace))
    print("\n")
}
