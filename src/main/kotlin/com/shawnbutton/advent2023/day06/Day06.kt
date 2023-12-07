package com.shawnbutton.advent2023.day06

fun Int?.isGreaterThan(other: Int?) =
    this != null && other != null && this > other

data class Race(val length: Int, val theRecord: Int)

fun waysToWin(race: Race): Int {
    return (0..race.length)
        .map { secondOn ->
            val secondsLeft = race.length - secondOn
            secondsLeft * secondOn
        }
        .filter { it -> it.isGreaterThan(race.theRecord) }
        .count()
}

fun doPart1(races: List<Race>): Int {
    return races.map(::waysToWin)
        .reduce { acc, next -> acc * next }
}

fun doPart2(races: List<Race>): Int {
    return -1
}


fun main() {

    val races = listOf(
        Race(51, 222),
        Race(92, 2031),
        Race(68, 1126),
        Race(90, 1225)
    )

    print(doPart1(races))
    print("\n")
//    print(doPart2(lines))
//    print("\n")
}
