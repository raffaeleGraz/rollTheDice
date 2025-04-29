package com.example.rollthedice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val TAG = "MainActivity2"

        val inputNumber = findViewById<EditText>(R.id.inputNumber) // Recupero l'input dell'utente
        val lanciaBtn = findViewById<ImageButton>(R.id.lanciaBtn) // Recupero il pulsante
        lanciaBtn.setOnClickListener{ // Associo ad esso un comportamento
            // CONVERSIONE EDIT TEXT A INTERO
            val inputNumberS = inputNumber.text.toString() // Prima a stringa
            val userNumber = inputNumberS.toIntOrNull() // Poi a intero

            if(userNumber != null) { // Verifico per prima cosa che non sia nullo
                if(userNumber in 1..6) { // Se il numero in input è compreso tra 1 e 6 allora:
                    Toast.makeText(this, "Dado lanciato!", Toast.LENGTH_SHORT).show() // Toast per il dado lanciato

                    val randomNumber = estrazione() // Simulo il lancio del dado generando un numero random
                    intent(randomNumber, userNumber) // Richiamo l'ultima activity passando come parametri i due numeri: il numero random e l'input dell'utente
                    Log.d(TAG, "Lanciata la terza activity")
                } else {
                    // Se il numero non è valido
                    Log.d(TAG, "Input errato")
                    Toast.makeText(this, "Input errato!", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Se il numero è nullo
                Log.d(TAG, "Input vuoto")
                Toast.makeText(this, "Inserisci un numero!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun estrazione():Int {
        return (1..6).random() // Genero un numero random compreso tra 1 e 6
    }

    private fun intent(randomNumber: Int, userNumber: Int) {
        val intent = Intent(this, MainActivity3::class.java)
        // PutExtra per passare parametri tra activity
        intent.putExtra("randomNumber", randomNumber)
        intent.putExtra("userNumber", userNumber)
        startActivity(intent)
    }
}