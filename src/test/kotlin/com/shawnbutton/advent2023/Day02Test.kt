package com.shawnbutton.advent2023

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

val game1 = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
val game2 = "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"
val game3 = "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"
val game4 = "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"
val game5 = "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"

val games = listOf(game1, game2, game3, game4, game5)

class Day02Test {

    @Test
    fun shouldParseGame1() {
        val expected = Game(
            number = 1,
            draws = listOf(
                Draw(blue = 3, red = 4, green = 0),
                Draw(blue = 6, red = 1, green = 2),
                Draw(blue = 0, red = 0, green = 2)
            )
        )

        assertEquals(expected, parseGame(game1))
    }

    @Test
    fun shouldParseGame5() {
        val expected = Game(
            number = 5,
            draws = listOf(
                Draw(blue = 1, red = 6, green = 3),
                Draw(blue = 2, red = 1, green = 2)
            )
        )

        assertEquals(expected, parseGame(game5))
    }
}
