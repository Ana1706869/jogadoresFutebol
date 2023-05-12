package pt.ipg.livros

data class Livro(
    var titulo: String,
    var idCategoria: Int,
    var isbn: String? = null,
    var id: Long = -1
) {
}