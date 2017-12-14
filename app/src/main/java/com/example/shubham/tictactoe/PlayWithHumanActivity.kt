package com.example.shubham.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView

class PlayWithHumanActivity : AppCompatActivity() {

    private var isXTurn = true  // boolean to determine whose turn it is

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_with_human)
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
        changeTurnStatus()
        imageButton.isClickable = false
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
        changeTurnStatus()
        imageButton.isClickable = false
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
        changeTurnStatus()
        imageButton.isClickable = false
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
        changeTurnStatus()
        imageButton.isClickable = false
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
        changeTurnStatus()
        imageButton.isClickable = false
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
        changeTurnStatus()
        imageButton.isClickable = false
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
        changeTurnStatus()
        imageButton.isClickable = false
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
        changeTurnStatus()
        imageButton.isClickable = false
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
        changeTurnStatus()
        imageButton.isClickable = false
    }

    /**
     * This method changes the indicator telling whose turn it is
     */
    private fun changeTurnStatus() {
        isXTurn = !isXTurn
        val imageView = findViewById<ImageView>(R.id.turn_indicator)
        if(isXTurn) {
            imageView.setImageResource(R.mipmap.x)
        } else {
            imageView.setImageResource(R.mipmap.o)
        }
    }
}
