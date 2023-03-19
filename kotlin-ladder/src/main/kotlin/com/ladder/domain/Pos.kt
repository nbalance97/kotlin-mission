package com.ladder.domain

data class Pos(
    val row: Int,
    val col: Int
) {
    fun left() = Pos(row, col-1)
    fun right() = Pos(row, col+1)
}
