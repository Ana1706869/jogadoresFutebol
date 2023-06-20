package com.example.jogadoresfutebol

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.jogadoresfutebol.databinding.FragmentEditarTituloBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditarTituloFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditarTitulosFragment : Fragment() {
    private var titulo: Titulos?= null
    private var _binding2: FragmentEditarTituloBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding2 get() = _binding2!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding2 = FragmentEditarTituloBinding.inflate(inflater, container, false)
        return binding2.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity as MainActivity
        activity.fragment = this
        activity.idMenuAtual = R.menu.menu_guardar_cancelar

        val titulo= EditarTitulosFragmentArgs.fromBundle(requireArguments()).titulos

        if (titulo!= null) {
            binding2.editTextId3.setText(titulo.id.toString())
            binding2.editTextNome3.setText(titulo.nome)
            binding2.editTextCampeonatosNacionais2.setText(titulo.campeonatosNacionais.toString())
            binding2.editTextTacasPortugal2.setText(titulo.tacasPortugal.toString())
            binding2.editTextTacasLiga2.setText(titulo.tacasLiga.toString())
            binding2.editTextSupertaAs2.setText(titulo.supertacas.toString())
            binding2.editTextCampeonatosContinentaisSelecoes2.setText(titulo.campeonatosContinentaisSelecoes.toString())
            binding2.editTextCampeonatosMundoSelecoes2.setText(titulo.campeonatosMundoSelecoes.toString())

        }


        this.titulo = titulo
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding2 = null
    }

    fun processaOpcaoMenu(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_guardar -> {
                guardar()
                true
            }
            R.id.action_cancelar -> {
                voltaListaTitulos()
                true
            }
            else -> false
        }
    }

    private fun voltaListaTitulos() {
        findNavController().navigate(R.id.action_editarTitulosFragment_to_listaTitulosFragment)
    }

    private fun guardar() {
        val editTextId = binding2.editTextId3.text.toString()
        if (editTextId.isBlank()) {
            binding2.editTextId3.error = getString(R.string.id_obrigatorio)
            binding2.editTextId3.requestFocus()
            return
        }
        val id=editTextId.toLong()

        val nome = binding2.editTextNome3.text.toString()
        if (nome.isBlank()) {
            binding2.editTextNome3.error = getString(R.string.nome_obrigatorio)
            binding2.editTextNome3.requestFocus()
            return
        }

        val editTextCampeonatosNacionais = binding2.editTextCampeonatosNacionais2.text.toString()
        if (editTextCampeonatosNacionais.isBlank()) {
            binding2.editTextCampeonatosNacionais2.error=getString(R.string.campeonatos_obrigatorios)
            binding2.editTextCampeonatosNacionais2.requestFocus()
            return
        }
        val campeonatosNacionais =editTextCampeonatosNacionais.toInt()

        val editTextTacasPortugal = binding2.editTextTacasPortugal2.text.toString()
        if (editTextTacasPortugal.isBlank()) {
            binding2.editTextTacasPortugal2.error = getString(R.string.tacas_portugal_obrigatorias)
            binding2.editTextTacasPortugal2.requestFocus()
            return
        }
        val tacasPortugal=editTextTacasPortugal.toInt()

        val editTextTacasLiga = binding2.editTextTacasLiga2.text.toString()
        if (editTextTacasLiga.isBlank()) {
            binding2.editTextTacasLiga2.error = getString(R.string.tacas_liga_obrigatorias)
            binding2.editTextTacasLiga2.requestFocus()
            return
        }
        val tacasLiga=editTextTacasLiga.toInt()

        val editTextSupertacas = binding2.editTextSupertaAs2.text.toString()
        if (editTextSupertacas.isBlank()) {
            binding2.editTextSupertaAs2.error = getString(R.string.supertacas_obrigatorias)
            binding2.editTextSupertaAs2.requestFocus()
            return
        }
        val supertacas=editTextSupertacas.toInt()

        val editCampeonatosContinentaisSelecoes = binding2.editTextCampeonatosContinentaisSelecoes2.text.toString()
        if (editCampeonatosContinentaisSelecoes.isBlank()) {
            binding2.editTextCampeonatosContinentaisSelecoes2.error = getString(R.string.campeonatos_continentais_selecoes_obrigatorios)
            binding2.editTextCampeonatosContinentaisSelecoes2.requestFocus()
            return
        }
        val campeonatosContinentaisSelecoes=editCampeonatosContinentaisSelecoes.toInt()


        val editTextCampeonatosMundoSelecoes= binding2.editTextCampeonatosMundoSelecoes2.text.toString()
        if (editTextCampeonatosMundoSelecoes.isBlank()) {
            binding2.editTextCampeonatosMundoSelecoes2.error = getString(R.string.campeonatos_mundo_conquistados)
            binding2.editTextCampeonatosMundoSelecoes2.requestFocus()
            return
        }
        val campeonatosMundoSelecoes=editTextCampeonatosMundoSelecoes.toInt()



        val titulo = Titulos(
            id,nome, campeonatosNacionais, tacasPortugal, tacasLiga, supertacas, campeonatosContinentaisSelecoes, campeonatosMundoSelecoes)


        val idTitulo = requireActivity().contentResolver.insert(
            JogadoresContentProvider.ENDERECO_TITULOS,
            titulo.toContentValues()
        )

        if (id == null) {
            binding2.editTextNome3.error = getString(R.string.erro_adicionar_titulo)

            return
        }

        Toast.makeText(requireContext(), getString(R.string.titulo_sucesso), Toast.LENGTH_SHORT).show()
        voltaListaTitulos()
    }

    /**
     * Instantiate and return a new Loader for the given ID.
     *
     *
     * This will always be called from the process's main thread.
     *
     * @param id The ID whose loader is to be created.
     * @param args Any arguments supplied by the caller.
     * @return Return a new Loader instance that is ready to start loading.
     */




}