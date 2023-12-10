package com.shawnbutton.advent2023.day09

import com.shawnbutton.advent2023.loadFile

fun parseHistory(line1: String): List<Int> {
    return line1.split(" ").map { it.toInt() }
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
