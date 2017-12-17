package com.example.shubham.tictactoe

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_two_player_mode_chooser.*

class TwoPlayerModeChooserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_player_mode_chooser)
    }

    /**
     * On click handler of button deciding the player wants to play online or offline
     */
    fun startGameWithHuman(v: View) {
        val checkedRadioButtonId = two_player_mode_chooser.checkedRadioButtonId
        val checkedRadioButtonIndex = two_player_mode_chooser.indexOfChild(findViewById(checkedRadioButtonId))
        when(checkedRadioButtonIndex) {
            0 -> {
                val intent = Intent(this, PlayWithHumanActivity::class.java)
                startActivity(intent)
                finish()
            }
            1 -> {
                // TODO: Play over network
            }
        }
    }
}
