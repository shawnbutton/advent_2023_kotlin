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

    val reversed = results.reversed()
    val maxSize = values.size

    var prevAdd = 0

    val filledOut = reversed
        .withIndex()
        .map { (index, sequence) ->
            val newList = sequence.toMutableList()

            (newList.size..maxSize)
                .forEach {
                    val nextElement = if (index == 0) {
                        0
                    } else {
//                        FAIL // somehow add the last member of the previous list

                        prevAdd + newList.last()
                    }
                    newList.add(nextElement)
                }
            prevAdd = newList.get(newList.size - 2)
            newList
        }
        .reversed()

    return filledOut

}


fun doPartA(lines: List<String>): Int {
    val fullList = lines.map { parseHistory(it) }
        .map { getChangeSequencyRecursively(it) }

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
