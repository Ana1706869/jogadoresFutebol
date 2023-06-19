package com.example.jogadoresfutebol

import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jogadoresfutebol.databinding.FragmentEditarJogadorBinding
import java.text.SimpleDateFormat
import java.util.*

class EditarJogadorFragment : Fragment() {
    private var jogador: Jogadores?= null
    private var _binding: FragmentEditarJogadorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEditarJogadorBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity as MainActivity
        activity.fragment = this
        activity.idMenuAtual = R.menu.menu_guardar_cancelar

        val jogador = EditarJogadorFragmentArgs.fromBundle(requireArguments()).jogador


        if (jogador != null) {
            binding.editTextId.setText(jogador.id.toString())
            binding.editTextNome.setText(jogador.nome)
            if (jogador.dataNascimento!= null) {
                binding.editTextDataNascimento.setText(
                    DateFormat.format("yyyy-MM-dd", jogador.dataNascimento)
                )
            }
            binding.editTextTextClube.setText(jogador.clube)
            binding.editTextTextNacionalidade.setText(jogador.nacionalidade)
            binding.editTextTextPosicao.setText(jogador.posicao)
            binding.editTextAltura.setText(jogador.altura.toString())
            binding.editTextPeso.setText(jogador.peso.toString())
            binding.editTextInternacionalizacoes.setText(jogador.internacionalizacoes.toString())
            binding.editTextGolos.setText(jogador.golos.toString())
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun processaOpcaoMenu(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_guardar -> {
                guardar()
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
        findNavController().navigate(R.id.action_editarJogadorFragment_to_listaJogadoresFragment)
    }

    private fun guardar() {
        val editTextId = binding.editTextId.text.toString()
        if (editTextId.isBlank()) {
            binding.editTextId.error = getString(R.string.id_obrigatorio)
            binding.editTextId.requestFocus()
            return
        }
        val id=editTextId.toLong()

        val nome = binding.editTextNome.text.toString()
        if (nome.isBlank()) {
            binding.editTextNome.error = getString(R.string.nome_obrigatorio)
            binding.editTextNome.requestFocus()
            return
        }

        val data: Date
        val df = SimpleDateFormat("dd-MM-yyyy")
        try {
            data = df.parse(binding.editTextDataNascimento.text.toString())
        } catch (e: Exception) {
            binding.editTextDataNascimento.error = getString(R.string.data_invalida)
            binding.editTextDataNascimento.requestFocus()
            return
        }
        val dataNascimento = Calendar.getInstance()
        dataNascimento.time = data


        val clube = binding.editTextTextClube.text.toString()
        if (nome.isBlank()) {
            binding.editTextTextClube.error = getString(R.string.clube_obrigatorio)
            binding.editTextTextClube.requestFocus()
            return
        }

        val nacionalidade = binding.editTextTextNacionalidade.text.toString()
        if (nome.isBlank()) {
            binding.editTextTextNacionalidade.error = getString(R.string.nacionalidade_obrigatoria)
            binding.editTextTextNacionalidade.requestFocus()
            return
        }

        val posicao = binding.editTextTextPosicao.text.toString()
        if (nome.isBlank()) {
            binding.editTextTextPosicao.error = getString(R.string.posicao_obrigatoria)
            binding.editTextTextPosicao.requestFocus()
            return
        }

        val editTextAltura = binding.editTextAltura.text.toString()
        if (nome.isBlank()) {
            binding.editTextAltura.error = getString(R.string.altura_obrigatoria)
            binding.editTextAltura.requestFocus()
            return
        }
        val altura=editTextAltura.toDouble()

        val editTextPeso = binding.editTextPeso.text.toString()
        if (editTextPeso.isBlank()) {
            binding.editTextPeso.error = getString(R.string.peso_obrigatorio)
            binding.editTextPeso.requestFocus()
            return
        }
        val peso=editTextPeso.toInt()

        val editTextInternacionalizacoes = binding.editTextInternacionalizacoes.text.toString()
        if (editTextInternacionalizacoes.isBlank()) {
            binding.editTextInternacionalizacoes.error = getString(R.string.internacionalizacoes_obrigatorias)
            binding.editTextInternacionalizacoes.requestFocus()
            return
        }
        val internacionalizacoes=editTextInternacionalizacoes.toInt()

        val editTextGolos = binding.editTextGolos.text.toString()
        if (editTextGolos.isBlank()) {
            binding.editTextGolos.error = getString(R.string.golos_obrigatorios)
            binding.editTextGolos.requestFocus()
            return
        }
        val golos=editTextGolos.toInt()

        val jogador = Jogadores(
            id,nome, dataNascimento, clube, nacionalidade, posicao,altura, peso, internacionalizacoes, golos
        )

        val idJogador = requireActivity().contentResolver.insert(
            JogadoresContentProvider.ENDERECO_JOGADORES,
            jogador.toContentValues()
        )

        if (id == null) {
            binding.editTextNome.error = getString(R.string.erro_adicionar_jogador)
            return
        }

        Toast.makeText(requireContext(), getString(R.string.jogador_adicionado_com_sucesso), Toast.LENGTH_SHORT).show()
        voltaListaJogadores()
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