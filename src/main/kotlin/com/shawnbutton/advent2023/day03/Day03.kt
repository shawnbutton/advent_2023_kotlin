package com.shawnbutton.advent2023.day03

import com.shawnbutton.advent2023.loadFile


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
    val temp = line.toCharArray().map { it ->
        it != '.' && !it.isDigit()
    }.withIndex().filter { it.value }.map { it.index }
    print(temp)
    return temp
}

fun doPart1(lines: List<String>): Int {
    return -1
}

fun doPart2(lines: List<String>): Int {
    return -1
}

