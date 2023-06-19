package com.example.jogadoresfutebol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jogadoresfutebol.databinding.FragmentMostraDadosJogadoresBinding

class MostraDadosJogadoresFragment : Fragment() {
    private var jogador:Jogadores?=null
    private var titulo: Titulos? = null
    private var _binding: FragmentMostraDadosJogadoresBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMostraDadosJogadoresBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity as MainActivity
        activity.fragment = this
        activity.idMenuAtual = R.menu.menu_mostra_jogadores

        val jogador=MostraDadosJogadoresFragmentArgs.fromBundle(requireArguments()).jogador
        val titulo =MostraDadosJogadoresFragmentArgs.fromBundle(requireArguments()).titulo

        if (titulo != null) {
            binding.textViewCampeontosNacionais3.setText(titulo.campeonatosNacionais.toString())
            binding.textViewTacasPortugal2.setText(titulo.tacasPortugal)
            binding.textViewTacasLiga4.setText(titulo.tacasLiga.toString())
            binding.textViewSupertacas4.setText(titulo.supertacas.toString())
            binding.textViewCampeonatosContinentaisSelecoes4.setText(titulo.campeonatosContinentaisSelecoes.toString())
            binding.textViewCampeonatosMundoSelecoes4.setText(titulo.campeonatosMundoSelecoes.toString())

        }

        this.titulo = titulo

        if (jogador!= null) {
            binding.textViewNome5.setText(jogador.nome)
            binding.textViewDataNascimento2.setText(jogador.dataNascimento.toString())
            binding.textViewClube2.setText(jogador.clube)
            binding.textViewNacionalidade2.setText(jogador.nacionalidade)
            binding.textViewPosicao2.setText(jogador.posicao)
            binding.textViewAltura2.setText(jogador.altura.toString())
            binding.textViewPeso2.setText(jogador.peso.toString())
            binding.textViewInternacionalizacoes2.setText(jogador.internacionalizacoes.toString())
            binding.textViewGolos2.setText(jogador.golos.toString())

        }
        this.jogador=jogador
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun processaOpcaoMenu(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_cancelar -> {
                voltarMenuPrincipal()
                true
            }
            else -> false
        }
    }

    private fun voltarMenuPrincipal() {
        findNavController().navigate(R.id.action_mostraDadosJogadoresFragment2_to_menuPrincipalFragment)
    }

}