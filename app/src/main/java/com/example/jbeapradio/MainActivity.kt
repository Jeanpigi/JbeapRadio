package com.example.jbeapradio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import android.widget.Toast

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Usando el archivo XML activity_main.xml para la interfaz
        setContentView(R.layout.activity_main)

        // Encontrar los botones en el layout
        val startButton = findViewById<Button>(R.id.startButton)
        val stopButton = findViewById<Button>(R.id.stopButton)

        // Configurar el listener para iniciar el servicio
        startButton.setOnClickListener {
            startService(Intent(this, RadioService::class.java))
            Toast.makeText(this, "Iniciando radio...", Toast.LENGTH_SHORT).show()
        }


        // Configurar el listener para detener el servicio
        stopButton.setOnClickListener {
            stopService(Intent(this, RadioService::class.java))
        }
    }
}
