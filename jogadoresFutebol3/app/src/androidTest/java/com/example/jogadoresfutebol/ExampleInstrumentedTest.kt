package com.example.jogadoresfutebol

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.util.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)

        class BdInstrumentedTest {
            private fun getAppContext(): Context =
                InstrumentationRegistry.getInstrumentation().targetContext

            @Before
            fun apagaBaseDados() {
                //getAppContext().deleteDatabase(BdJogadoresOpenHelper.NOME_BASE_DADOS)
            }

            @Test
            fun consegueAbrirBaseDados() {
                val openHelper = BdJogadoresOpenHelper(getAppContext())
                val bd = openHelper.readableDatabase
                assert(bd.isOpen)
            }

            private fun getWritableDatabase(): SQLiteDatabase {
                val openHelper = BdJogadoresOpenHelper(getAppContext())
                return openHelper.writableDatabase
            }

            @Test
            fun consegueInserirTitulos() {
                val bd = getWritableDatabase()

                val nTitulos1 = Titulos(1, "Sebástian Coates", 1, 3, 3, 2, 0, 0)
                insereTitulos(bd, nTitulos1)

                val nTitulos2 = Titulos(2, "Gonçalo Ramos", 0, 0, 0, 0, 0, 0)
                insereTitulos(bd, nTitulos2)

                val nTitulos3 = Titulos(3, "Medhi Taremi", 1, 1, 1, 1, 0, 0)
                insereTitulos(bd, nTitulos3)

                val nTitulos4 = Titulos(4, "Pizzi", 4, 3, 0, 2, 0, 0)
                insereTitulos(bd, nTitulos4)

                val nTitulos5 = Titulos(5, "Fran Navarro", 0, 0, 0, 0, 0, 0)
                insereTitulos(bd, nTitulos5)

                val nTitulos6 = Titulos(6, "André André", 0, 1, 0, 0, 0, 0)
                insereTitulos(bd, nTitulos6)

                val nTitulos7 = Titulos(7, "Gonçalo Rodrigues", 0, 0, 0, 0, 0, 0)
                insereTitulos(bd, nTitulos7)

                val nTitulos8 = Titulos(8, "Kento Misao", 0, 0, 0, 0, 1, 0)
                insereTitulos(bd, nTitulos8)

                val nTitulos9 = Titulos(9, "Alexander Bah", 0, 0, 0, 0, 0, 0)
                insereTitulos(bd, nTitulos9)

                val nTitulos10 = Titulos(10, "Pepe", 6, 4, 1, 3, 1, 0)
                insereTitulos(bd, nTitulos10)

                val nTitulos11 = Titulos(11, "Pedro Gonçalves", 1, 0, 2, 1, 0, 0)
                insereTitulos(bd, nTitulos11)

                val nTitulos12 = Titulos(12, "Yusupha Nije", 0, 0, 0, 0, 0, 0)
                insereTitulos(bd, nTitulos12)

                val nTitulos13 = Titulos(13, "Vitorino Antunes", 1, 0, 1, 0, 0, 0)
                insereTitulos(bd, nTitulos13)

                val nTitulos14 = Titulos(14, "Mexer", 0, 0, 0, 0, 0, 0)
                insereTitulos(bd, nTitulos14)

                val nTitulos15 = Titulos(15, "Moralye Sylla", 0, 0, 0, 0, 0, 0)
                insereTitulos(bd, nTitulos15)

                val nTitulos16 = Titulos(16, "Matheus Uribe", 2, 2, 1, 2, 0, 0)
                insereTitulos(bd, nTitulos16)

                val nTitulos17 = Titulos(17, "Gonçalo Inácio", 1, 0, 2, 1, 0, 0)
                insereTitulos(bd, nTitulos17)

                val nTitulos18 = Titulos(18, "Peter Musa", 0, 0, 0, 0, 0, 0)
                insereTitulos(bd, nTitulos18)

                val nTitulos19 = Titulos(19, "Pablo Moreno", 0, 0, 0, 0, 0, 0)
                insereTitulos(bd, nTitulos19)

                val nTitulos20 = Titulos(20, "Abel Ruiz", 0, 0, 0, 0, 0, 0)
                insereTitulos(bd, nTitulos20)
            }

            private fun insereTitulos(
                bd: SQLiteDatabase,
                titulos: Titulos
            ) {
                titulos.id = TabelaNTitulos(bd).insere(titulos.toContentValues())
                assertNotEquals(-1, titulos.id)
            }

            @Test
            fun consegueInserirJogadores() {
                val bd = getWritableDatabase()

                val dataNascimento1 = Calendar.getInstance()
                dataNascimento1.set(1990, 10, 7)

                val dataNascimento2 = Calendar.getInstance()
                dataNascimento2.set(2001, 3, 17)

                val dataNascimento3 = Calendar.getInstance()
                dataNascimento3.set(1992, 7, 22)

                val dataNascimento4 = Calendar.getInstance()
                dataNascimento4.set(1989, 10, 5)

                val dataNascimento5 = Calendar.getInstance()
                dataNascimento5.set(1998, 4, 14)

                val dataNascimento6 = Calendar.getInstance()
                dataNascimento6.set(1989, 6, 22)

                val dataNascimento7 = Calendar.getInstance()
                dataNascimento7.set(1997, 7, 18)

                val dataNascimento8 = Calendar.getInstance()
                dataNascimento8.set(1996, 4, 16)

                val dataNascimento9 = Calendar.getInstance()
                dataNascimento9.set(1991, 8, 5)

                val dataNascimento10 = Calendar.getInstance()
                dataNascimento10.set(1983, 2, 26)

                val dataNascimento11 = Calendar.getInstance()
                dataNascimento11.set(1998, 6, 28)


                val dataNascimento12 = Calendar.getInstance()
                dataNascimento12.set(1987, 12, 9)

                val dataNascimento13 = Calendar.getInstance()
                dataNascimento13.set(1988, 9, 8)

                val dataNascimento14 = Calendar.getInstance()
                dataNascimento14.set(1988, 7, 27)

                val dataNascimento15 = Calendar.getInstance()
                dataNascimento15.set(1989, 8, 5)

                val dataNascimento16 = Calendar.getInstance()
                dataNascimento16.set(2001, 8, 20)

                val dataNascimento17 = Calendar.getInstance()
                dataNascimento17.set(1998, 11, 5)

                val dataNascimento18 = Calendar.getInstance()
                dataNascimento18.set(2002, 5, 3)

                val dataNascimento19 = Calendar.getInstance()
                dataNascimento19.set(1998, 8, 3)


                val jogador1 = Jogadores(
                    1,
                    "Sebástian Coates",
                    dataNascimento1,
                    "Sporting",
                    "Uruguaio",
                    "Defesa",
                    1.96,
                    87,
                    55,
                    65
                )
                insereJogador(bd, jogador1)

                val jogador2 = Jogadores(
                    2,
                    "Gonçalo Ramos",
                    dataNascimento2,
                    "Benfica",
                    "Português",
                    "Avançado",
                    1.80,
                    76,
                    4,
                    54
                )
                insereJogador(bd, jogador2)

                val jogador3 = Jogadores(
                    3,
                    "Medhi Taremi",
                    dataNascimento3,
                    "FC Porto",
                    "Iraniano",
                    "Avançado",
                    1.87,
                    79,
                    59,
                    100
                )
                insereJogador(bd, jogador3)

                val jogador4 = Jogadores(
                    4,
                    "Pizzi",
                    dataNascimento4,
                    "Sp. Braga",
                    "Português",
                    "Médio",
                    1.78,
                    73,
                    30,
                    40
                )
                insereJogador(bd, jogador4)

                val jogador5 = Jogadores(
                    5,
                    "Fran Navarro",
                    dataNascimento5,
                    "Gil Vicente",
                    "Espanhol",
                    "Avançado",
                    1.79,
                    5,
                    0,
                    43
                )
                insereJogador(bd, jogador5)

                val jogador6 = Jogadores(
                    6,
                    "André André",
                    dataNascimento6,
                    "Vitória de Guimarães",
                    "Português",
                    "Médio",
                    1.75,
                    69,
                    0,
                    4
                )
                insereJogador(bd, jogador6)

                val jogador7 = Jogadores(
                    7,
                    "Gonçalo Rodrigues",
                    dataNascimento7,
                    "Rio Ave",
                    "Portuguesa",
                    "Médio",
                    1.65,
                    56,
                    0,
                    5
                )
                insereJogador(bd, jogador7)

                val jogador8 = Jogadores(
                    8,
                    "Kento Misao",
                    dataNascimento8,
                    "Santa Clara",
                    "Japonês",
                    "Médio",
                    1.81,
                    76,
                    6,
                    0
                )
                insereJogador(bd, jogador8)

                val jogador9 = Jogadores(
                    9,
                    "Alexander Bah",
                    dataNascimento9,
                    "Benfica",
                    "Dinamarquês",
                    "Defesa",
                    1.95,
                    85,
                    8,
                    1
                )
                insereJogador(bd, jogador9)

                val jogador10 = Jogadores(
                    10,
                    "Pepe",
                    dataNascimento10,
                    "FC Porto",
                    "Português",
                    "Defesa",
                    1.89,
                    83,
                    390,
                    35
                )
                insereJogador(bd, jogador10)

                val jogador11 = Jogadores(
                    11,
                    "Pedro Gonçalves",
                    dataNascimento11,
                    "Sporting",
                    "Português",
                    "Avançado",
                    1.81,
                    77,
                    1,
                    45
                )
                insereJogador(bd, jogador11)


                val jogador12 = Jogadores(
                    12,
                    "Vitorino Antunes",
                    dataNascimento12,
                    "Paços de Ferreira",
                    "Português",
                    "Defesa",
                    1.85,
                    81,
                    12,
                    0
                )
                insereJogador(bd, jogador12)

                val jogador13 = Jogadores(
                    13,
                    "Mexer",
                    dataNascimento13,
                    "Estoril",
                    "Moçambicano",
                    "Defesa",
                    1.87,
                    79,
                    58,
                    3
                )
                insereJogador(bd, jogador13)

                val jogador14 = Jogadores(
                    14,
                    "Moralye Sylla",
                    dataNascimento14,
                    "Arouca",
                    "Guineense",
                    "Médio",
                    1.70,
                    65,
                    8,
                    0
                )
                insereJogador(bd, jogador14)

                val jogador15 = Jogadores(
                    15,
                    "Matheus Uribe",
                    dataNascimento15,
                    "FC Porto",
                    "Colombiano",
                    "Médio",
                    1.78,
                    75,
                    20,
                    15
                )
                insereJogador(bd, jogador15)

                val jogador16 = Jogadores(
                    16,
                    "Gonçalo Inácio",
                    dataNascimento16,
                    "Sporting",
                    "Português",
                    "Defesa",
                    1.81,
                    76,
                    2,
                    10
                )
                insereJogador(bd, jogador16)

                val jogador17 = Jogadores(
                    17,
                    "Peter Musa",
                    dataNascimento17,
                    "Benfica",
                    "Croata",
                    "Avançado",
                    1.93,
                    83,
                    1,
                    23
                )
                insereJogador(bd, jogador17)

                val jogador18 = Jogadores(
                    18,
                    "Pablo Moreno",
                    dataNascimento18,
                    "Marítimo",
                    "Espanhol",
                    "Avançado",
                    1.80,
                    75,
                    0,
                    0
                )
                insereJogador(bd, jogador18)

                val jogador19 = Jogadores(
                    19,
                    "Abel Ruiz",
                    dataNascimento19,
                    "Sp.Braga",
                    "Espanhol",
                    "Avançado",
                    1.76,
                    68,
                    3,
                    11
                )
                insereJogador(bd, jogador19)


            }

            private fun insereJogador(bd: SQLiteDatabase, jogador: Jogadores) {
                jogador.id = TabelaJogadores(bd).insere(jogador.toContentValues())
                assertNotEquals(-1, jogador.id)
            }

            @Test
            fun consegueLerTitulos() {
                val bd = getWritableDatabase()

                val titulos20 = Titulos(20, "Matheus Reis", 1, 0, 2, 1, 0, 0)
                insereTitulos(bd, titulos20)


                val tabelaTitulos = TabelaNTitulos(bd)


                val cursor = tabelaTitulos.consulta(
                    TabelaNTitulos.CAMPOS,
                    "${BaseColumns._ID}=?",
                    arrayOf(titulos20.id.toString()),
                    null,
                    null,
                    null
                )

                assert(cursor.moveToNext())

                val titulosBD = Titulos.fromCursor(cursor)

                assertEquals(titulos20, titulosBD)


                val cursorTodosTitulos = tabelaTitulos.consulta(
                    TabelaNTitulos.CAMPOS,
                    null, null, null, null,
                    TabelaNTitulos.NOME
                )

                assert(cursorTodosTitulos.count >= 1)
            }

            @Test
            fun consegueLerJogadores() {
                val bd = getWritableDatabase()

                val titulos21 = Titulos(21, "Nuno Santos", 1, 0, 2, 1, 0, 0)
                insereTitulos(bd, titulos21)

                val dataNascimento21 = Calendar.getInstance()
                dataNascimento21.set(1995, 2, 13)

                val jogador21 = Jogadores(
                    titulos21.id,
                    titulos21.nome,
                    dataNascimento21,
                    "Sporting",
                    "Português",
                    "Avançado",
                    1.76,
                    68,
                    0,
                    53
                )
                insereJogador(bd, jogador21)


                val tabelaJogadores = TabelaJogadores(bd)

                val cursor = tabelaJogadores.consulta(
                    TabelaJogadores.CAMPOS,
                    "${BaseColumns._ID}=?",
                    arrayOf(jogador21.id.toString()),
                    null,
                    null,
                    null
                )

                assert(cursor.moveToNext())

                val jogadorBD = Jogadores.fromCursor(cursor)

                assertEquals(jogador21, jogadorBD)

                val cursorTodosJogadores = tabelaJogadores.consulta(
                    TabelaJogadores.CAMPOS,
                    null, null, null, null,
                    TabelaJogadores.CAMPO_FK_NOME
                )

                assert(cursorTodosJogadores.count >= 1)


            }

            @Test
            fun consegueAlterarTitulos() {
                val bd = getWritableDatabase()

                val titulos22 = Titulos(22, "António Adán", 1, 0, 2, 1, 0, 0)
                insereTitulos(bd, titulos22)


                titulos22.nome = "Daniel Bragança"
                titulos22.campeonatosNacionais = 1
                titulos22.tacasPortugal = 0
                titulos22.tacasLiga = 2
                titulos22.supertacas = 1
                titulos22.campeonatosContinentaisSelecoes = 0
                titulos22.campeonatosMundoSelecoes = 0

                val registosAlterados = TabelaNTitulos(bd).altera(
                    titulos22.toContentValues(),
                    "${BaseColumns._ID}=?",
                    arrayOf(titulos22.id.toString())
                )

                assertEquals(1, registosAlterados)


            }

            @Test
            fun consegueAlterarJogadores() {
                val bd = getWritableDatabase()

                val titulos23 = Titulos(23, "Marcus Edwards", 0, 0, 1, 0, 0, 0)
                insereTitulos(bd, titulos23)

                val dataNascimento23 = Calendar.getInstance()
                dataNascimento23.set(1998, 4, 20)

                val novaDataNascimento = Calendar.getInstance()
                novaDataNascimento.set(1994, 9, 25)

                val jogador23 = Jogadores(
                    titulos23.id,
                    titulos23.nome,
                    dataNascimento23,
                    "Sporting",
                    "Inglês",
                    "Avançado",
                    1.77,
                    70,
                    0,
                    25
                )
                insereJogador(bd, jogador23)



                jogador23.nome = "Ricardo Horta"
                jogador23.dataNascimento = novaDataNascimento
                jogador23.clube = "Sp. Braga"
                jogador23.nacionalidade = "Português"
                jogador23.posicao = "Médio"
                jogador23.altura = 1.78
                jogador23.peso = 74
                jogador23.internacionalizacoes = 2
                jogador23.golos = 31

                val registosAlterados = TabelaJogadores(bd).altera(
                    jogador23.toContentValues(),
                    "${BaseColumns._ID}=?",
                    arrayOf(jogador23.id.toString())
                )

                assertEquals(1, registosAlterados)


            }

            @Test
            fun consegueApagarTitulos() {
                val bd = getWritableDatabase()

                val titulos24 = Titulos(24, "Francisco Trincão", 2, 2, 1, 1, 0, 0)
                insereTitulos(bd, titulos24)

                val registosEliminados = TabelaNTitulos(bd).elimina(
                    "${BaseColumns._ID}=?",
                    arrayOf(titulos24.id.toString())
                )

                assertEquals(1, registosEliminados)


            }

            @Test
            fun consegueApagarLivros() {
                val bd = getWritableDatabase()

                val titulos25 = Titulos(25, "Dário Essugo", 1, 0, 1, 1, 0, 0)
                insereTitulos(bd, titulos25)

                val dataNascimento25 = Calendar.getInstance()
                dataNascimento25.set(2005, 3, 14)

                val jogador25 = Jogadores(
                    titulos25.id,
                    titulos25.nome,
                    dataNascimento25,
                    "Sporting",
                    "Português",
                    "Médio",
                    1.70,
                    71,
                    0,
                    0
                )
                insereJogador(bd, jogador25)

                val registosEliminados = TabelaJogadores(bd).elimina(
                    "${BaseColumns._ID}=?",
                    arrayOf(jogador25.id.toString())
                )

                assertEquals(1, registosEliminados)


            }
        }
