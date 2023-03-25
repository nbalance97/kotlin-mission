package com.ladder.view

private const val SPLIT_DELIMITER = ","

object InputView {

    fun getPlayerNames(): List<String> {
        println("사용자 이름을 입력하세요(,로 구분)")

        return readln()
            .split(SPLIT_DELIMITER)
            .map { it.trim() }
    }

    fun getLadderResult(): List<String> {
        println("사다리 결과를 입력하세요(,로 구분)")

        return readln()
            .split(SPLIT_DELIMITER)
            .map { it.trim() }
    }

    fun getLadderHeight(): Int {
        println("사다리 높이를 입력하세요.")

        return readln().toIntOrNull() ?: throw IllegalArgumentException("정확한 숫자값이 아닙니다")
    }

    fun getCommand(): String {
        println("명령어를 입력하세요(0. 사용자명, 1. all, 2. finish)")

        return readln().trim()
    }
}
