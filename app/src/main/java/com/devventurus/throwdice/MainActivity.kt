package com.devventurus.throwdice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameUser = intent.getStringExtra("player_name")

        val diceOne = findViewById<ImageView>(R.id.dice_one)
        val diceTwo = findViewById<ImageView>(R.id.dice_two)
        val btnRegister = findViewById<Button>(R.id.btn_start)
        val welcomeMessage = findViewById<TextView>(R.id.welcome_message)
        val shareButton = findViewById<FloatingActionButton>(R.id.share)

        welcomeMessage.text = getString(R.string.welcome, nameUser)

        val dice = listOf(  R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6 )

        btnRegister.setOnClickListener {
            diceOne.setImageResource(dice.random())
            diceTwo.setImageResource(dice.random())
        }

        shareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)

            intent.putExtra(Intent.EXTRA_TEXT, "You're lucky!")
            intent.setPackage("com.whatsapp")
            intent.type = "text/plain"

            if(intent.resolveActivity(this.packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "You haven't WhatsApp", Toast.LENGTH_SHORT).show()
            }
        }

    }
}