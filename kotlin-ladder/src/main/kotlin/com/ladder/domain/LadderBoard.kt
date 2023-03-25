package com.ladder.domain


private const val INITIAL_ROW = 0

class LadderBoard(
    private val height: Int,
    private val playerCount: Int,
) {
    val lines: MutableSet<Line> = mutableSetOf()

    fun pushLine(line: Line) {
        require(line.from.row in 0 until height && line.to.row in 0 until height) {
            "사다리의 행은 입력된 사다리 높이 이내여야 합니다."
        }

        require(line.from.col in 0 until playerCount && line.to.col in 0 until playerCount) {
            "사다리의 열은 입력된 사람 수 이내여야 합니다."
        }

        // 왼쪽 - 오른쪽에 연결되어있는지 체크하고, 연결되어있지 않은 경우 + 현재 포지션에 저장되어있지 않는 경우에만 push
        if (line.left() !in this.lines &&
            line.right() !in this.lines &&
            line !in this.lines) {

            this.lines.add(line)
        }
    }

    fun getLadderResult(column: Int): Position {
        var x = INITIAL_ROW
        var y = column
        val visited = mutableSetOf<Position>()

        while (x in 0 until height) {
            val position = Position(x, y)
            visited.add(position)

            lines.firstOrNull {
                (it.from == position && it.to !in visited) || (it.to == position && it.from !in visited)
            }?.let {
                y = if (it.from == position) it.to.col else it.from.col
            } ?: x++
        }

        return Position(x, y)
    }

}
