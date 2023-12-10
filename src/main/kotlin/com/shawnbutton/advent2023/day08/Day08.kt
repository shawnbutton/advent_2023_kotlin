package com.shawnbutton.advent2023.day08

import com.shawnbutton.advent2023.loadFile

class Node(val name: String, val isZ: Boolean, var left: Node?, var right: Node?) {
    override fun toString(): String {
        return "Node(name='$name', isZ=$isZ)"
    }
}

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

private fun lowestCommonMultiple(a: Long, b: Long): Long {
    var ma = a
    var mb = b
    var remainder: Long

    while (mb != 0L) {
        remainder = ma % mb
        ma = mb
        mb = remainder
    }

    return a * b / ma
}

val getStepsUntilZ: (List<Boolean>) -> (Node) -> Long = { instructions ->
    { node ->
        var count = 0L
        var directionOn = 0

        var nodeOn = node
        while (!nodeOn.isZ) {
            val left = instructions[directionOn]

            nodeOn = if (left) {
                nodeOn.left!!
            } else {
                nodeOn.right!!
            }
            directionOn = (directionOn + 1) % instructions.size
            count += 1
        }
        count
    }
}

fun doPartB(lines: List<String>): Long {
    val instructions = getIntructionsB(lines)
    val graph = getGraphB(lines)

    val getSteps = getStepsUntilZ(instructions)

    return graph
        .filter { it.name.endsWith("A") }
        .map(getSteps)
        .reduce { acc, i -> lowestCommonMultiple(acc, i) }
}

fun main() {
    val lines = loadFile("/day08.txt")

    print(doPartA(lines))
    print("\n")

    print(doPartB(lines))
    print("\n")
}
