package com.example.shubham.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class PlayWithComputerActivity : AppCompatActivity() {

    var isXTurn = true // boolean to determine whether it is X's turn or not
    var isBotsTurn = false // boolean to determine whether it is bot's turn or not
    private var board = Board()  // the tic-tac-toe board on which game has to be played
    private var botPlayer = BotPlayer()  // the bot player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_with_computer)
        val intent = intent
        val firstPlayerIndex = intent.getIntExtra("FIRST_PLAYER", 0)

        isBotsTurn = firstPlayerIndex != 0 // 0 is the index of the human player
        startGameWithBot(isBotsTurn)
    }

    /**
     * Checks whether it is bot's turn and takes necessary actions accordingly
     */
    private fun startGameWithBot(isBotsTurn: Boolean) {
        if (!isBotsTurn) {
            Toast.makeText(this, "Please make your move", Toast.LENGTH_SHORT).show()
        } else {
            val botsMove = botPlayer.getBestMove(board, isXTurn)
            when(botsMove) {
                0 -> findViewById<ImageButton>(R.id.pos_0).performClick()
                1 -> findViewById<ImageButton>(R.id.pos_1).performClick()
                2 -> findViewById<ImageButton>(R.id.pos_2).performClick()
                3 -> findViewById<ImageButton>(R.id.pos_3).performClick()
                4 -> findViewById<ImageButton>(R.id.pos_4).performClick()
                5 -> findViewById<ImageButton>(R.id.pos_5).performClick()
                6 -> findViewById<ImageButton>(R.id.pos_6).performClick()
                7 -> findViewById<ImageButton>(R.id.pos_7).performClick()
                8 -> findViewById<ImageButton>(R.id.pos_8).performClick()
            }
        }
    }

    /**
     * Method called when position 0 Button clicked
     */
    fun pos0ButtonClicked(v: View) {
        val imageButton = findViewById<ImageButton>(R.id.pos_0)
        if (isXTurn) {
            imageButton.setImageResource(R.mipmap.x)
        } else {
            imageButton.setImageResource(R.mipmap.o)
        }
        board.setAtPosition(0, isXTurn)
        imageButton.isClickable = false
        monitorGame()
    }

    /**
     * Method called when position 1 Button clicked
     */
    fun pos1ButtonClicked(v: View) {
        val imageButton = findViewById<ImageButton>(R.id.pos_1)
        if (isXTurn) {
            imageButton.setImageResource(R.mipmap.x)
        } else {
            imageButton.setImageResource(R.mipmap.o)
        }
        board.setAtPosition(1, isXTurn)
        imageButton.isClickable = false
        monitorGame()
    }

    /**
     * Method called when position 2 Button clicked
     */
    fun pos2ButtonClicked(v: View) {
        val imageButton = findViewById<ImageButton>(R.id.pos_2)
        if (isXTurn) {
            imageButton.setImageResource(R.mipmap.x)
        } else {
            imageButton.setImageResource(R.mipmap.o)
        }
        board.setAtPosition(2, isXTurn)
        imageButton.isClickable = false
        monitorGame()
    }

    /**
     * Method called when position 3 Button clicked
     */
    fun pos3ButtonClicked(v: View) {
        val imageButton = findViewById<ImageButton>(R.id.pos_3)
        if (isXTurn) {
            imageButton.setImageResource(R.mipmap.x)
        } else {
            imageButton.setImageResource(R.mipmap.o)
        }
        board.setAtPosition(3, isXTurn)
        imageButton.isClickable = false
        monitorGame()
    }

    /**
     * Method called when position 4 Button clicked
     */
    fun pos4ButtonClicked(v: View) {
        val imageButton = findViewById<ImageButton>(R.id.pos_4)
        if (isXTurn) {
            imageButton.setImageResource(R.mipmap.x)
        } else {
            imageButton.setImageResource(R.mipmap.o)
        }
        board.setAtPosition(4, isXTurn)
        imageButton.isClickable = false
        monitorGame()
    }

    /**
     * Method called when position 5 Button clicked
     */
    fun pos5ButtonClicked(v: View) {
        val imageButton = findViewById<ImageButton>(R.id.pos_5)
        if (isXTurn) {
            imageButton.setImageResource(R.mipmap.x)
        } else {
            imageButton.setImageResource(R.mipmap.o)
        }
        board.setAtPosition(5, isXTurn)
        imageButton.isClickable = false
        monitorGame()
    }

    /**
     * Method called when position 6 Button clicked
     */
    fun pos6ButtonClicked(v: View) {
        val imageButton = findViewById<ImageButton>(R.id.pos_6)
        if (isXTurn) {
            imageButton.setImageResource(R.mipmap.x)
        } else {
            imageButton.setImageResource(R.mipmap.o)
        }
        board.setAtPosition(6, isXTurn)
        imageButton.isClickable = false
        monitorGame()
    }

    /**
     * Method called when position 7 Button clicked
     */
    fun pos7ButtonClicked(v: View) {
        val imageButton = findViewById<ImageButton>(R.id.pos_7)
        if (isXTurn) {
            imageButton.setImageResource(R.mipmap.x)
        } else {
            imageButton.setImageResource(R.mipmap.o)
        }
        board.setAtPosition(7, isXTurn)
        imageButton.isClickable = false
        monitorGame()
    }

    /**
     * Method called when position 8 Button clicked
     */
    fun pos8ButtonClicked(v: View) {
        val imageButton = findViewById<ImageButton>(R.id.pos_8)
        if (isXTurn) {
            imageButton.setImageResource(R.mipmap.x)
        } else {
            imageButton.setImageResource(R.mipmap.o)
        }
        board.setAtPosition(8, isXTurn)
        imageButton.isClickable = false
        monitorGame()
    }

    /**
     * This method changes the indicator telling whose turn it is
     */
    private fun changeTurnStatus() {
        isXTurn = !isXTurn
        isBotsTurn = !isBotsTurn
        val imageView = findViewById<ImageView>(R.id.turn_indicator)
        if(isXTurn) {
            imageView.setImageResource(R.mipmap.x)
        } else {
            imageView.setImageResource(R.mipmap.o)
        }
    }

    /**
     * Monitors game progress and returns the status of the game
     *
     * @return status (Int: an integer code representing the winning configuration and the winning player):-
     *      The code is formed as follows:-
     *      0 - if no one has won the game
     *      3 - if the game is over and no one won the game
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
    private fun getGameStatus(): Int {
        val status = board.getWinner()

        // When the game has ended, but no one has won
        if (!board.hasEmptyPositions() && (status % 10) != 1 && (status % 10) != 2) {

            // return code for a draw game
            return 3
        }
        return status
    }

    private fun onGameOver(status: Int) {
        when(status) {
            3 -> {
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Game Draw"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.visibility=View.INVISIBLE
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
            }
            11 -> {
                var imageButton = findViewById<ImageButton>(R.id.pos_0)
                imageButton.setImageResource(R.mipmap.x_won)
                imageButton = findViewById(R.id.pos_1)
                imageButton.setImageResource(R.mipmap.x_won)
                imageButton = findViewById(R.id.pos_2)
                imageButton.setImageResource(R.mipmap.x_won)
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Won"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.setImageResource(R.mipmap.x_won)
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
                makeAllButtonsNonClickable()
            }
            12 -> {
                var imageButton = findViewById<ImageButton>(R.id.pos_0)
                imageButton.setImageResource(R.mipmap.o_won)
                imageButton = findViewById(R.id.pos_1)
                imageButton.setImageResource(R.mipmap.o_won)
                imageButton = findViewById(R.id.pos_2)
                imageButton.setImageResource(R.mipmap.o_won)
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Won"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.setImageResource(R.mipmap.o_won)
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
                makeAllButtonsNonClickable()
            }
            21 -> {
                var imageButton = findViewById<ImageButton>(R.id.pos_3)
                imageButton.setImageResource(R.mipmap.x_won)
                imageButton = findViewById(R.id.pos_4)
                imageButton.setImageResource(R.mipmap.x_won)
                imageButton = findViewById(R.id.pos_5)
                imageButton.setImageResource(R.mipmap.x_won)
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Won"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.setImageResource(R.mipmap.x_won)
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
                makeAllButtonsNonClickable()
            }
            22 -> {
                var imageButton = findViewById<ImageButton>(R.id.pos_3)
                imageButton.setImageResource(R.mipmap.o_won)
                imageButton = findViewById(R.id.pos_4)
                imageButton.setImageResource(R.mipmap.o_won)
                imageButton = findViewById(R.id.pos_5)
                imageButton.setImageResource(R.mipmap.o_won)
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Won"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.setImageResource(R.mipmap.o_won)
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
                makeAllButtonsNonClickable()
            }
            31 -> {
                var imageButton = findViewById<ImageButton>(R.id.pos_6)
                imageButton.setImageResource(R.mipmap.x_won)
                imageButton = findViewById(R.id.pos_7)
                imageButton.setImageResource(R.mipmap.x_won)
                imageButton = findViewById(R.id.pos_8)
                imageButton.setImageResource(R.mipmap.x_won)
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Won"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.setImageResource(R.mipmap.x_won)
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
                makeAllButtonsNonClickable()
            }
            32 -> {
                var imageButton = findViewById<ImageButton>(R.id.pos_6)
                imageButton.setImageResource(R.mipmap.o_won)
                imageButton = findViewById(R.id.pos_7)
                imageButton.setImageResource(R.mipmap.o_won)
                imageButton = findViewById(R.id.pos_8)
                imageButton.setImageResource(R.mipmap.o_won)
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Won"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.setImageResource(R.mipmap.o_won)
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
                makeAllButtonsNonClickable()
            }
            41 -> {
                var imageButton = findViewById<ImageButton>(R.id.pos_0)
                imageButton.setImageResource(R.mipmap.x_won)
                imageButton = findViewById(R.id.pos_3)
                imageButton.setImageResource(R.mipmap.x_won)
                imageButton = findViewById(R.id.pos_6)
                imageButton.setImageResource(R.mipmap.x_won)
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Won"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.setImageResource(R.mipmap.x_won)
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
                makeAllButtonsNonClickable()
            }
            42 -> {
                var imageButton = findViewById<ImageButton>(R.id.pos_0)
                imageButton.setImageResource(R.mipmap.o_won)
                imageButton = findViewById(R.id.pos_3)
                imageButton.setImageResource(R.mipmap.o_won)
                imageButton = findViewById(R.id.pos_6)
                imageButton.setImageResource(R.mipmap.o_won)
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Won"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.setImageResource(R.mipmap.o_won)
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
                makeAllButtonsNonClickable()
            }
            51 -> {
                var imageButton = findViewById<ImageButton>(R.id.pos_1)
                imageButton.setImageResource(R.mipmap.x_won)
                imageButton = findViewById(R.id.pos_4)
                imageButton.setImageResource(R.mipmap.x_won)
                imageButton = findViewById(R.id.pos_7)
                imageButton.setImageResource(R.mipmap.x_won)
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Won"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.setImageResource(R.mipmap.x_won)
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
                makeAllButtonsNonClickable()
            }
            52 -> {
                var imageButton = findViewById<ImageButton>(R.id.pos_1)
                imageButton.setImageResource(R.mipmap.o_won)
                imageButton = findViewById(R.id.pos_4)
                imageButton.setImageResource(R.mipmap.o_won)
                imageButton = findViewById(R.id.pos_7)
                imageButton.setImageResource(R.mipmap.o_won)
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Won"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.setImageResource(R.mipmap.o_won)
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
                makeAllButtonsNonClickable()
            }
            61 -> {
                var imageButton = findViewById<ImageButton>(R.id.pos_2)
                imageButton.setImageResource(R.mipmap.x_won)
                imageButton = findViewById(R.id.pos_5)
                imageButton.setImageResource(R.mipmap.x_won)
                imageButton = findViewById(R.id.pos_8)
                imageButton.setImageResource(R.mipmap.x_won)
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Won"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.setImageResource(R.mipmap.x_won)
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
                makeAllButtonsNonClickable()
            }
            62 -> {
                var imageButton = findViewById<ImageButton>(R.id.pos_2)
                imageButton.setImageResource(R.mipmap.o_won)
                imageButton = findViewById(R.id.pos_5)
                imageButton.setImageResource(R.mipmap.o_won)
                imageButton = findViewById(R.id.pos_8)
                imageButton.setImageResource(R.mipmap.o_won)
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Won"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.setImageResource(R.mipmap.o_won)
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
                makeAllButtonsNonClickable()
            }
            71 -> {
                var imageButton = findViewById<ImageButton>(R.id.pos_0)
                imageButton.setImageResource(R.mipmap.x_won)
                imageButton = findViewById(R.id.pos_4)
                imageButton.setImageResource(R.mipmap.x_won)
                imageButton = findViewById(R.id.pos_8)
                imageButton.setImageResource(R.mipmap.x_won)
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Won"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.setImageResource(R.mipmap.x_won)
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
                makeAllButtonsNonClickable()
            }
            72 -> {
                var imageButton = findViewById<ImageButton>(R.id.pos_0)
                imageButton.setImageResource(R.mipmap.o_won)
                imageButton = findViewById(R.id.pos_4)
                imageButton.setImageResource(R.mipmap.o_won)
                imageButton = findViewById(R.id.pos_8)
                imageButton.setImageResource(R.mipmap.o_won)
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Won"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.setImageResource(R.mipmap.o_won)
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
                makeAllButtonsNonClickable()
            }
            81 -> {
                var imageButton = findViewById<ImageButton>(R.id.pos_2)
                imageButton.setImageResource(R.mipmap.x_won)
                imageButton = findViewById(R.id.pos_4)
                imageButton.setImageResource(R.mipmap.x_won)
                imageButton = findViewById(R.id.pos_6)
                imageButton.setImageResource(R.mipmap.x_won)
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Won"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.setImageResource(R.mipmap.x_won)
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
                makeAllButtonsNonClickable()
            }
            82 -> {
                var imageButton = findViewById<ImageButton>(R.id.pos_2)
                imageButton.setImageResource(R.mipmap.o_won)
                imageButton = findViewById(R.id.pos_4)
                imageButton.setImageResource(R.mipmap.o_won)
                imageButton = findViewById(R.id.pos_6)
                imageButton.setImageResource(R.mipmap.o_won)
                val textView = findViewById<TextView>(R.id.turn_indicator_text)
                textView.text = "Won"
                val imageView = findViewById<ImageView>(R.id.turn_indicator)
                imageView.setImageResource(R.mipmap.o_won)
                val playAgainButton = findViewById<Button>(R.id.play_again)
                playAgainButton.isClickable = true
                playAgainButton.visibility = View.VISIBLE
                makeAllButtonsNonClickable()
            }
        }
    }

    /**
     * Monitors the game status and takes appropriate actions accordingly
     */
    private fun monitorGame() {
        val status = getGameStatus()
        if (status != 0) {
            onGameOver(status)
        } else {
            changeTurnStatus()
            startGameWithBot(isBotsTurn)
        }
    }

    /**
     * Play the game again
     */
    fun playAgain(v: View) {
        finish()
    }

    /**
     * Makes all ImageButtons non-clickable
     */
    private fun makeAllButtonsNonClickable() {
        findViewById<ImageButton>(R.id.pos_0).isClickable = false
        findViewById<ImageButton>(R.id.pos_1).isClickable = false
        findViewById<ImageButton>(R.id.pos_2).isClickable = false
        findViewById<ImageButton>(R.id.pos_3).isClickable = false
        findViewById<ImageButton>(R.id.pos_4).isClickable = false
        findViewById<ImageButton>(R.id.pos_5).isClickable = false
        findViewById<ImageButton>(R.id.pos_6).isClickable = false
        findViewById<ImageButton>(R.id.pos_7).isClickable = false
        findViewById<ImageButton>(R.id.pos_8).isClickable = false
    }
}
