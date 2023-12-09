package com.shawnbutton.advent2023.day07

import com.shawnbutton.advent2023.loadFile

class Hand(val cards: String, val type: HandValue, val bid: Int) : Comparable<Hand> {
    override fun compareTo(other: Hand): Int {
        return compareValuesBy(
            this, other,
            { it.type.ordinal },
            { rankMapA[it.cards.substring(0..0)] },
            { rankMapA[it.cards.substring(1..1)] },
            { rankMapA[it.cards.substring(2..2)] },
            { rankMapA[it.cards.substring(3..3)] },
            { rankMapA[it.cards.substring(4..4)] },
        )
    }
}

class HandB(val cards: String, val type: HandValue, val bid: Int) : Comparable<HandB> {
    override fun compareTo(other: HandB): Int {
        return compareValuesBy(
            this, other,
            { it.type.ordinal },
            { rankMapB[it.cards.substring(0..0)] },
            { rankMapB[it.cards.substring(1..1)] },
            { rankMapB[it.cards.substring(2..2)] },
            { rankMapB[it.cards.substring(3..3)] },
            { rankMapB[it.cards.substring(4..4)] },
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

val rankMapA = mapOf(
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

val rankMapB = rankMapA.toMutableMap().apply {
    this.remove("J")
    this.put("J", 1)
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
    val (hands, bids) = getInput(lines)

    return hands.zip(bids)
        .map { (cards, bid) -> Hand(cards, getHandType(cards), bid) }
        .sorted()
        .withIndex()
        .sumOf { (it.index + 1) * it.value.bid }
}


fun doPartB(lines: List<String>): Long {
    val (hands, bids) = getInput(lines)

    return hands.zip(bids)
        .map { (cards, bid) -> getBestPossibleHand(cards, bid) }
        .sorted()
        .withIndex()
        .sumOf { (it.index + 1) * it.value.bid }
        .toLong()
}

private fun getBestPossibleHand(cards: String, bid: Int) = allPossibleHands(cards)
    .map { hand ->
        HandB(cards, getHandType(hand), bid)
    }.sorted().last()

private fun getInput(lines: List<String>): Pair<List<String>, List<Int>> {
    val hands = lines.map { it.substringBefore(" ") }
    val bids = lines.map { it.substringAfter(" ").toInt() }
    return Pair(hands, bids)
}

fun main() {
    val lines = loadFile("/day07.txt")

    print(doPartA(lines))
    print("\n")

    print(doPartB(lines))
    print("\n")
}
