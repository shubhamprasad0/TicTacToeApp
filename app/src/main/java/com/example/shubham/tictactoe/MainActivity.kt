package com.example.shubham.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Method called when the user clicks on the play button
     *
     * Starts the game in single-player mode if the user chose "Play with Computer"
     * Starts the game in two-player mode if the user chose "Play with Human"
     *
     */
    fun startGame(v: View) {
        val index = getIndexOfCheckedRadioButton()
        if (index == 0) {
            val intent = Intent(this, IOrComputerFirstActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, TwoPlayerModeChooserActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * Finds which RadioButton was checked by the user and returns appropriate index:-
     *      0. Play with Computer
     *      1. Play with Human
     *
     * @return index (index of the checked RadioButton in the RadioGroup
     */
    private fun getIndexOfCheckedRadioButton(): Int {
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)
        val checkedRadioButtonId = radioGroup.checkedRadioButtonId
        val checkedRadioButton = findViewById<RadioButton>(checkedRadioButtonId)
        val index = radioGroup.indexOfChild(checkedRadioButton)
        return index
    }
}
