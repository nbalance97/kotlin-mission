package com.ladder.domain

class Player(
    val name: String,
    val column: Int,
) {

    init {
        require(name.length in 1..5) {
            "이름은 1자 이상 5자 이하여야 합니다."
        }

        require(name !in Command) {
            "이름으로 명령어(all, finish)가 들어올 수 없습니다."
        }
    }
}
