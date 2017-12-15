package com.example.shubham.tictactoe

import android.util.Log

/**
 * Created by shubham on 14/12/17.
 */

class Board() {

    /**
     * underlying data structure for the tic-tac-toe board (an 2D array of Int)
     * The mapping from Int to state of board is as follows:-
     *
     *      1 - the place is occupied by an 'X'
     *      2 - the place is occupied by an 'O'
     *
     * The board positions are numbered as follows:-
     *      0, 1, 2
     *      3, 4, 5
     *      6, 7, 8
     */
    private var board = arrayOf(intArrayOf(0, 0, 0),
                                intArrayOf(0, 0, 0),
                                intArrayOf(0, 0, 0))

    /**
     * Function to retrieve the elements of board
     *
     * @param row (row number of element)
     * @param col (column number of element)
     *
     * @return board[row][col] (the value at board[row][col])
     */
    fun valAtPosition(row: Int, col: Int): Int {
        return board[row][col]
    }

    /**
     * Checks whether there is any empty space left on the board or not
     *
     * @return true (if any position is empty on the board)
     * @return false (if no position is empty on the board)
     */
    fun hasEmptyPositions(): Boolean {
        for (row in board) {
            for (num in row) {
                if (num == 0) {
                    return true
                }
            }
        }
        return false
    }

    /**
     * Sets the marker of a player at a particular position
     *
     * @param position (the position where the mark has to be made)
     * @param isXTurn (determines whose turn it is, which decides the value of the marker)
     */
    fun setAtPosition(position: Int, isXTurn: Boolean) {
        var marker = 1
        if (!isXTurn) {
            marker = 2
        }
        val rowIndex = position / 3
        val colIndex = position % 3
        board[rowIndex][colIndex] = marker
    }

    /**
     * Clears the marker present at a given position
     *
     * @param position (the position which needs to be cleared)
     */
    fun clearAtPosition(position: Int) {
        val rowIndex = position / 3
        val colIndex = position % 3
        board[rowIndex][colIndex] = 0
    }

    /**
     * Checks and returns the winning player index
     *
     * @return (Int: an integer code representing the winning configuration and the winning player):-
     *      The code is formed as follows:-
     *      0 - if no one has won the game
     *      (winning_config_code * 10 + winner_index) - if some player has won
     *
     *      winning_configuration is the set of those board positions which have the same player
     *      markers, and have made the player win the game
     *
     *      The values and mappings for winning_config_code are:-
     *      1 - first row
     *      2 - second row
     *      3 - third row
     *      4 - first col
     *      5 - second col
     *      6 - third col
     *      7 - main diagonal
     *      8 - other diagonal
     *
     *      The values and mappings for winner_index are:-
     *      1 - the winner is 'X'
     *      2 - the winner is 'O'
     */
    fun getWinner(): Int {

        // Check each row
        for (i in 0 .. 2) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return (i + 1) * 10 + board[i][0]
            }
        }

        // Check first column
        if (board[0][0] != 0 && board[0][0] == board[1][0] && board[0][0] == board[2][0]) {
            return 40 + board[0][0]
        }

        // Check second column
        if (board[0][1] != 0 && board[0][1] == board[1][1] && board[0][1] == board[2][1]) {
            return 50 + board[0][1]
        }

        // Check third column
        if (board[0][2] != 0 && board[0][2] == board[1][2] && board[0][2] == board[2][2]) {
            return 60 + board[0][2]
        }

        // Check main diagonal
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return 70 + board[0][0]
        }

        // Check other diagonal
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return 80 + board[0][2]
        }

        // No player is in the winning position, so return 0 (the index of empty position)
        return 0
    }

    /**
     * Evaluates and returns the score of the board position
     *
     * @return score (the evaluated score of the board setup which is calculated as follows) :-
     *      0 - if there is no winner
     *      10 - if the winner is 'X'
     *      -10 - if the winner is 'O'
     */
    fun getBoardScore(): Int {
        val winner = getWinner()
        var score = 0
        if (winner == 0) {
            score = 0
        } else if (winner % 10 == 1) {
            score = 10
        } else {
            score = -10
        }

        return score
    }


}