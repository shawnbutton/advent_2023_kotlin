package com.shawnbutton.advent2023.day09

import com.shawnbutton.advent2023.loadFile

fun parseHistory(line1: String): List<Int> {
    return line1.split(" ").map { it.toInt() }
}

fun getChangeSequence(values: List<Int>): List<Int> {
    val changeSequence = mutableListOf<Int>()
    for (i in 1 until values.size) {
        changeSequence.add(values[i] - values[i - 1])
    }
    return changeSequence
}

fun getChangeSequencyRecursively(values: List<Int>): List<List<Int>> {
    var changeSequence = values

    val results = mutableListOf<List<Int>>(values)
    while (!changeSequence.all { it == 0 }) {
        changeSequence = getChangeSequence(changeSequence)
        results.add(changeSequence)
    }

    return results
}


fun doPartA(lines: List<String>): Int {
    return -1
}

fun doPartB(lines: List<String>): Int {
    return -1
}

fun main() {
    val lines = loadFile("/day08.txt")

    print(doPartA(lines))
    print("\n")

    print(doPartB(lines))
    print("\n")
}
