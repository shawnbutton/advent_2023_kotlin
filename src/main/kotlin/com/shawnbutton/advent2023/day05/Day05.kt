package com.shawnbutton.advent2023.day05

import com.shawnbutton.advent2023.loadFile

data class RangeMap(val sourceFrom: Int, val sourceTo: Int, val destinationOffset: Int)

fun getSeeds(lines: List<String>): List<Int> {
    val seedLine = lines.find { it.startsWith("seeds: ") };
    return seedLine!!
        .split(": ")
        .get(1)
        .trim()
        .split(" ")
        .map { it.toInt() }
}

fun makeRange(line: String): RangeMap {
    val segments = line.split(" ").map { it.toInt() }

    return RangeMap(segments[1], segments[2], segments[0])
}

fun transform(range: RangeMap, seed: Int): Int {
    return seed - range.destinationOffset
}

fun doPart1(lines: List<String>): Int {
    return -1
}

fun doPart2(lines: List<String>): Int {
    return -1
}


fun main() {
    val lines = loadFile("/day04.txt")

    print(doPart1(lines))
    print("\n")
    print(doPart2(lines))
}
