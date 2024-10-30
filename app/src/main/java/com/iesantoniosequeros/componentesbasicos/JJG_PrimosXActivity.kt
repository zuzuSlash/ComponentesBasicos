package com.iesantoniosequeros.componentesbasicos

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class JJG_PrimosXActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jjg_primos_xactivity)

            val pulsar = findViewById<Button>(R.id.button1)
            val entrada = findViewById<TextView>(R.id.textView2)

            fun isPrime(n: Int): Boolean {
                if (n < 2) return false
                for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
                    if (n % i == 0) return false
                }
                return true
            }

            fun searchPrimesRecursive(n: Int): List<Int> {
                if (n <= 1) return emptyList()
                val primes = searchPrimesRecursive(n - 1).toMutableList()
                if (isPrime(n)) primes.add(n)
                return primes
            }

            pulsar.setOnClickListener {
                val inputText = entrada.text.toString()
                val n = inputText.toInt()
                val primes = searchPrimesRecursive(n - 1)

                val resultIntent = Intent().apply {
                    putIntegerArrayListExtra("primos", ArrayList(primes))
                }
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }