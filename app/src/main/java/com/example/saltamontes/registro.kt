package com.example.saltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.NumberFormatException

class registro : AppCompatActivity() {


    var Documento: EditText?=null
    var Nombre: EditText?=null
    var Edad: EditText?=null
    var Telefono: EditText?=null
    var Direccion: EditText?=null

    var Materia1: EditText?=null
    var Materia2: EditText?=null
    var Materia3: EditText?=null
    var Materia4: EditText?=null
    var Materia5: EditText?=null


    var Nota1: EditText?=null
    var Nota2: EditText?=null
    var Nota3: EditText?=null
    var Nota4: EditText?=null
    var Nota5: EditText?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        Documento=findViewById(R.id.txtDocumento)
        Nombre=findViewById(R.id.txtName)
        Edad=findViewById(R.id.txtEdad)
        Telefono=findViewById(R.id.txtTelefono)
        Direccion=findViewById(R.id.txtDireccion)

        Materia1=findViewById(R.id.txtMateria1)
        Materia2=findViewById(R.id.txtMateria2)
        Materia3=findViewById(R.id.txtMateria3)
        Materia4=findViewById(R.id.txtMateria4)
        Materia5=findViewById(R.id.txtMateria5)

        Nota1=findViewById(R.id.txtNota1)
        Nota2=findViewById(R.id.txtNota2)
        Nota3=findViewById(R.id.txtNota3)
        Nota4=findViewById(R.id.txtNota4)
        Nota5=findViewById(R.id.txtNota5)


        var btnCalcular:Button=findViewById(R.id.btnCalcular)
        btnCalcular.setOnClickListener { onClick() }

        var btnSalir:Button=findViewById(R.id.btnSalir)
        btnSalir.setOnClickListener { Salir() }

    }

    private fun Salir(){
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun onClick(){
        var miEstudiante:Estudiante= Estudiante()
        miEstudiante.documento=Documento?.text.toString()
        miEstudiante.nombre=Nombre?.text.toString()
        try {
            miEstudiante.edad=Edad?.text.toString().toInt()
        }catch (e:NumberFormatException){
            miEstudiante.edad=0
        }

        miEstudiante.telefono=Telefono?.text.toString()
        miEstudiante.direccion=Direccion?.text.toString()

        miEstudiante.materia1=Materia1?.text.toString()
        try {
            miEstudiante.nota1=Nota1?.text.toString().toDouble()
        }catch (e:NumberFormatException){
            miEstudiante.nota1=0.0
        }
        miEstudiante.materia2=Materia2?.text.toString()
        try {
            miEstudiante.nota2=Nota2?.text.toString().toDouble()
        }catch (e:NumberFormatException){
            miEstudiante.nota2=0.0
        }
        miEstudiante.materia3=Materia3?.text.toString()
        try {
            miEstudiante.nota3=Nota3?.text.toString().toDouble()
        }catch (e:NumberFormatException){
            miEstudiante.nota3=0.0
        }
        miEstudiante.materia4=Materia4?.text.toString()
        try {
            miEstudiante.nota4=Nota4?.text.toString().toDouble()
        }catch (e:NumberFormatException){
            miEstudiante.nota4=0.0
        }
        miEstudiante.materia5=Materia5?.text.toString()
        try {
            miEstudiante.nota5=Nota5?.text.toString().toDouble()
        }catch (e:NumberFormatException){
            miEstudiante.nota5=0.0
        }

        if(miEstudiante.nota1!! > 5 || miEstudiante.nota2!! > 5 || miEstudiante.nota3!! > 5 || miEstudiante.nota4!! > 5 || miEstudiante.nota5!! > 5){
            Toast.makeText(applicationContext, "Las notas no pueden ser mayores a 5", Toast.LENGTH_SHORT).show()
        }else{
            var promedio = (miEstudiante.nota1!!+miEstudiante.nota2!!+miEstudiante.nota3!!+miEstudiante.nota4!!+miEstudiante.nota5!!)/5

            miEstudiante.promedio=promedio

            var resultado:String?=null
            if (promedio > 3.5){
                resultado="Gano"
            }else{
                resultado="Perdio"
            }
            miEstudiante.resultado=resultado

            if (miEstudiante.documento!="" && miEstudiante.nombre!="" && miEstudiante.materia1!="" && miEstudiante.materia2!="" && miEstudiante.materia3!="" && miEstudiante.materia4!="" && miEstudiante.materia5!="") {
                Operaciones.registrar(miEstudiante)

                var intent = Intent(this, activity_resultados::class.java)
                val bundle: Bundle = Bundle()
                bundle.putString("documento", miEstudiante.documento)
                bundle.putString("nombre", miEstudiante.nombre)
                bundle.putInt("edad", miEstudiante.edad!!)
                bundle.putString("telefono", miEstudiante.telefono)
                bundle.putString("direccion", miEstudiante.direccion)
                bundle.putString("Materia1", miEstudiante.materia1)
                bundle.putString("Materia2", miEstudiante.materia2)
                bundle.putString("Materia3", miEstudiante.materia3)
                bundle.putString("Materia4", miEstudiante.materia4)
                bundle.putString("Materia5", miEstudiante.materia5)
                bundle.putDouble("nota1", miEstudiante.nota1!!)
                bundle.putDouble("nota2", miEstudiante.nota2!!)
                bundle.putDouble("nota3", miEstudiante.nota3!!)
                bundle.putDouble("nota4", miEstudiante.nota4!!)
                bundle.putDouble("nota5", miEstudiante.nota5!!)
                bundle.putDouble("promedio", miEstudiante.promedio!!)
                bundle.putString("resultado", miEstudiante.resultado)

                var recuperacion: String? = null

                if (promedio <= 2.5) {
                    recuperacion = "No"
                } else if (promedio <= 3.5) {
                    recuperacion = "Si"
                } else {
                    recuperacion = null
                }
                if (recuperacion != null) {
                    bundle.putString("recuperaciones", recuperacion)
                }

                intent.putExtras(bundle)
                startActivity(intent)

            }else{
                Toast.makeText(applicationContext, "Por favor llene todos los campos requeridos", Toast.LENGTH_SHORT).show()
            }

        }




    }
}