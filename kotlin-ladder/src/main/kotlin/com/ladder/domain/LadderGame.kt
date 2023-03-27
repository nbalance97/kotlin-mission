package com.ladder.domain

import kotlin.random.Random

private const val RANDOM_LINE_COUNT = 10

class LadderGame(
    playerNames: List<String>,
    private val gameResults: List<String>,
    ladderHeight: Int
) {
    private val ladderBoard: LadderBoard
    val players: List<Player>

    fun getLines(): Set<Line> = ladderBoard.lines

    fun getResult(playerName: String): Int =
        players.firstOrNull { it.name.equals(playerName, ignoreCase = true) }
            ?.let {
                ladderBoard.getLadderResult(it.column).col
            } ?: throw IllegalArgumentException("존재하지 않는 플레이어입니다.")


    init {
        require(playerNames.size == gameResults.size) { "플레이어 수와 게임 결과 수는 일치해야 합니다." }

        players = playerNames.mapIndexed { index, name -> Player(name, index) }
        ladderBoard = LadderBoard(height = ladderHeight, playerCount = playerNames.size)

        for (i in 1..RANDOM_LINE_COUNT) {
            val one = Position(
                row = Random.nextInt(players.size),
                col = Random.nextInt(ladderHeight)
            )
            val another = if (one.col == ladderHeight - 1) one.left() else one.right()

            ladderBoard.pushLine(Line(one, another))
        }
    }
}
