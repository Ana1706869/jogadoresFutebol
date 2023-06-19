package com.example.jogadoresfutebol

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaNTitulos(db: SQLiteDatabase) : TabelaBD(db, NOME_TABELA) {
    override fun cria() {
        db.execSQL("CREATE TABLE $NOME_TABELA ($CHAVE_TABELA, $NOME TEXT NOT NULL, $CAMPEONATOS_NACIONAIS INTEGER NOT NULL, $TACAS_PORTUGAL INTEGER NOT NULL, $TACAS_LIGA INTEGER NOT NULL, $SUPERTACAS INTEGER NOT NULL, $CAMPEONATOS_CONTINENTAIS_SELECOES INTEGER NOT NULL, $CAMPEONATOS_MUNDO_SELECOES INTEGER NOT NULL)")

    }

    companion object {
        const val NOME_TABELA = "NumeroTítulos"
        const val NOME = "Nome"
        const val CAMPEONATOS_NACIONAIS="CampeonatosNacionais"
        const val TACAS_PORTUGAL="TacasPortugal"
        const val TACAS_LIGA="TacasLiga"
        const val SUPERTACAS="Supertacas"
        const val CAMPEONATOS_CONTINENTAIS_SELECOES="CampeonatosContinentaisSeleçoes"
        const val CAMPEONATOS_MUNDO_SELECOES="CampeonatosMundoSeleções"


        val CAMPOS = arrayOf(BaseColumns._ID, NOME, CAMPEONATOS_NACIONAIS, TACAS_PORTUGAL, TACAS_LIGA, SUPERTACAS, CAMPEONATOS_CONTINENTAIS_SELECOES, CAMPEONATOS_MUNDO_SELECOES)
    }

}
