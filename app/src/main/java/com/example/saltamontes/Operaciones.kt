package com.example.saltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Operaciones {

    companion object {
        var listEstudiantes= ArrayList<Estudiante>()

        fun registrar(estudiante:Estudiante) {
            listEstudiantes.add(estudiante)
        }

        fun getList(): ArrayList<Estudiante> {
            return listEstudiantes
        }
    }

}