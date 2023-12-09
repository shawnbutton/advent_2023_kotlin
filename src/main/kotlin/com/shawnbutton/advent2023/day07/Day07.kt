package com.shawnbutton.advent2023.day07

import com.shawnbutton.advent2023.loadFile

data class Hand(val cards: String, val type: HandValue, val bid: Int) : Comparable<Hand> {
    override fun compareTo(other: Hand): Int {
        return compareValuesBy(
            this, other,
            { it.type.ordinal },
            { rankMap[it.cards.substring(0..0)] },
            { rankMap[it.cards.substring(1..1)] },
            { rankMap[it.cards.substring(2..2)] },
            { rankMap[it.cards.substring(3..3)] },
            { rankMap[it.cards.substring(4..4)] },
        )
    }
}
data class HandB(val cards: String, val type: HandValue, val bid: Int) : Comparable<HandB> {
    override fun compareTo(other: HandB): Int {
        return compareValuesBy(
            this, other,
            { it.type.ordinal },
            { rankMap[it.cards.substring(0..0)] },
            { rankMap[it.cards.substring(1..1)] },
            { rankMap[it.cards.substring(2..2)] },
            { rankMap[it.cards.substring(3..3)] },
            { rankMap[it.cards.substring(4..4)] },
        )
    }
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

val rankMapB = mapOf(
    "A" to 14,
    "K" to 13,
    "Q" to 12,
    "T" to 10,
    "9" to 9,
    "8" to 8,
    "7" to 7,
    "6" to 6,
    "5" to 5,
    "4" to 4,
    "3" to 3,
    "2" to 2,
    "J" to 1,
)

fun parseHand(line: String): String {
    return line.substringBefore(" ")
}

fun getHandType(hand: String): HandValue {
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


private fun getCardValue(card: String): Int {
    print("card: $card")
    return rankMap.get(card)!!
}

fun allPossibleHands(cards: String): List<String> {
    val nonJ = cards.filter { it != 'J' }
    val numJs = 5 - nonJ.length
    var newCards: List<String> = mutableListOf(nonJ)

    (1..numJs).forEach {
        newCards = appendAllCards(newCards)
    }
    return newCards
}

fun appendAllCards(hands: List<String>): List<String> {
    val newCards: MutableList<String> = mutableListOf()
    hands.forEach { hand ->
        "AKQT98765432".toList().forEach { c ->
            newCards.add(hand + c.toString())
        }
    }

    return newCards
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


fun doPartB(lines: List<String>): Long {
    val hands = lines.map { parseHand(it) }
    val bids = lines.map { it.substringAfter(" ").toInt() }

    val total = hands.zip(bids)
        .map {
            HandB(it.first, getHandType(it.first), it.second)
        }
        .sorted()
        .withIndex()
        .sumOf {
            (it.index + 1) * it.value.bid
        }

    return -1
}

fun main() {
    val lines = loadFile("/day07.txt")

    print(doPartA(lines))
    print("\n")

//    print(doPart2(bigRace))
    print("\n")
}
