package com.shawnbutton.advent2023.day08

import com.shawnbutton.advent2023.loadFile

fun getIntructions(lines: List<String>): String {
    return lines[0]
}


fun getDirections(lines: List<String>): Map<String, Pair<String, String>> {
    return lines.slice(2..lines.size - 1).map {
        val key = it.substringBefore(" = ")
        val (left, right) = it.substringAfter(" = (").substringBefore(")").split(", ")
        key to Pair(left, right)
    }.toMap()
}



fun doPartA(lines: List<String>): Int {
    return -1
}


fun doPartB(lines: List<String>): Long {
    return -1

}

fun main() {
    val lines = loadFile("/day08.txt")

    print(doPartA(lines))
    print("\n")

    print(doPartB(lines))
    print("\n")
}
