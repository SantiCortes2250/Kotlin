package com.example.saltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class activity_resultados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        var nombre = findViewById<TextView>(R.id.txtResultNombre)
        var documento = findViewById<TextView>(R.id.txtResultDocumento)
        var telefono = findViewById<TextView>(R.id.txtResultTelefono)
        var direccion = findViewById<TextView>(R.id.txtResultDireccion)
        var edad = findViewById<TextView>(R.id.txtResultEdad)

        var promedio = findViewById<TextView>(R.id.txtResultadoNotas)
        var resultado = findViewById<TextView>(R.id.txtResultado)


        var btnSalir=findViewById<Button>(R.id.btnSalirResultados)
        btnSalir.setOnClickListener { Salir() }

        var Materia1 = findViewById<TextView>(R.id.mate1)
        var Materia2 = findViewById<TextView>(R.id.mate2)
        var Materia3 = findViewById<TextView>(R.id.mate3)
        var Materia4 = findViewById<TextView>(R.id.mate4)
        var Materia5 = findViewById<TextView>(R.id.mate5)

        var nota1 = findViewById<TextView>(R.id.txtn1)
        var nota2 = findViewById<TextView>(R.id.txtn2)
        var nota3 = findViewById<TextView>(R.id.txtn3)
        var nota4 = findViewById<TextView>(R.id.txtn4)
        var nota5 = findViewById<TextView>(R.id.txtn5)

        var recupera = findViewById<TextView>(R.id.txtResultadoRecuperar)



        var bundle: Bundle? = this.intent.extras

        resultado.text="${bundle?.getString("resultado")}"
        promedio.text="${bundle?.getDouble("promedio")}"
        documento.text="${bundle?.getString("documento")}"
        nombre.text="${bundle?.getString("nombre")}"
        edad.text="${bundle?.getInt("edad")}"
        telefono.text="${bundle?.getString("telefono")}"
        direccion.text="${bundle?.getString("direccion")}"
        Materia1.text="${bundle?.getString("Materia1")}"
        Materia2.text="${bundle?.getString("Materia2")}"
        Materia3.text="${bundle?.getString("Materia3")}"
        Materia4.text="${bundle?.getString("Materia4")}"
        Materia5.text="${bundle?.getString("Materia5")}"
        nota1.text="${bundle?.getDouble("nota1")}"
        nota2.text="${bundle?.getDouble("nota2")}"
        nota3.text="${bundle?.getDouble("nota3")}"
        nota4.text="${bundle?.getDouble("nota4")}"
        nota5.text="${bundle?.getDouble("nota5")}"

        if (bundle?.getString("resultado")=="Perdio") {
            recupera.text = "Puede recuperar: ${bundle?.getString("recuperaciones")}"
        }

    }

    private fun Salir() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}