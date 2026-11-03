package com.example.project_cintung

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.project_cintung.databinding.FragmentBerandaBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BerandaFragment : Fragment() {

    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBerandaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "FAST Rescue"

        val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", "Pengguna")
        binding.tvWelcome.text = "Halo, $username"

        val adapter = KartuKondisiAdapter(requireContext(), daftarKondisi)
        binding.gridKondisi.adapter = adapter
        binding.gridKondisi.setOnItemClickListener { _, _, position, _ ->
            bukaPanduan(requireContext(), daftarKondisi[position])
        }

        binding.cardCari.setOnClickListener {
            pindahTab(R.id.pencarian)
        }

        binding.btnDarurat.setOnClickListener {
            pindahTab(R.id.bantuan)
        }
    }

    private fun pindahTab(idMenu: Int) {
        val nav = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        nav.selectedItemId = idMenu
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}