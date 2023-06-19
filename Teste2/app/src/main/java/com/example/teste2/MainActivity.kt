package com.example.teste2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView

private lateinit var resultado: TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultado = findViewById<TextView>(R.id.textView2)
        val buttonConverter = findViewById<Button>(R.id.button)
        buttonConverter.setOnClickListener {
            converter()

        }
    }

    private fun converter() {
        val selectPhoneNumbers = findViewById<RadioGroup>(R.id.radioGroup)
        val checked = selectPhoneNumbers.checkedRadioButtonId
        val phoneNumber=when (checked){
           R.id.radioUSD->"914640762"


          R.id.radioButtonEuro->"914811162"


           else->"917071858"



       }
        resultado.text=phoneNumber

       }
    }



