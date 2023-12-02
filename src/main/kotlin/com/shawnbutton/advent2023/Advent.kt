package com.shawnbutton.advent2023

import java.io.File

fun calcDigits(line: String): Int {
    val digits = line
        .toCharArray()
        .filter { it.isDigit() }

    val rightDigits = "" + digits.first() + digits.last()

    return rightDigits.toInt()
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sumAll(lines: List<String>): Int {
    return lines.map(::calcDigits)
        .reduce(::sum)
}

fun loadFle(fileName: String): List<String> {
    val contents = Any::class::class.java.getResource(fileName)!!.readText()
    return contents.split("\n").dropLast(1)
}

fun main() {
    val lines = loadFle("/input.txt")

    print(sumAll(lines))
}

