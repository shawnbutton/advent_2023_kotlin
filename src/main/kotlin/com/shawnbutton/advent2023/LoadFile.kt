package com.shawnbutton.advent2023

fun loadFile(fileName: String): List<String> {
    val contents = Any::class::class.java.getResource(fileName)!!.readText()
    return contents.split("\n").dropLast(1)
}