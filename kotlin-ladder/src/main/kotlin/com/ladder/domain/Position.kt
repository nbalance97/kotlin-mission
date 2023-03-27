package com.ladder.domain

data class Position(
    val row: Int,
    val col: Int,
) {

    fun left() = Position(row, col-1)

    fun right() = Position(row, col+1)
}
