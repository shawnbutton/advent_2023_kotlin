package com.shawnbutton.advent2023

data class Draw(
    val blue: Int,
    val red: Int,
    val green: Int,
)

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
    val totalBlue = game.draws.sumOf { it.blue }
    val totalRed = game.draws.sumOf { it.red }
    val totalGreen = game.draws.sumOf { it.green }
    return totalBlue <= 14 && totalRed <= 12 && totalGreen <= 13
}

fun main() {
    val lines = loadFile("/day01.txt")

    print(doPart1(lines))
    print("\n")
//    print(sumAllWithWords(lines))
}

fun doPart1(lines: List<String>): Int {
    TODO("Not yet implemented")
}

