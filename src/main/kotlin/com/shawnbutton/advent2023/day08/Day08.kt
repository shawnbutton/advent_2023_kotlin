package com.shawnbutton.advent2023.day08

import com.shawnbutton.advent2023.loadFile

fun getIntructions(lines: List<String>): String {
    return lines[0]
}

fun getGraph(lines: List<String>): Map<String, Pair<String, String>> {
    return lines.slice(2..lines.size - 1).map {
        val key = it.substringBefore(" = ")
        val (left, right) = it.substringAfter(" = (").substringBefore(")").split(", ")
        key to Pair(left, right)
    }.toMap()
}

fun doPartA(lines: List<String>): Int {
    val instructions = getIntructions(lines)
    val graph = getGraph(lines)

    var nodeOn = "AAA"
    var directionOn = 0
    var count = 0

    while (nodeOn != "ZZZ") {
        nodeOn = if (instructions[directionOn] == 'L') {
            graph.get(nodeOn)!!.first
        } else {
            graph.get(nodeOn)!!.second
        }
        directionOn = (directionOn + 1) % instructions.length
        count += 1
    }

    return count
}


fun doPartB(lines: List<String>): Int {
    val instructions = getIntructions(lines)
    print(instructions + "\n")
    val graph = getGraph(lines)

    var nodesOn = graph.keys.filter { it.endsWith("A") }

    var directionOn = 0
    var count = 0

    while (!nodesOn.all { it.endsWith("Z") }) {
        val left = instructions[directionOn] == 'L'
        nodesOn = nodesOn.map {
            if (left) {
                graph.get(it)!!.first
            } else {
                graph.get(it)!!.second
            }
        }

//        print(nodesOn.map { it.last().toString() }.toString())

        directionOn = (directionOn + 1) % instructions.length
        count += 1
//        print("" + count + ": " + nodesOn.first() + " " + nodesOn[1] + " " + nodesOn.last() + "\n")

        val totalZ = nodesOn.count { it.endsWith("Z") }
        if (totalZ > 5) {
            print("" + count + ": " + totalZ + "\n")
        }

        if ((count % 10000000).equals(0)) print("count:" + count + "\n")
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
