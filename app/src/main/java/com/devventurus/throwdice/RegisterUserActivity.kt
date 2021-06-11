package com.devventurus.throwdice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        val nameUser = findViewById<EditText>(R.id.register_user)
        val btnRegister = findViewById<Button>(R.id.btn_register_name)

        btnRegister.setOnClickListener{
            var name = nameUser.text.toString()

            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("player_name", name)

            startActivity(intent)
        }
    }
}