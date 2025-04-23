package com.example.rollthedice

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<ImageButton>(R.id.startBtn)
        startBtn.setOnClickListener{
            var numero = estrazione()
            intent(numero)
        }
    }

    private fun estrazione():Int {
        return (1..6).random()
    }

    private fun intent(numero:Int){
        var intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("numero", numero)
        startActivity(intent)
    }
}