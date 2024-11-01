package com.iesantoniosequeros.componentesbasicos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var contador: Int = 0
    var jjg = 0

    private val launcher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult(), object :
            ActivityResultCallback<ActivityResult> {
            override fun onActivityResult(result: ActivityResult) {
                val data = result.data
                if (result.resultCode == RESULT_OK && data != null) {
                    val primes = data.getIntegerArrayListExtra("primos")
                    Log.i("Devolucion resultado", result.resultCode.toString())
                    Log.i("Devolucion resultado", "Números primos recibidos: $primes")

                    findViewById<TextView>(R.id.textViewResultX).text = "PrimosX: $primes"
                }
            }
        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contador++
        jjg = 0
        Log.i("ESTADOS", "Creando la actividad: $contador")
        Log.i("ESTADOS", "Evento onCreate: $contador")
        Log.i("ESTADOS", "Evento onCreate [JJG]: $jjg")
        setContentView(R.layout.activity_main)

        val b_estados = findViewById<Button>(R.id.button2)
        b_estados.setOnClickListener {
            val intent = Intent(this, JJG_PrimosActivity::class.java)
            startActivityForResult(intent, 1)
        }


        val b_estadosX = findViewById<Button>(R.id.button3)
        b_estadosX.setOnClickListener {
            val intent = Intent(this, JJG_PrimosXActivity::class.java)
            launcher.launch(intent)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val primes = data?.getIntegerArrayListExtra("primos")
            findViewById<TextView>(R.id.textViewResult).text = "Primos: $primes"
            Log.i("ESTADOS", "Números primos recibidos (PrimosActivity): $primes")
        }
    }

    override fun onStart() {
        super.onStart()
        contador++
        jjg++
        Log.i("ESTADOS", "Evento onStart: $contador")
        Log.i("ESTADOS", "Evento onStart [JJG]: $jjg")
    }

    override fun onResume() {
        super.onResume()
        contador++
        jjg++
        Log.i("ESTADOS", "Evento onResume: $contador")
        Log.i("ESTADOS", "Evento onResume [JJG]: $jjg")
    }

    override fun onStop() {
        super.onStop()
        contador++
        jjg++
        Log.i("ESTADOS", "Evento onStop: $contador")
        Log.i("ESTADOS", "Evento onStop [JJG]: $jjg")
    }

    override fun onDestroy() {
        super.onDestroy()
        jjg++
        Log.i("ESTADOS", "Evento onDestroy: $contador")
        Log.i("ESTADOS", "Evento onDestroy [JJG]: $jjg")
    }
}
