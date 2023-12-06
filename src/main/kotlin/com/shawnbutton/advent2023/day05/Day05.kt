package com.shawnbutton.advent2023.day05

import com.shawnbutton.advent2023.loadFile

data class RangeMap(val sourceFrom: Int, val sourceTo: Int, val destinationOffset: Int)

data class ConvertMap(val from: String, val to: String, val rangeMap: MutableList<RangeMap>)

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

    return RangeMap(segments[1], segments[1] + segments[2] - 1, segments[0] - segments[1])
}

fun transformOneRange(range: RangeMap, seed: Int): Int {
    return if (seed >= range.sourceFrom && seed <= range.sourceTo) {
        seed + range.destinationOffset
    } else {
        seed
    }
}

fun transformAll(ranges: List<RangeMap>, seed: Int): Int {
    return ranges.fold(seed) { acc, range ->
        transformOneRange(range, acc)
    }
}

fun parseMaps(lines: List<String>): List<ConvertMap> {
    return lines
        .fold(mutableListOf<ConvertMap>()) { acc, line ->
            if (line.contains(" map:")) {
                val mapElements = line.substringBefore(" map:").split("-to-")
                acc.add(ConvertMap(mapElements[0], mapElements[1], mutableListOf()))
            } else if (line.isEmpty() || line.startsWith("seeds:")) {
                // do nothing
            } else {
                val rangeMap = makeRange(line)
                acc.last().rangeMap.add(rangeMap)
            }
            acc
        }
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
