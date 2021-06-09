package com.devventurus.throwdice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diceOne = findViewById<TextView>(R.id.txt_dice_one)
        val diceTwo = findViewById<TextView>(R.id.txt_dice_two)
        val btnRegister = findViewById<Button>(R.id.btn_register)

        btnRegister.setOnClickListener {
            diceOne.text = randomNumberCreate().toString()
            diceTwo.text = randomNumberCreate().toString()
        }
    }

    private fun randomNumberCreate() : Int {
        return (1..6).random()
    }
}