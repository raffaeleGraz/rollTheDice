package com.example.rollthedice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<ImageButton>(R.id.indovinaBtn)
        startBtn.setOnClickListener{
            intent()
        }
    }

    private fun intent() {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}