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

fun extendChangeSequencyToRight(values: List<Int>): List<List<Int>> {
    val reversed = extendSequenceTo0(values)

    var addToIt = 0
    val filled = reversed.map {
        addToIt = it.last() + addToIt
        val newList = it.toMutableList().plus(addToIt)
        newList
    }

    return filled.reversed()
}

fun extendSequenceTo0(values: List<Int>): List<List<Int>> {
    var changeSequence = values

    val results = mutableListOf(values)
    while (!changeSequence.all { it == 0 }) {
        changeSequence = getChangeSequence(changeSequence)
        results.add(changeSequence)
    }

    return results.reversed()
}


fun doPartA(lines: List<String>): Int {
    val fullList = lines.map { parseHistory(it) }
        .map { extendChangeSequencyToRight(it) }

    val elememts = fullList
        .map {
            it.first().last()
        }

    return elememts.sumOf { it }
}

fun doPartB(lines: List<String>): Int {
    return -1
}

fun main() {
    val lines = loadFile("/day09.txt")

    print(doPartA(lines))
    print("\n")

    print(doPartB(lines))
    print("\n")
}
