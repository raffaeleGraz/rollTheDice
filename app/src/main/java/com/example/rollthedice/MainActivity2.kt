package com.example.rollthedice

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val inputNumber = findViewById<EditText>(R.id.inputNumber) // Recupero l'input dell'utente
        val lanciaBtn = findViewById<ImageButton>(R.id.lanciaBtn) // Recupero il bottone
        lanciaBtn.setOnClickListener{
            // CONVERSIONE EDITTEXT A INTERO
            val inputNumberS = inputNumber.text.toString() // Prima a stringa
            val userNumber = inputNumberS.toIntOrNull() // A intero

            if(userNumber != null && userNumber > 0 && userNumber <=6) { // Controllo del numero inserito
                val randomNumber = estrazione()
                intent(randomNumber, userNumber)
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