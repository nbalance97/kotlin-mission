package com.ladder.domain


class LadderBoard(
    val height: Int,
    val personCount: Int,
) {
    private val board: MutableMap<Pos, String> = mutableMapOf()

    fun pushLine(pos: Pos) {
        require(pos.row in 1..height && pos.col in 1..personCount) {
            "사다리의 행은 입력된 사다리 높이 이내여야 하며, 사다리의 열은 사람 수 이내여야 합니다."
        }

        // 왼쪽 - 오른쪽에 연결되어있는지 체크하고, 연결되어있지 않은 경우 + 현재 포지션에 저장되어있지 않는 경우에만 push
        if (pos.left() !in board.keys && pos.right() !in board.keys && pos !in board.keys) {
            board[pos] = LINE
        }
    }
}
