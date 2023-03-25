package com.ladder.view

import com.ladder.domain.Line
import com.ladder.domain.Position

object OutputView {

    fun printPlayerNames(userName: List<String>) {
        userName.forEach {
            print(it.padEnd(6, ' '))
        }

        println()
    }

    fun printResults(results: List<String>) {
        results.forEach {
            print(it.padEnd(6, ' '))
        }

        println()
    }

    fun printBoard(lines: Set<Line>, personCount: Int, ladderHeight: Int) {
        for (i in 0 until ladderHeight) {
            for (j in 0 until personCount) {
                print("|".padEnd(3, ' '))
                if (Line(Position(i, j), Position(i, j).right()) in lines) {
                    print("-".padEnd(3, ' '))
                } else {
                    print("".padEnd(3, ' '))
                }
            }
            println()
        }
    }

    fun printResult(name: String, result: String) {
        println("${name} -> ${result}")
    }
}
