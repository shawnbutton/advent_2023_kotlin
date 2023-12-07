package com.shawnbutton.advent2023.day05

import com.shawnbutton.advent2023.loadFile

data class RangeMap(val sourceFrom: Long, val sourceTo: Long, val destinationOffset: Long)

data class ConvertMap(val from: String, val to: String, val rangeMap: MutableList<RangeMap>)

fun getSeeds(lines: List<String>): List<Long> {
    val seedLine = lines.find { it.startsWith("seeds: ") };
    return seedLine!!
        .split(": ")
        .get(1)
        .trim()
        .split(" ")
        .map { it.toLong() }
}

fun getSeedsAsRanges(lines: List<String>): List<Pair<Long, Long>> {
    return getSeeds(lines)
        .chunked(2)
        .map { Pair(it[0], it[0] + it[1]) }
}

fun makeRange(line: String): RangeMap {
    val segments = line.split(" ").map { it.toLong() }
    return RangeMap(segments[1], segments[1] + segments[2] - 1, segments[0] - segments[1])
}

fun transformOneRange(range: RangeMap, seed: Long): Long {
    return if (seed >= range.sourceFrom && seed <= range.sourceTo) {
        seed + range.destinationOffset
    } else {
        seed
    }
}

fun transformAll(ranges: List<RangeMap>, seed: Long): Long {
    return ranges.find { range ->
        seed >= range.sourceFrom && seed <= range.sourceTo
    }?.let { range ->
        seed + range.destinationOffset
    } ?: run {
        seed
    }
}

fun performAllTransforms(convertMaps: List<ConvertMap>, seed: Long): Long {
    return convertMaps.fold(seed) { acc, convertMap ->
        val ranges = convertMap.rangeMap
        transformAll(ranges, acc)
    }
}

fun parseMaps(lines: List<String>): List<ConvertMap> {
    return lines
        .fold(mutableListOf<ConvertMap>()) { acc, line ->
            if (line.contains(" map:")) {
                val mapElements = line.substringBefore(" map:").split("-to-")
                acc.add(ConvertMap(mapElements[0], mapElements[1], mutableListOf()))
            } else if (line.isEmpty() || line.startsWith("seeds:")) {
                // ignore seeds and empty lines
            } else {
                val rangeMap = makeRange(line)
                acc.last().rangeMap.add(rangeMap)
            }
            acc
        }
}

fun doPart1(lines: List<String>): Long {
    val seeds = getSeeds(lines)
    val convertMaps = parseMaps(lines)

    return seeds.map { performAllTransforms(convertMaps, it) }.minOf { it }
}

fun doPart2(lines: List<String>): Long {
    val seedsRanges = getSeedsAsRanges(lines)
    val convertMaps = parseMaps(lines)

    val listOFResults = seedsRanges.minOf { seeds ->
        print(seeds)
        print("\n")
        val minForRange = (seeds.first..seeds.second)
            .minOf { seed ->
                performAllTransforms(convertMaps, seed)
            }
        print(minForRange)
        print("\n")
        minForRange
    }

    return listOFResults
}


fun main() {
    val lines = loadFile("/day05.txt")

    print(doPart1(lines))
    print("\n")
    print(doPart2(lines))
    print("\n")
}
