package com.iesantoniosequeros.componentesbasicos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class JJG_PrimosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_jjg_primos)
        val pulsar = this.findViewById<Button>(R.id.button1)
        val entrada = this.findViewById<TextView>(R.id.textView2)
        val resultado = this.findViewById<TextView>(R.id.textView1)

        fun isPrime(n: Int): Boolean {
            if (n < 2) return false
            for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
                if (n % i == 0) {
                    return false
                }
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

            resultado.text = primes.toString()
        }

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets

            }
        }
    }








