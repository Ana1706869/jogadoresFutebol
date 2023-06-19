package com.example.projeto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class mostrarmensagem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mostrarmensagem)
        val mensagem = intent.getStringExtra(EXTRA_MENSAGEM)

        val textViewMensagem = findViewById<TextView>(R.id.mensagemRecebida)
        textViewMensagem.text = mensagem
    }
}