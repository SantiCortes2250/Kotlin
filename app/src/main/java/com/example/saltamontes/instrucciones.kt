package com.example.saltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class instrucciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instrucciones)

        var btnSalir=findViewById<Button>(R.id.btnSalirInstru)
        btnSalir.setOnClickListener { Salir() }
    }

    private fun Salir() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}