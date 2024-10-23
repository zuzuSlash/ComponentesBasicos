package com.iesantoniosequeros.componentesbasicos

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var contador:Int=0;
    var jjg = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contador++;
        jjg = 0
        android.util.Log.i("ESTADOS","Creando la actividad:"+contador)
        Log.i("ESTADOS","Evento onCreate:"+contador)
        Log.i("ESTADOS","Evento onCreate:"+jjg)
        setContentView(R.layout.activity_main)
    }
    override fun onStart() {
        super.onStart()
        contador++;
        Log.i("ESTADOS","Evento onStart:"+contador)
    }
    override fun onResume() {
        super.onResume()
        contador++;
        Log.i("ESTADOS","Evento onResume:"+contador)

    }
    override fun onStop() {
        super.onStop()
        contador++;
        Log.i("ESTADOS","Evento onStop:"+contador)
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("ESTADOS","Evento onDestroy:"+contador)


    }


}