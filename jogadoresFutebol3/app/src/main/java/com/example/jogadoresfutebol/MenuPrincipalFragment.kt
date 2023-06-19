package com.example.jogadoresfutebol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jogadoresfutebol.databinding.FragmentMenuPrincipalBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MenuPrincipalFragment : Fragment() {

        private var _binding: FragmentMenuPrincipalBinding? = null

        // This property is only valid between onCreateView and
        // onDestroyView.
        private val binding get() = _binding!!

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {

            _binding = FragmentMenuPrincipalBinding.inflate(inflater, container, false)
            return binding.root

        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.buttonSobre.setOnClickListener {
                findNavController().navigate(R.id.action_menuPrincipalFragment_to_sobreFragment)
            }

            binding.buttonJogadores.setOnClickListener {
                findNavController().navigate(R.id.action_menuPrincipalFragment_to_listaJogadoresFragment)
            }

            binding.buttonTitulos.setOnClickListener{
                findNavController().navigate(R.id.action_menuPrincipalFragment_to_listaTitulosFragment)

            }

            binding.buttonPesquisa.setOnClickListener{
                findNavController().navigate (R.id.action_menuPrincipalFragment_to_pesquisarFragment)
            }
            val activity = activity as MainActivity
            activity.fragment = this
            activity.idMenuAtual = R.menu.menu_main
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
}