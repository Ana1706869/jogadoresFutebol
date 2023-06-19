package com.example.a14042023anasilva1706869

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MostrarDados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_dados)

        val nome=intent.getStringExtra(EXTRA_NOME)
        val telefone=intent.getStringExtra(EXTRA_TELEFONE)
        val email=intent.getStringExtra(EXTRA_EMAIL)
        val altura=intent.getStringExtra(EXTRA_ALTURA)
        val peso=intent.getStringExtra(EXTRA_PESO)

        val editNome=findViewById<TextView>(R.id.textViewNome)
        editNome.text=nome
        val editTelefone=findViewById<TextView>(R.id.textViewTelefone)
        editTelefone.text=telefone
        val editEmail=findViewById<TextView>(R.id.textViewEmail)
        editEmail.text=email
        val editAltura=findViewById<TextView>(R.id.textViewAltura)
        editAltura.text=altura
        val editPeso=findViewById<TextView>(R.id.textViewPeso)
        editPeso.text=peso
    }
}