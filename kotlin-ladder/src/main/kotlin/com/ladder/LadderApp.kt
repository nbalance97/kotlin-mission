package com.ladder

import com.ladder.domain.Command
import com.ladder.domain.LadderGame
import com.ladder.view.InputView
import com.ladder.view.OutputView

class LadderApp {

    fun play() {
        val playerNames = InputView.getPlayerNames()
        val gameResults = InputView.getLadderResult()
        val ladderHeight = InputView.getLadderHeight()
        val ladderGame = LadderGame(playerNames, gameResults, ladderHeight)

        OutputView.printPlayerNames(playerNames)
        OutputView.printBoard(ladderGame.getLines(), ladderGame.players.size, ladderHeight)
        OutputView.printResults(gameResults)

        while (true) {
            when (val command = InputView.getCommand().uppercase()) {
                Command.ALL.value -> printAllResult(ladderGame, gameResults, playerNames)
                Command.FINISH.value -> break
                else -> printResult(ladderGame, gameResults, command)
            }
        }
    }

    private fun printResult(ladderGame: LadderGame, gameResults: List<String>, playerName: String) {
        val resultCol = ladderGame.getResult(playerName)

        OutputView.printResult(playerName, gameResults[resultCol])
    }

    private fun printAllResult(ladderGame: LadderGame, gameResults: List<String>, playerNames: List<String>) {
        playerNames.zip(playerNames.map { ladderGame.getResult(it) })
            .forEach { (playerName, resultCol) -> OutputView.printResult(playerName, gameResults[resultCol]) }

    }
}
