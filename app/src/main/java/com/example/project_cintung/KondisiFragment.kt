package com.example.project_cintung

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.project_cintung.databinding.FragmentKondisiBinding

class KondisiFragment : Fragment() {

    private var _binding: FragmentKondisiBinding? = null
    private val binding get() = _binding!!

    private val kondisiList = listOf(
        KondisiModel("Pingsan", "Korban tiba-tiba tidak sadarkan diri", R.drawable.ic_logo_siaga_merah),
        KondisiModel("Luka / Pendarahan", "Luka terbuka dan keluarnya darah", R.drawable.ic_logo_siaga_merah),
        KondisiModel("Luka Bakar", "Terkena api, air panas, atau benda panas", R.drawable.ic_logo_siaga_merah),
        KondisiModel("Tersedak", "Saluran napas tersumbat benda asing", R.drawable.ic_logo_siaga_merah),
        KondisiModel("Keseleo", "Cedera pada sendi, misalnya pergelangan kaki", R.drawable.ic_logo_siaga_merah),
        KondisiModel("Kecelakaan Ringan", "Terjatuh, terbentur, atau tersandung", R.drawable.ic_logo_siaga_merah)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKondisiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Kondisi"

        val adapter = KondisiAdapter(requireContext(), kondisiList)
        binding.listKondisi.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}