package com.example.shubham.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class IOrComputerFirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ior_computer_first)
    }

    /**
     * Displays that user will have symbol X when he/she chooses to play first
     */
    fun showSymbolX(v: View) {
        Toast.makeText(this, "Your symbol will be X", Toast.LENGTH_SHORT).show()
    }

    /**
     * Displays that user will have symbol O when he/she chooses to play second
     */
    fun showSymbolO(v: View) {
        Toast.makeText(this, "Your symbol will be O", Toast.LENGTH_SHORT).show()
    }

    /**
     * Starts the game with the computer, and passes the PlayWithComputerActivity an index telling
     * who has to start the game
     *
     * If the checkedRadioButtonIndex = 0, human has to start the game
     * If the checkedRadioButtonIndex = 1, computer has to start the game
     */
    fun startGameWithComputer(v: View) {
        val radioGroup = findViewById<RadioGroup>(R.id.first_player)
        val checkedRadioButtonId = radioGroup.checkedRadioButtonId
        val checkedRadioButtonIndex = radioGroup.indexOfChild(findViewById(checkedRadioButtonId))
        val intent = Intent(this, PlayWithComputerActivity::class.java)
        intent.putExtra("FIRST_PLAYER", checkedRadioButtonIndex)
        startActivity(intent)
        finish()
    }
}
