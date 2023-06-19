package pt.ipg.mensagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val EXTRA_MENSAGEM = "mensagem"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonEnviar = findViewById<Button>(R.id.buttonEnviar)
        buttonEnviar.setOnClickListener { enviaMensagem() }
    }

    private fun enviaMensagem() {
        val editTextMensagem = findViewById<EditText>(R.id.editTextMensagem)
        val mensagem = editTextMensagem.text.toString()

        if (mensagem.isBlank()) {
            editTextMensagem.error = getString(R.string.mensagem_vazia)
            editTextMensagem.requestFocus()
            return
        }

        val intent = Intent(this, MostraMensagemActivity::class.java)
        intent.putExtra(EXTRA_MENSAGEM, mensagem)

        startActivity(intent)
    }
}