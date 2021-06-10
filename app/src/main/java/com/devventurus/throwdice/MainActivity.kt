package com.devventurus.throwdice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diceOne = findViewById<ImageView>(R.id.dice_one)
        val diceTwo = findViewById<ImageView>(R.id.dice_two)
        val btnRegister = findViewById<Button>(R.id.btn_register)

        val dice = listOf(
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6 )

        btnRegister.setOnClickListener {
            diceOne.setImageResource(dice.random())
            diceTwo.setImageResource(dice.random())
        }
    }
}