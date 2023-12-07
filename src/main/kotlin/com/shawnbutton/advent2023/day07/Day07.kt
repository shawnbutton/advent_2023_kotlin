package com.shawnbutton.advent2023.day07

import com.shawnbutton.advent2023.day06.Race

fun parseHand(line: String): List<String> {
    return line.substringBefore(" ").toList().map { it.toString() }
}

fun doPartA(races: List<Race>): Long {
    return -1L
}

fun doPartB(race: Race): Long {
    return -1L
}

fun main() {
//    print(doPart1(races))
    print("\n")

//    print(doPart2(bigRace))
    print("\n")
}
