package com.example.shubham.tictactoe

import kotlin.math.max
import kotlin.math.min


/**
 * Created by shubham on 15/12/17.
 */

class BotPlayer() {

    fun minimax(board: Board, depth: Int,  isXTurn: Boolean): Int {
        val score = board.getBoardScore()

        if (score == 10) {
            return (10 - depth)
        }

        if (score == -10) {
            return (-10 + depth)
        }

        if (!board.hasEmptyPositions()) {
            return 0
        }

        if (isXTurn) {
            var best = -1000

            for (i in 0 .. 2) {
                for (j in 0 .. 2) {
                    if (board.valAtPosition(i, j) == 0) {
                        board.setAtPosition(i * 3 + j, isXTurn)
                        best = max(best, minimax(board, depth + 1, !isXTurn))
                        board.clearAtPosition(i * 3 + j)
                    }
                }
            }

            return best

        } else {
            var best = 1000

            for (i in 0 .. 2) {
                for (j in 0 .. 2) {
                    if (board.valAtPosition(i, j) == 0) {
                        board.setAtPosition(i * 3 + j, isXTurn)
                        best = min(best, minimax(board, depth + 1, !isXTurn))
                        board.clearAtPosition(i * 3 + j)
                    }
                }
            }

            return best
        }
    }

    fun getBestMove(board: Board, isXTurn: Boolean): Int {
        if (isXTurn) {
            // computer is playing as X, maximize the score
            var bestMove = -1
            var bestScore = -1000

            for (i in 0 .. 2) {
                for (j in 0 .. 2) {
                    if (board.valAtPosition(i, j) == 0) {
                        board.setAtPosition(i * 3 + j, isXTurn)
                        val moveScore =  minimax(board, 0, !isXTurn)
                        board.clearAtPosition(i * 3 + j)

                        if (moveScore > bestScore) {
                            bestScore = moveScore
                            bestMove = i * 3 + j
                        }
                    }
                }
            }
            return bestMove
        } else {
            // computer is playing as O, minimize the score
            var bestMove = -1
            var bestScore = 1000

            for (i in 0 .. 2) {
                for (j in 0 .. 2) {
                    if (board.valAtPosition(i, j) == 0) {
                        board.setAtPosition(i * 3 + j, isXTurn)
                        val moveScore =  minimax(board, 0, !isXTurn)
                        board.clearAtPosition(i * 3 + j)

                        if (moveScore < bestScore) {
                            bestScore = moveScore
                            bestMove = i * 3 + j
                        }
                    }
                }
            }
            return bestMove
        }
    }
}