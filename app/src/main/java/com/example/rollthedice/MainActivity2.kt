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
        val lanciaBtn = findViewById<ImageButton>(R.id.lanciaBtn) // Recupero il bottone
        lanciaBtn.setOnClickListener{
            // CONVERSIONE EDITTEXT A INTERO
            val inputNumberS = inputNumber.text.toString() // Prima a stringa
            val userNumber = inputNumberS.toIntOrNull() // A intero

            if(userNumber != null) {
                if(userNumber in 1..6) {
                    Toast.makeText(this, "Dado lanciato!", Toast.LENGTH_SHORT).show() // Toast per il dado lanciato

                    val randomNumber = estrazione()
                    intent(randomNumber, userNumber)
                    Log.d(TAG, "Lanciata la terza activity")
                } else {
                    //messaggi di errore
                    Log.d(TAG, "Input errato")
                    Toast.makeText(this, "Input errato!", Toast.LENGTH_SHORT).show()
                }
            } else {
                //messaggi di errore
                Log.d(TAG, "Input vuoto")
                Toast.makeText(this, "Inserisci un numero!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun estrazione():Int {
        return (1..6).random()
    }

    private fun intent(randomNumber: Int, userNumber: Int) {
        val intent = Intent(this, MainActivity3::class.java)
        intent.putExtra("randomNumber", randomNumber)
        intent.putExtra("userNumber", userNumber)
        startActivity(intent)
    }
}