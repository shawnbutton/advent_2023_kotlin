package com.shawnbutton.advent2023
fun Int?.isLessThan(other: Int?) =
    this != null && other != null && this < other

val calcDigits = { line: String ->
    val digits = line
        .toCharArray()
        .filter { it.isDigit() }

    val rightDigits = "" + digits.first() + digits.last()

    rightDigits.toInt()
}

fun sumAll(lines: List<String>): Int {
    return lines
        .map(calcDigits)
        .sum()
}
fun calcDigitsWithWords (line: String): Int {
    val numberWords = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val numberDigits = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")

    val tokens = numberWords + numberDigits

    val tokenHits = tokens.map { getPositionsOfTokenInString(line, it) }

    val firstToken = firstToken(tokenHits)
    val firstDigit = if (firstToken.isLessThan(9)) {
        firstToken?.plus(1)
    } else {
        firstToken?.minus(8)
    }

    val lastToken = lastToken(tokenHits)
    val lastDigit = if (lastToken.isLessThan(9)) {
        lastToken?.plus(1)
    } else {
        lastToken?.minus(8)
    }

    return firstDigit!!.times(10).plus(lastDigit!!)
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

fun sumAllWithWords(sampleB: List<String>): Int {

    return 29
}


fun loadFle(fileName: String): List<String> {
    val contents = Any::class::class.java.getResource(fileName)!!.readText()
    return contents.split("\n").dropLast(1)
}

fun main() {
    val lines = loadFle("/input.txt")

    print(sumAll(lines))
}

