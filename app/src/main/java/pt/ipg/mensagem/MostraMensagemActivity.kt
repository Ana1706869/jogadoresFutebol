package pt.ipg.mensagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MostraMensagemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostra_mensagem)

        val mensagem = intent.getStringExtra(EXTRA_MENSAGEM)

        val textViewMensagem = findViewById<TextView>(R.id.textViewMensagem)
        textViewMensagem.text = mensagem
    }
}