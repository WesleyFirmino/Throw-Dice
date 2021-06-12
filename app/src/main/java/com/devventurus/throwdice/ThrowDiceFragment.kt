package com.devventurus.throwdice

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.devventurus.throwdice.databinding.FragmentThrowDiceBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ThrowDiceFragment : Fragment() {

    var binding: FragmentThrowDiceBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThrowDiceBinding.inflate(inflater, container, false)

        val diceOne = binding?.diceOne
        val diceTwo = binding?.diceTwo
        val btnRegister = binding?.btnStart
        val welcomeMessage = binding?.welcomeMessage
        val shareButton = binding?.share

        welcomeMessage?.text = getString(R.string.welcome, arguments?.getString("playerName").toString())

        val dice = listOf(  R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6 )

        btnRegister?.setOnClickListener {
            diceOne?.setImageResource(dice.random())
            diceTwo?.setImageResource(dice.random())
        }

        shareButton?.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)

            intent.putExtra(Intent.EXTRA_TEXT, "You're lucky!")
            intent.setPackage("com.whatsapp")
            intent.type = "text/plain"

            activity?.packageManager?.run {
                if (intent.resolveActivity(this) != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(context, "You haven't WhatsApp", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return binding?.root
    }
}