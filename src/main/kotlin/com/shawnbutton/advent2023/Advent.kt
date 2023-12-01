package com.shawnbutton.advent2023

import kotlin.math.log

class Advent {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun calcDigits(line: String): Int {
        val digits  =  line
            .toCharArray()
            .filter { it.isDigit() }

        val rightDigits = "" + digits.first() + digits.last()

        return rightDigits.toInt()
    }

}
