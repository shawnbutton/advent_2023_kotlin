package com.shawnbutton.advent2023.day03

import com.shawnbutton.advent2023.loadFile

data class Part(val value: Int, val start: Int, val end: Int)

fun main() {
    val lines = loadFile("/day03.txt")

    print(com.shawnbutton.advent2023.day02.doPart1(lines))
    print("\n")
    print(com.shawnbutton.advent2023.day02.doPart2(lines))
}

fun getPositionsOfSymbolsInString(line: String): List<Int> {
    if (line.isEmpty()) {
        return listOf()
    }
    return line.toCharArray().map { it ->
        it != '.' && !it.isDigit()
    }.withIndex().filter { it.value }.map { it.index }
}

fun getPositionsOfPartsInString(line: String): List<Part> {

    val parts = mutableListOf<Part>()
    val prevChar: Char = '.'
    var currentNumber = ""
    line.toCharArray()
        .map { if (it.isDigit()) it else '.' }
        .withIndex()
        .forEach { it ->
            val part = when {
                it.value.isDigit() -> {
                    currentNumber += it.value
                    null
                }

                it.value == '.' && !currentNumber.isEmpty() -> {
                    Part(currentNumber.toInt(), it.index - currentNumber.length, it.index - 1)
                }

                else -> null
            }
            if (part != null) {
                parts.add(part)
                currentNumber = ""
            }
        }
    if (!currentNumber.isEmpty()) {
        parts.add(Part(currentNumber.toInt(), line.length - currentNumber.length, line.length - 1))
    }

    print(parts)
    return parts
}


fun doPart1(lines: List<String>): Int {
    return -1
}

fun doPart2(lines: List<String>): Int {
    return -1
}

