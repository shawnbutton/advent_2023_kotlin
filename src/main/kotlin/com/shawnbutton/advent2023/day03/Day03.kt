package com.shawnbutton.advent2023.day03

import com.shawnbutton.advent2023.loadFile

data class Part(val value: Int, val start: Int, val end: Int)

fun main() {
    val lines = loadFile("/day03.txt")

    print(doPart1(lines))
    print("\n")
    print(doPart2(lines))
}

fun positionsOfSymbols(line: String): List<Int> {
    return line.toCharArray().map { it ->
        it != '.' && !it.isDigit()
    }.withIndex().filter { it.value }.map { it.index }
}

fun positionsOfParts(line: String): List<Part> {

    val parts = mutableListOf<Part>()
    val prevChar: Char = '.'
    var currentNumber = ""
    line.toCharArray()
        .map { if (it.isDigit()) it else '.' }
        .withIndex()
        .forEach { it ->
            val part = when {
                it.value.isDigit() -> {
                    currentNumber += it.value
                    null
                }

                it.value == '.' && !currentNumber.isEmpty() -> {
                    Part(currentNumber.toInt(), it.index - currentNumber.length, it.index - 1)
                }

                else -> null
            }
            if (part != null) {
                parts.add(part)
                currentNumber = ""
            }
        }
    if (!currentNumber.isEmpty()) {
        parts.add(Part(currentNumber.toInt(), line.length - currentNumber.length, line.length - 1))
    }

    return parts
}

fun isSymbolForPart(part: Part, symbols: List<Int>): Boolean {
    return symbols.any { it >= part.start - 1 && it <= part.end + 1 }
}

fun isPartForGear(gear: Int, parts: List<Part>): List<Part> {
    return parts.filter { gear >= it.start - 1 && gear <= it.end + 1 }
}

fun doPart1(lines: List<String>): Int {
    val symbolsLines = lines.map { positionsOfSymbols(it) }
    val partsLines = lines.map { positionsOfParts(it) }

    val validParts = mutableListOf<Part>()

    partsLines.forEachIndexed { lineOn, parts ->
        parts.forEach { part ->
            var found = false;
            // previous line
            if (lineOn > 0) {
                if (isSymbolForPart(part, symbolsLines[lineOn - 1])) {
                    found = true
                }
            }
            // current line
            if (isSymbolForPart(part, symbolsLines[lineOn])) {
                found = true
            }
            // next line
            if (lineOn < partsLines.size - 1) {
                if (isSymbolForPart(part, symbolsLines[lineOn + 1])) {
                    found = true
                }
            }

            if (found) validParts.add(part)
        }

    }

    return validParts.sumOf { it.value }

}

fun positionsOfGears(line: String): List<Int> {
    if (line.isEmpty()) {
        return listOf()
    }
    return line.toCharArray().map { it ->
        it == '*'
    }.withIndex().filter { it.value }.map { it.index }
}

fun doPart2(lines: List<String>): Int {
    val gearLines = lines.map { positionsOfGears(it) }
    val partsLines = lines.map { positionsOfParts(it) }

    var totalGearValues = 0

    gearLines.forEachIndexed { lineOn, gears ->
        gears.forEach { gear ->
            val parts = mutableListOf<Part>()
            // previous line
            if (lineOn > 0) {
                parts.addAll(isPartForGear(gear, partsLines[lineOn - 1]))
            }
            // current line
            parts.addAll(isPartForGear(gear, partsLines[lineOn]))

            // next line
            if (lineOn < partsLines.size - 1) {
                parts.addAll(isPartForGear(gear, partsLines[lineOn + 1]))
            }

            if (parts.size == 2) {
                totalGearValues += parts[0].value * parts[1].value
            }
        }

    }

    return totalGearValues

}

