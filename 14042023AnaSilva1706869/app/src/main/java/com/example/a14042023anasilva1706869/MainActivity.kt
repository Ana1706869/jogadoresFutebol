package com.example.a14042023anasilva1706869

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

const val EXTRA_NOME="Nome"
const val EXTRA_TELEFONE="Telefone"
const val EXTRA_EMAIL="eMail"
const val EXTRA_PESO="Peso"
const val EXTRA_ALTURA="Altura"

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enviar = findViewById<Button>(R.id.buttonEnviar)
        enviar.setOnClickListener { enviaMensagem() }

    }
    private fun enviaMensagem() {
        val editNome = findViewById<EditText>(R.id.editTextNome)
        val nome = editNome.text.toString()
        val editTelefone = findViewById<EditText>(R.id.editTextTelefone)
        val telefone = editTelefone.text.toString()
        val editEmail = findViewById<EditText>(R.id.editTextTextEmail)
        val email = editEmail.text.toString()
        val editAltura = findViewById<EditText>(R.id.editTextAltura)
        val altura = editAltura.text.toString()
        val editPeso = findViewById<EditText>(R.id.editTextPeso)
        val peso = editPeso.text.toString()

        if (nome.isBlank()) {
            editNome.error = "Por favor introduza o seu nome!"
            editNome.requestFocus()
        }
        if (telefone.isBlank()) {
            editTelefone.error = "Por favor introduza o seu número de telefone"
            editTelefone.requestFocus()
        }
        if (email.isBlank()) {
            editEmail.error = "Por favor introduza o seu e-mail"
            editEmail.requestFocus()
        }
        if (altura.isBlank()) {
            editAltura.error = "Por favor introduza a sua altura"
            editAltura.requestFocus()
        }

        if (peso.isBlank()) {
            editPeso.error = "Por favor introduza o seu peso"
            editPeso.requestFocus()


        return
    }


        val intent= Intent(this, MostrarDados::class.java)
        intent.putExtra(EXTRA_NOME, nome)
        intent.putExtra(EXTRA_TELEFONE, telefone)
        intent.putExtra(EXTRA_EMAIL, email)
        intent.putExtra(EXTRA_ALTURA, altura)
        intent.putExtra(EXTRA_PESO,peso)

        startActivity(intent)

    }
}


