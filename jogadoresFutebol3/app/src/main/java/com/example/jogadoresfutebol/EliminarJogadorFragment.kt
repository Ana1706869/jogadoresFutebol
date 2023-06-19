package com.example.jogadoresfutebol

import android.net.Uri
import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.jogadoresfutebol.databinding.FragmentEliminarJogadorBinding
import com.google.android.material.snackbar.Snackbar

class EliminarJogadorFragment : Fragment() {
    private lateinit var jogador: Jogadores
    private var _binding: FragmentEliminarJogadorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEliminarJogadorBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity as MainActivity
        activity.fragment = this
        activity.idMenuAtual = R.menu.menu_eliminar

        jogador = EliminarJogadorFragmentArgs.fromBundle(requireArguments()).jogador



        binding.textViewNome.text = jogador.nome
        if (jogador.dataNascimento != null) {
            binding.textViewDataNascimento.text = DateFormat.format("yyyy-MM-dd", jogador.dataNascimento)
        }
        binding.textViewClube.text = jogador.clube
        binding.textViewNacionalidade.text=jogador.nacionalidade
        binding.textViewPosicao.text=jogador.posicao
        binding.textViewAltura.text=jogador.altura.toString()
        binding.textViewPeso.text=jogador.peso.toString()
        binding.textViewInternacionalizacoes.text=jogador.internacionalizacoes.toString()
        binding.textViewGolos.text=jogador.golos.toString()

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
                voltaListaJogadores()
                true
            }
            else -> false
        }
    }

    private fun voltaListaJogadores() {
        findNavController().navigate(R.id.action_eliminarJogadorFragment_to_listaJogadoresFragment)
    }

    private fun eliminar() {
        val enderecoJogadores = Uri.withAppendedPath(JogadoresContentProvider.ENDERECO_JOGADORES, jogador.id.toString())
        val numJogadoresEliminados = requireActivity().contentResolver.delete(enderecoJogadores, null, null)


        if (numJogadoresEliminados == 1) {
            Toast.makeText(requireContext(), getString(R.string.jogador_eliminado_com_sucesso), Toast.LENGTH_LONG).show()
            voltaListaJogadores()
        } else {
            Snackbar.make(binding.textViewNome, getString(R.string.erro_eliminar_jogador), Snackbar.LENGTH_INDEFINITE)
        }
    }
}

