package com.example.rollthedice

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val randomNumber = intent.getIntExtra("randomNumber", -1) // Recupera il numero random
        val userNumber = intent.getIntExtra("userNumber", -1) // Recupera il numero dell'utente

        // CONDIZIONE PER L'ESITO
        val esitoView = findViewById<ImageView>(R.id.esitoView)
        if(userNumber != randomNumber) {
            esitoView.setImageResource(R.drawable.sconfitta)
        } else {
            esitoView.setImageResource(R.drawable.vittoria)
        }

        val diceView= findViewById<ImageView>(R.id.diceView) // Recupera l'imageView dei dadi
        val imgDiceResources = when(randomNumber) {
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