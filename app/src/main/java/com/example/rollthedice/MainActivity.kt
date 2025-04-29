package com.example.rollthedice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.util.Log
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val TAG = "MainActivity" // Il tag serve a visualizzare l'activity corretta nei log

        val startBtn = findViewById<ImageButton>(R.id.indovinaBtn) // Recupero il pulsante
        startBtn.setOnClickListener{ // Associo ad esso un comportamento
            intent()
            Log.d(TAG, "Lanciata la seconda activity") // Log per tenere traccia del corretto funzionamento nel Logcat
        }
    }

    private fun intent() { // Richiama il secondo activity main senza passare ad esso parametri
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}