package com.example.rollthedice

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val numero = intent.getIntExtra("numero", -1)
        val diceView= findViewById<ImageView>(R.id.diceView)

        val imgDiceResources = when(numero) {
            1 -> R.drawable.dado1
            2 -> R.drawable.dado2
            3 -> R.drawable.dado3
            4 -> R.drawable.dado4
            5 -> R.drawable.dado5
            6 -> R.drawable.dado6
            else -> {R.drawable.dado1}
        }
        diceView.setImageResource(imgDiceResources as Int)
    }
}