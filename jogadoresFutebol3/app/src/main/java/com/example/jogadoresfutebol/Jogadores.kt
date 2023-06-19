package com.example.jogadoresfutebol

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns
import java.util.*

data class Jogadores(
var id: Long = -1,
var nome: String,
var dataNascimento: Calendar? = null,
var clube:String,
var nacionalidade:String,
var posicao:String,
var altura:Double=0.0,
var peso:Int=0,
var internacionalizacoes:Int=-1,
var golos:Int=-1

) : java.io.Serializable{
    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaJogadores.CAMPO_FK_NOME, nome)
        valores.put(TabelaJogadores.DATA_NASCIMENTO, dataNascimento?.timeInMillis)
        valores.put(TabelaJogadores.CLUBE, clube)
        valores.put(TabelaJogadores.NACIONALIDADE, nacionalidade)
        valores.put(TabelaJogadores.POSICAO, posicao)
        valores.put (TabelaJogadores.ALTURA, altura)
        valores.put(TabelaJogadores.PESO, peso)
        valores.put (TabelaJogadores. N_INTERNACIONALIZACOES, internacionalizacoes)
        valores.put(TabelaJogadores.GOLOS,golos)

        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor) : Jogadores {
            val posId = cursor.getColumnIndex(BaseColumns._ID)
            val posNome = cursor.getColumnIndex(TabelaJogadores.CAMPO_FK_NOME)
            val posDataNascimento = cursor.getColumnIndex(TabelaJogadores.DATA_NASCIMENTO)
            val posClube = cursor.getColumnIndex(TabelaJogadores.CLUBE)
            val posNacionalidade = cursor.getColumnIndex(TabelaJogadores.NACIONALIDADE)
            val posPosicao=cursor.getColumnIndex(TabelaJogadores.POSICAO)
            val posAltura=cursor.getColumnIndex(TabelaJogadores.ALTURA)
            val posPeso=cursor.getColumnIndex(TabelaJogadores.PESO)
            val posInternacionalizacoes=cursor.getColumnIndex(TabelaJogadores.N_INTERNACIONALIZACOES)
            val posGolos=cursor.getColumnIndex(TabelaJogadores.GOLOS)


            val id = cursor.getLong(posId)
            val nome = cursor.getString(posNome)


            var dataNascimento: Calendar?

            if (cursor.isNull(posDataNascimento)) {
                dataNascimento = null
            } else {
                dataNascimento = Calendar.getInstance()
                dataNascimento.timeInMillis = cursor.getLong(posDataNascimento)
            }

            val clube=cursor.getString(posClube)
            val nacionalidade=cursor.getString(posNacionalidade)
            val posicao=cursor.getString(posPosicao)
            val altura=cursor.getDouble(posAltura)
            val peso=cursor.getInt(posPeso)
            val internacionalizacoes=cursor.getInt(posInternacionalizacoes)
            val golos=cursor.getInt(posGolos)




            return Jogadores(id,nome, dataNascimento, clube, nacionalidade, posicao,altura,peso, internacionalizacoes, golos)
        }
    }
}
