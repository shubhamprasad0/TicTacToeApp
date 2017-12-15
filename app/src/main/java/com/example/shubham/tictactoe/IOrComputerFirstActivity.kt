package com.example.shubham.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
     * Starts the game with the computer
     */
    fun startGameWithComputer(v: View) {
        val intent = Intent(this, PlayWithComputerActivity::class.java)
        startActivity(intent)
        finish()
    }
}
