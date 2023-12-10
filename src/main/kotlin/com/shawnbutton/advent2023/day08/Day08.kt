package com.shawnbutton.advent2023.day08

import com.shawnbutton.advent2023.loadFile
import java.time.LocalDate

data class Node(val name: String, val isZ: Boolean, var left: Node?, var right: Node?)

fun getIntructions(lines: List<String>): String {
    return lines[0]
}

fun getIntructionsB(lines: List<String>): List<Boolean> {
    return lines[0].map { it == 'L' }
}

fun getGraph(lines: List<String>): Map<String, Pair<String, String>> {
    return lines.slice(2..lines.size - 1).map {
        val key = it.substringBefore(" = ")
        val (left, right) = it.substringAfter(" = (").substringBefore(")").split(", ")
        key to Pair(left, right)
    }.toMap()
}

fun getGraphB(lines: List<String>): List<Node> {
    val nodeLines = lines.slice(2..lines.size - 1)
    val nodes = nodeLines.map {
        val name = it.substringBefore(" = ")
        Node(name, name.endsWith("Z"), null, null)
    }

    nodeLines.withIndex().map {
        val (index, line) = it
        val (left, right) = line.substringAfter(" = (").substringBefore(")").split(", ")
        val leftNode = nodes.withIndex().first({ it.value.name == left }).value
        val rightNode = nodes.withIndex().first({ it.value.name == right }).value
        nodes.get(index).left = leftNode
        nodes.get(index).right = rightNode
    }

    return nodes
}

fun doPartA(lines: List<String>): Long {
    val instructions = getIntructions(lines)
    val graph = getGraph(lines)

    var nodeOn = "AAA"
    var directionOn = 0
    var count = 0L

    while (nodeOn != "ZZZ") {
        nodeOn = if (instructions[directionOn] == 'L') {
            graph.get(nodeOn)!!.first
        } else {
            graph.get(nodeOn)!!.second
        }
        directionOn = (directionOn + 1) % instructions.length
        count += 1L
    }

    return count
}


fun doPartB(lines: List<String>): Long {
    val startDateTime: java.util.Date = java.util.Date()

    val instructions = getIntructionsB(lines)
    print(instructions + "\n")
    val graph = getGraphB(lines)

    val nodesOn = graph.filter { it.name.endsWith("A") }.toMutableList()

    var directionOn = 0
    var count = 0L

//    var maxZ = 0

    while (!nodesOn.all { it.isZ }) {
        val left = instructions[directionOn]

        for ((index, node) in nodesOn.withIndex()) {
            nodesOn[index] = if (left) {
                node.left!!
            } else {
                node.right!!
            }
        }
//        print(nodesOn.map { it.last().toString() }.toString())

        directionOn = (directionOn + 1) % instructions.size
        count += 1
//        print("" + count + ": " + nodesOn.first() + " " + nodesOn[1] + " " + nodesOn.last() + "\n")

//        val totalZ = nodesOn.count { it.endsWith("Z") }
//        maxZ = Math.max(maxZ, totalZ)

        if ((count % 1000000000L).equals(0L)) {
            val nowtDateTime: java.util.Date = java.util.Date()

            print("time:" + nowtDateTime.time.minus(startDateTime.time).div(1000) + "\n")
            print("count:" + count + "\n")
            nodesOn.forEach { print(it.name + " ") }
            print("\n")
        }
    }

    return count
}

fun main() {
    val lines = loadFile("/day08.txt")

//    print(doPartA(lines))
//    print("\n")

    print(doPartB(lines))
    print("\n")
}
