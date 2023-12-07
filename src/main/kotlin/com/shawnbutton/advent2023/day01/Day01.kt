package com.shawnbutton.advent2023.day01

import com.shawnbutton.advent2023.loadFile

fun Int?.isLessThan(other: Int?) =
    this != null && other != null && this < other

fun calcDigits(line: String): Int {
    val first = line.first { it.isDigit() }
    val last = line.last { it.isDigit() }

    return "${first}${last}".toInt()
}

fun sumAll(lines: List<String>): Int {
    return lines
        .map(::calcDigits)
        .sum()
}
fun calcDigitsWithWords (line: String): Int {
    val numberWords = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val numberDigits = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")

    val tokens = numberWords + numberDigits

    val tokenHits = tokens.map { getPositionsOfTokenInString(line, it) }

    return firstDigit(tokenHits)!!.times(10).plus(secondDigit(tokenHits)!!)
}

private fun secondDigit(tokenHits: List<List<Int>>): Int? {
    val lastToken = lastToken(tokenHits)
    val lastDigit = if (lastToken.isLessThan(9)) {
        lastToken?.plus(1)
    } else {
        lastToken?.minus(8)
    }
    return lastDigit
}

private fun firstDigit(tokenHits: List<List<Int>>): Int? {
    val firstToken = firstToken(tokenHits)
    val firstDigit = if (firstToken.isLessThan(9)) {
        firstToken?.plus(1)
    } else {
        firstToken?.minus(8)
    }
    return firstDigit
}

fun getPositionsOfTokenInString(line: String, token: String): List<Int> {
    return Regex(token).findAll(line).map { it.range.start }.toList()
}

fun firstToken(tokenHits: List<List<Int>>): Int? {
    return tokenHits.withIndex().minByOrNull { (_, innerList) ->
        innerList.firstOrNull() ?: 999
    }?.index
}

fun lastToken(tokenHits: List<List<Int>>): Int? {
    return tokenHits.withIndex().maxByOrNull { (_, innerList) ->
        innerList.lastOrNull() ?: -999
    }?.index
}

fun sumAllWithWords(lines: List<String>): Int {
    return lines
        .map(::calcDigitsWithWords)
        .sum()
}

fun main() {
    val lines = loadFile("/day01.txt")

    print(sumAll(lines))
    print("\n")
    print(sumAllWithWords(lines))
}

