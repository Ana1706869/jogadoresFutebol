package pt.ipg.advinha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    private val random = Random()
    private var numeroAdivinhar = 0
    private var tentativas = 0
    private var jogos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        novoJogo()

        val buttonAdivinhar = findViewById<Button>(R.id.buttonAdivinhar)
        buttonAdivinhar.setOnClickListener { adivinha() }
    }

    private fun adivinha() {
        val editTextPalpite = findViewById<EditText>(R.id.editTextPalpite)
        val palpite = editTextPalpite.text.toString().toIntOrNull()

        if (palpite == null) {
            editTextPalpite.error = getString(R.string.numero_invalido)
            return
        }

        if (palpite !in 1..10) {
            editTextPalpite.error = getString(R.string.numero_fora_intervalo)
            return
        }

        tentativas++
        atualizaTentativas()
        verificaAcertou(palpite)
    }

    private fun atualizaTentativas() {
        val textViewTentativas = findViewById<TextView>(R.id.textViewTentativas)
        textViewTentativas.text = tentativas.toString()
    }

    private fun verificaAcertou(palpite: Int) {
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        if (palpite == numeroAdivinhar) {
            textViewResultado.text = getString(R.string.acertou)
        } else if (numeroAdivinhar > palpite) {
            textViewResultado.text = getString(R.string.numero_maior)
        } else {
            textViewResultado.text = getString(R.string.numero_menor)
        }
    }

    private fun novoJogo() {
        numeroAdivinhar = random.nextInt(10) + 1

        tentativas = 0
        atualizaTentativas()

        jogos++
        atualizaJogos()
    }

    private fun atualizaJogos() {
        val textViewJogos = findViewById<TextView>(R.id.textViewJogos)
        textViewJogos.text = jogos.toString()
    }
}