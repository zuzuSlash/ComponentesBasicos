package com.iesantoniosequeros.componentesbasicos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var contador: Int = 0;
    var jjg = 0;
    private lateinit var primosXLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contador++;
        jjg = 0
        android.util.Log.i("ESTADOS", "Creando la actividad:" + contador)
        Log.i("ESTADOS", "Evento onCreate:" + contador)
        Log.i("ESTADOS", "Evento onCreate [JJG]:" + jjg)
        setContentView(R.layout.activity_main)

        primosXLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val primes = data?.getIntegerArrayListExtra("primos")
                Log.i("ESTADOS", "Números primos recibidos (PrimosXActivity): $primes")
            }
        }

        var b_estados = findViewById<Button>(R.id.button2)
        b_estados.setOnClickListener() {
            val intent: Intent = Intent(this, JJG_PrimosActivity::class.java)
            startActivityForResult(intent,1)
        }

        val b_estadosX = findViewById<Button>(R.id.button3)
        b_estadosX.setOnClickListener {
            val intent = Intent(this, JJG_PrimosXActivity::class.java)
            primosXLauncher.launch(intent)
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