package com.shawnbutton.advent2023.day02

import com.shawnbutton.advent2023.loadFile

data class Draw(
    val blue: Int,
    val red: Int,
    val green: Int
) {
    fun withMaxColours (other: Draw): Draw {
        return Draw(
            blue = maxOf(this.blue, other.blue),
            red = maxOf(this.red, other.red),
            green = maxOf(this.green, other.green)
        )
    }

    fun calcPower(): Int {
        return blue * red * green
    }
}

data class Game(
    val number: Int,
    val draws: List<Draw>
)

fun parseGame(line: String): Game {
    val gameNumber = line.substringAfter("Game ").substringBefore(":").toInt()
    val draws = line.substringAfter(": ").split("; ").map { parseDraw(it) }
    return Game(gameNumber, draws)
}

fun parseDraw(drawString: String): Draw {
    var blue = 0
    var red = 0
    var green = 0

    drawString.split(", ").map {
        val count = it.substringBefore(" ").toInt()
        val color = it.substringAfter(" ")
        when (color) {
            "blue" -> blue = count
            "red" -> red = count
            "green" -> green = count
            else -> {}
        }
    }
    return Draw(blue, red, green)
}

fun isPossible(game: Game): Boolean {
    return !game.draws.any {
        it.blue > 14 || it.red > 12 || it.green > 13
    }
}

fun calculateMinimumCubes(game: Game): Draw {
    return game.draws.reduce(Draw::withMaxColours)
}

fun main() {
    val lines = loadFile("/day02.txt")

    print(doPart1(lines))
    print("\n")
    print(doPart2(lines))
}

fun doPart1(lines: List<String>): Int {
    return lines
        .map { parseGame(it) }
        .filter { isPossible(it) }
        .sumOf(Game::number)
}

fun doPart2(lines: List<String>): Int {
    return lines
        .map { parseGame(it) }
        .map { calculateMinimumCubes(it) }
        .sumOf(Draw::calcPower)
}

