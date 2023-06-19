package com.example.teste3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botao: Button =findViewById(R.id.button)
        botao.setOnClickListener{
            Toast.makeText(this, "Amo-te", Toast.LENGTH_LONG).show()
        }
    }
}