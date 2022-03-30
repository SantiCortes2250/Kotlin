package com.example.saltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Estadisticas : AppCompatActivity() {
    var lista=Operaciones.listEstudiantes
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        var registros = findViewById<TextView>(R.id.txtRegistros)
        var ganan = findViewById<TextView>(R.id.txtGanaron)
        var pierden = findViewById<TextView>(R.id.txtPerdieron)
        var recuperan = findViewById<TextView>(R.id.txtRecuperan)

        var btnSalir = findViewById<Button>(R.id.btnSalirEstadisticas)
        btnSalir.setOnClickListener { Salir() }

        var registrosTotales=lista.size
        var CantGanaron:Int=totalGanan()
        var cantPierden:Int=totalPierden()
        var cantRecuperan:Int=totalRecuperan()

        registros.text="$registrosTotales"
        ganan.text="$CantGanaron"
        pierden.text="$cantPierden"
        recuperan.text="$cantRecuperan"

    }

    private fun totalRecuperan(): Int {
        var cantidad=0
        for (est in lista){
            if (est.recuperacion==true){
                cantidad=cantidad+1
            }
        }

        return cantidad
    }

    private fun totalPierden(): Int {
        var cantidad=0
        for (est in lista){
            if (est.resultado.equals("Perdio")){
                cantidad=cantidad+1
            }
        }

        return cantidad
    }

    private fun totalGanan(): Int {
        var cantidad=0
        for (est in lista){
            if (est.resultado.equals("Gano")){
                cantidad=cantidad+1
            }
        }

        return cantidad
    }

    private fun Salir() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}