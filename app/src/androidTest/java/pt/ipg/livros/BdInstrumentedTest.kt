package pt.ipg.livros

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

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
        getAppContext().deleteDatabase(BdLivrosOpenHelper.NOME_BASE_DADOS)
    }

    @Test
    fun consegueAbrirBaseDados() {
        val openHelper = BdLivrosOpenHelper(getAppContext())
        val bd = openHelper.readableDatabase
        assert(bd.isOpen)
    }

    private fun getWritableDatabase(): SQLiteDatabase {
        val openHelper = BdLivrosOpenHelper(getAppContext())
        return openHelper.writableDatabase
    }

    @Test
    fun consegueInserirCategorias() {
        val bd = getWritableDatabase()

        val categoria = Categoria("Drama")
        insereCategoria(bd, categoria)
    }

    private fun insereCategoria(
        bd: SQLiteDatabase,
        categoria: Categoria
    ) {
        categoria.id = TabelaCategorias(bd).insere(categoria.toContentValues())
        assertNotEquals(-1, categoria.id)
    }

    @Test
    fun consegueInserirLivros() {
        val bd = getWritableDatabase()

        val categoria = Categoria("Humor")
        insereCategoria(bd, categoria)

        val livro1 = Livro("O Lixo na Minha Cabeça", categoria.id)
        insereLivro(bd, livro1)

        val livro2 = Livro("Novíssimas crónicas da boca do inferno", categoria.id, "9789896711788")
        insereLivro(bd, livro2)
    }

    private fun insereLivro(bd: SQLiteDatabase, livro: Livro) {
        livro.id = TabelaLivros(bd).insere(livro.toContentValues())
        assertNotEquals(-1, livro.id)
    }

}