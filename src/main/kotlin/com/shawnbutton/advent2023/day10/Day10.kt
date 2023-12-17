package com.shawnbutton.advent2023.day10

import com.shawnbutton.advent2023.loadFile

fun parseLine(line: String): Array<Char> {
    return line.toCharArray().toTypedArray()
}

fun createGrid(lines: List<String>): Array<Array<Char>> {
    return lines.map { parseLine(it) }.toTypedArray()
}

fun doPartA(lines: List<String>): Int {
    return -1
}

fun doPartB(lines: List<String>): Int {
    return -1
}

fun main() {
    val lines = loadFile("/day10.txt")

    print(doPartA(lines))
    print("\n")

    print(doPartB(lines))
    print("\n")
}
