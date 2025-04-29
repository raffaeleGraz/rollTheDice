package com.example.rollthedice

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import nl.dionsegijn.konfetti.xml.KonfettiView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit
import android.graphics.Color
import android.util.Log


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val TAG = "MainActivity3"

        val randomNumber = intent.getIntExtra("randomNumber", -1) // Recupera il numero random
        val userNumber = intent.getIntExtra("userNumber", -1) // Recupera il numero dell'utente
        Log.d(TAG, "Numero input: " + userNumber)
        Log.d(TAG, "Numero random: " + randomNumber)

        // CONDIZIONE PER L'ESITO
        val esitoView = findViewById<ImageView>(R.id.esitoView)
        if(userNumber != randomNumber) {
            esitoView.setImageResource(R.drawable.sconfitta)
        } else {
            esitoView.setImageResource(R.drawable.vittoria)

            val konfettiView = findViewById<KonfettiView>(R.id.konfettiView) //Recupera i coriandoli per la vittoria
            konfettiView.start(
                Party(
                    speed = 30f, // Imposta la velocità
                    maxSpeed = 50f, // Velocità massima raggiungibile
                    damping = 0.9f, // Rallentamento dei coriandoli
                    spread = 360, // Angolo in cui verranno emessi i coriandoli (360 = in ogni direzione)
                    colors = listOf(Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.RED), // Lista dei colori
                    emitter = Emitter(duration = 1000, TimeUnit.MILLISECONDS).max(200), // Durata: 1000ms (1s) in cui vengono emessi 200 coriandoli
                    position = Position.Relative(0.0, 0.5) // Posizione da cui partono (orizzontalmente a sinistra e verticalmente al centro)

                )
            )
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