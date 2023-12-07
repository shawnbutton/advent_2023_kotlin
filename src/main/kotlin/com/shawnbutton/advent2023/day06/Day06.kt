package com.shawnbutton.advent2023.day06

fun Long.isGreaterThan(other: Long) = this > other

data class Race(val length: Long, val theRecord: Long)

fun waysToWin(race: Race): Long {
    return (0..race.length)
        .map { secondOn ->
            val secondsLeft = race.length - secondOn
            secondsLeft * secondOn
        }.count { it.isGreaterThan(race.theRecord) }
        .toLong()
}

fun doPart1(races: List<Race>): Long {
    return races.map(::waysToWin)
        .reduce { acc, next -> acc * next }
}

fun doPart2(race: Race): Long {
    return waysToWin(race)
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

    val bigRace = Race(51926890,222203111261225)
    print(doPart2(bigRace))
    print("\n")
}
