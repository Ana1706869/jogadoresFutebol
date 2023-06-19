package com.example.jogadoresfutebol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.jogadoresfutebol.databinding.FragmentPesquisarBinding

class PesquisarFragment : Fragment() {
    private var jogador: Jogadores? = null
    private var _binding: FragmentPesquisarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPesquisarBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val activity = activity as MainActivity
        activity.fragment = this
        activity.idMenuAtual = R.menu.menu_pesquisar


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun processaOpcaoMenu(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_pesquisar -> {
                pesquisar()
                true
            }
            R.id.action_cancelar -> {
                voltaMenuPrincipal()
                true
            }
            else -> false
        }
    }

    private fun voltaMenuPrincipal() {
        findNavController().navigate(R.id.action_pesquisarFragment_to_menuPrincipalFragment)
    }

    private fun pesquisar() {
        val jogadorPesquisar = binding.editTextJogadorPesquisar.text.toString()



        if (jogadorPesquisar == jogador?.nome ?: "") {
            Toast.makeText(requireContext(), getString(R.string.aguardar), Toast.LENGTH_SHORT)
                .show()
            findNavController().navigate(R.id.action_pesquisarFragment_to_mostraDadosJogadoresFragment2)
        } else {
            Toast.makeText(
                requireContext(),
                getString(R.string.Nenhum_resultado),
                Toast.LENGTH_SHORT
            )
                .show()
        }
    }
}


