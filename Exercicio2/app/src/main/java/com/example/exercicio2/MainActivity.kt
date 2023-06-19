package com.example.exercicio2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text
import java.lang.Math.random
import java.util.Random
import kotlin.random.Random.Default.nextInt

private var tentativas=0
private var jogos=0


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        novoJogo()



        val adivinhar = findViewById<Button>(R.id.buttonAdivinhar)
        adivinhar.setOnClickListener {

                val editNumero=findViewById<TextInputEditText>(R.id.TextInputEditNumero)
                val numero=editNumero.text.toString()
                val numeroIntroduzido=numero.toIntOrNull()

                if(numeroIntroduzido !in 1..10){
                    editNumero.error="Número inválido! O número introduzido tem de estar compreendido entre 1 e 10"
                }
            else {
                    val random=Random()
                    val numeroAleatorio= random.nextInt(10)+1



                    val resultado=findViewById<TextView>(R.id.textViewResultado)
                    if (numeroIntroduzido != null) {
                        if (numeroIntroduzido > numeroAleatorio){
                            resultado.text="O número que eu estou a pensar é menor que esse número"
                            atualizarTentativas()
                            tentativas++
                        }
                        if(numeroIntroduzido<numeroAleatorio){
                            resultado.text="O número que eu estou a pensar é maior que esse número"
                            atualizarTentativas()
                            tentativas++
                        }
                        else{
                            resultado.text="Parabéns! Acertou"
                        }


                    }
                }


                }



        }

    private fun atualizarTentativas(){

        val editTentativas=findViewById<TextView>(R.id.textViewTentativas)
         editTentativas.text=tentativas.toString()

    }
    private fun novoJogo() {
        val random=Random()
       val numeroAleatorio = random.nextInt(10) + 1

        tentativas = 0
        atualizarTentativas()

        jogos++
        atualizaJogos()
    }


    private fun atualizaJogos() {
        val textViewJogos = findViewById<TextView>(R.id.textViewJogos)
        textViewJogos.text = jogos.toString()

    }
}






















