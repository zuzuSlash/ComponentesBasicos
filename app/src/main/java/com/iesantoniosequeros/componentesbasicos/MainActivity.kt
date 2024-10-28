package com.iesantoniosequeros.componentesbasicos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var contador: Int = 0;
    var jjg = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contador++;
        jjg = 0
        android.util.Log.i("ESTADOS", "Creando la actividad:" + contador)
        Log.i("ESTADOS", "Evento onCreate:" + contador)
        Log.i("ESTADOS", "Evento onCreate [JJG]:" + jjg)
        setContentView(R.layout.activity_main)


        var b_estados=findViewById<Button>(R.id.button2)
        b_estados.setOnClickListener() {
            val intent: Intent = Intent(this, JJG_PrimosActivity::class.java)
            startActivityForResult(intent,1)
        }
    }



    override fun onStart() {
        super.onStart()
        contador++
        jjg++
        Log.i("ESTADOS", "Evento onStart:" + contador)
        Log.i("ESTADOS", "Evento onStart [JJG]:" + jjg)
    }

    override fun onResume() {
        super.onResume()
        contador++;
        jjg++
        Log.i("ESTADOS", "Evento onResume:" + contador)
        Log.i("ESTADOS", "Evento onResume [JJG]:" + jjg)
    }

    override fun onStop() {
        super.onStop()
        contador++;
        jjg++
        Log.i("ESTADOS", "Evento onStop:" + contador)
        Log.i("ESTADOS", "Evento onStop [JJG]:" + jjg)
    }

    override fun onDestroy() {
        super.onDestroy()
        jjg++
        Log.i("ESTADOS", "Evento onDestroy:" + contador)
        Log.i("ESTADOS", "Evento onDestroy [JJG]:" + jjg)

    }






}