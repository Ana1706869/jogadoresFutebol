package com.example.projeto2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

const val EXTRA_MENSAGEM="Mensagem"


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enviar = findViewById<Button>(R.id.buttonEnviar)
        enviar.setOnClickListener { enviaMensagem() }


    }

    private fun enviaMensagem() {
        val mensagem = findViewById<TextView>(R.id.mensagem)
        val mensagemEnviada = mensagem.text.toString()
        if (mensagemEnviada.isBlank()) {
            mensagem.error = getString(R.string.mensagem_vazia)
            mensagem.requestFocus()

            return
        }
        val intent = Intent(this, mostrarmensagem::class.java)

            intent.putExtra(EXTRA_MENSAGEM, mensagemEnviada)

            startActivity(intent)
        }
    }







