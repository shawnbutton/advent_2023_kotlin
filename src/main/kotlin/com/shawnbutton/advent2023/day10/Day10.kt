package com.shawnbutton.advent2023.day10

import com.shawnbutton.advent2023.loadFile

data class Coord(val x: Int, val y: Int) {
    val right: Coord
        get() = Coord(x + 1, y)
    val left: Coord
        get() = Coord(x - 1, y)
    val up: Coord
        get() = Coord(x, y - 1)
    val down: Coord
        get() = Coord(x, y + 1)
}

fun connections(start: Coord, c: Char): Pair<Coord, Coord> {
    return when (c) {
        '|' -> Pair(start.up, start.down)
        '-' -> Pair(start.left, start.right)
        'L' -> Pair(start.down.right, start.left.up)
        'J' -> Pair(start.down.left, start.right.up)
//        '+' -> return Pair(start.up, start.down)
        else -> Pair(start, start)
    }
}

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
