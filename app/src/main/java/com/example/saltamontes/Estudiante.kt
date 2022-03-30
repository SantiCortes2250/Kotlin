package com.example.saltamontes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class Estudiante {

    var documento:String?=null
    var nombre:String?=null
    var edad:Int?=null
    var telefono:String?=null
    var direccion:String?=null

    var materia1: String?=null
    var nota1: Double?=null
        set(value) {
            if (value != null) {
                if (value>=0){
                    field=value
                }else{
                    field=0.0
                }
            }else{
                field=0.0
            }
        }
    var materia2: String?=null
    var nota2: Double?=null
        set(value) {
            if (value != null) {
                if (value>=0){
                    field=value
                }else{
                    field=0.0
                }
            }else{
                field=0.0
            }
        }
    var materia3: String?=null
    var nota3: Double?=null
        set(value) {
            if (value != null) {
                if (value>=0){
                    field=value
                }else{
                    field=0.0
                }
            }else{
                field=0.0
            }
        }
    var materia4: String?=null
    var nota4: Double?=null
        set(value) {
            if (value != null) {
                if (value>=0){
                    field=value
                }else{
                    field=0.0
                }
            }else{
                field=0.0
            }
        }
    var materia5: String?=null
    var nota5: Double?=null
        set(value) {
            if (value != null) {
                if (value>=0){
                    field=value
                }else{
                    field=0.0
                }
            }else{
                field=0.0
            }
        }

    var resultado: String?=null
    var recuperacion: Boolean?=null
    var promedio: Double?=null
        set(value) {
            if (value != null) {
                if (value<=3.5) {
                    if (value<=2.5){
                        recuperacion=false
                    }else{
                        recuperacion=true
                    }
                }
            }
            field = value
        }


}