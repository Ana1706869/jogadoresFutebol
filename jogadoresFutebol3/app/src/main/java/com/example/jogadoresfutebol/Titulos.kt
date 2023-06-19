package com.example.jogadoresfutebol

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns

data class Titulos(
    var id:Long=-1,
    var nome:String,
    var campeonatosNacionais: Int=-1,
    var tacasPortugal: Int= -1,
    var tacasLiga: Int=-1,
    var supertacas:Int=-1,
    var campeonatosContinentaisSelecoes:Int=-1,
    var campeonatosMundoSelecoes:Int=-1
)
    : java.io.Serializable{
    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaNTitulos.NOME,nome)
        valores.put(TabelaNTitulos.CAMPEONATOS_NACIONAIS, campeonatosNacionais)
        valores.put(TabelaNTitulos.TACAS_PORTUGAL,tacasPortugal)
        valores.put(TabelaNTitulos.TACAS_LIGA,tacasLiga)
        valores.put(TabelaNTitulos.SUPERTACAS, supertacas)
        valores.put(TabelaNTitulos.CAMPEONATOS_CONTINENTAIS_SELECOES,campeonatosContinentaisSelecoes)
        valores.put(TabelaNTitulos.CAMPEONATOS_MUNDO_SELECOES, campeonatosMundoSelecoes)

        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor) : Titulos {
            val posId = cursor.getColumnIndex(BaseColumns._ID)
            val posNome = cursor.getColumnIndex(TabelaNTitulos.NOME)
            val posCampeonatosNacionais=cursor.getColumnIndex(TabelaNTitulos.CAMPEONATOS_NACIONAIS)
            val posTacasPortugal=cursor.getColumnIndex(TabelaNTitulos.TACAS_PORTUGAL)
            val posTacasLiga=cursor.getColumnIndex(TabelaNTitulos.TACAS_LIGA)
            val posSupertacas=cursor.getColumnIndex(TabelaNTitulos.SUPERTACAS)
            val posCampeonatosContinentais=cursor.getColumnIndex(TabelaNTitulos.CAMPEONATOS_CONTINENTAIS_SELECOES)
            val posCampeonatosMundo=cursor.getColumnIndex(TabelaNTitulos.CAMPEONATOS_MUNDO_SELECOES)


            val id = cursor.getLong(posId)
            val nome = cursor.getString(posNome)
            val campeonatosNacionais=cursor.getInt(posCampeonatosNacionais)
            val tacasPortugal=cursor.getInt(posTacasPortugal)
            val tacasLiga=cursor.getInt(posTacasLiga)
            val supertacas=cursor.getInt(posSupertacas)
            val campeonatosContinentaisSelecoes=cursor.getInt(posCampeonatosContinentais)
            val campeonatosMundoSelecoes=cursor.getInt(posCampeonatosMundo)


            return Titulos( id, nome, campeonatosNacionais, tacasPortugal, tacasLiga, supertacas, campeonatosContinentaisSelecoes, campeonatosMundoSelecoes)
        }
    }
}

