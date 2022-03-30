package com.example.saltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        iniciarComponentes()

    }

    private fun iniciarComponentes(){
        var botonEstadisticas:Button = findViewById(R.id.btnEstadisticas)
        var botonIntrucciones:Button = findViewById(R.id.btnInstruc)
        var botonregistro:Button = findViewById(R.id.btnRegistro)

        botonEstadisticas.setOnClickListener{onClick(2)}
        botonIntrucciones.setOnClickListener { onClick(3) }
        botonregistro.setOnClickListener { onClick(4) }

    }

    private fun onClick(numBoton : Int){
        when(numBoton){
            2->startActivity(Intent(this, Estadisticas::class.java))
            3->startActivity(Intent(this, instrucciones::class.java))
            4->startActivity(Intent(this, registro::class.java))

        }
    }


}