package com.example.jogadoresfutebol

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.jogadoresfutebol.databinding.FragmentEliminarTituloBinding
import com.google.android.material.snackbar.Snackbar

class EliminaTituloFragment : Fragment() {
    private lateinit var titulo: Titulos
    private var _binding: FragmentEliminarTituloBinding?=null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEliminarTituloBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity as MainActivity
        activity.fragment = this
        activity.idMenuAtual = R.menu.menu_eliminar

        titulo = EliminaTituloFragmentArgs.fromBundle(requireArguments()).titulo



        binding.textViewNome4.text = titulo.nome
        binding.textViewCampeonatosNacionais3.text = titulo.campeonatosNacionais.toString()
        binding.textViewTacasPortugal3.text=titulo.tacasPortugal.toString()
        binding.textViewTacasLiga3.text=titulo.tacasLiga.toString()
        binding.textViewSupertacas3.text=titulo.supertacas.toString()
        binding.textViewCampeonatosContinentaisSelecoes3.text=titulo.campeonatosContinentaisSelecoes.toString()
        binding.textViewCampeonatosMundoSelecoes3.text=titulo.campeonatosMundoSelecoes.toString()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun processaOpcaoMenu(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_eliminar -> {
                eliminar()
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
        findNavController().navigate(R.id.action_eliminaTituloFragment2_to_listaTitulosFragment)
    }

    private fun eliminar() {
        val enderecoTitulos = Uri.withAppendedPath(JogadoresContentProvider.ENDERECO_TITULOS, titulo.id.toString())
        val numTitulosEliminados = requireActivity().contentResolver.delete(enderecoTitulos, null, null)

        if (numTitulosEliminados == 1) {
            Toast.makeText(requireContext(), getString(R.string.titulo_eliminado), Toast.LENGTH_LONG).show()
            voltaListaTitulos()
        } else {
            Snackbar.make(binding.textViewNome4, getString(R.string.erro_eliminar_titulo), Snackbar.LENGTH_INDEFINITE)
        }
    }
}

