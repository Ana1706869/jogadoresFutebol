package com.example.jogadoresfutebol

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaJogadores(db: SQLiteDatabase) : TabelaBD(db, NOME_TABELA) {
    override fun cria() {
        db.execSQL("CREATE TABLE $NOME_TABELA ($CHAVE_TABELA, $CAMPO_FK_NOME TEXT NOT NULL, $DATA_NASCIMENTO INTEGER NOT NULL, $CLUBE TEXT NOT NULL, $NACIONALIDADE TEXT NOT NULL, $POSICAO TEXT NOT NULL, $ALTURA DOUBLE NOT NULL, $PESO INTEGER NOT NULL, $N_INTERNACIONALIZACOES INTEGER NOT NULL, $GOLOS INTEGER NOT NULL, FOREIGN KEY ($CAMPO_FK_NOME) REFERENCES ${TabelaNTitulos.NOME_TABELA}(${BaseColumns._ID}) ON DELETE RESTRICT)")
    }

    companion object {
        const val NOME_TABELA = "Jogadores"
        const val CAMPO_FK_NOME = "Nome"
        const val DATA_NASCIMENTO="DataNascimento"
        const val CLUBE="Clube"
        const val NACIONALIDADE="Nacionalidade"
        const val POSICAO="Posição"
        const val ALTURA="Altura"
        const val PESO="Peso"
        const val N_INTERNACIONALIZACOES="NumeroInternacionalizações"
        const val GOLOS="Golos"


        val CAMPOS = arrayOf(BaseColumns._ID, CAMPO_FK_NOME, DATA_NASCIMENTO, CLUBE, NACIONALIDADE, POSICAO, ALTURA, PESO, N_INTERNACIONALIZACOES, GOLOS)
    }
}

