package com.example.shubham.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Method called when the user clicks on the play button
     */
    fun startGame(view: View) {
        Toast.makeText(this, "The button is working", Toast.LENGTH_SHORT).show()
    }
}
