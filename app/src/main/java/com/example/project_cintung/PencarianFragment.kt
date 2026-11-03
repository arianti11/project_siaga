package com.example.project_cintung

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.project_cintung.databinding.FragmentPencarianBinding

class PencarianFragment : Fragment() {

    private var _binding: FragmentPencarianBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: KondisiAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPencarianBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Pencarian"

        adapter = KondisiAdapter(requireContext(), ArrayList(daftarKondisi))
        binding.listPencarian.adapter = adapter
        binding.tvHasil.text = "${daftarKondisi.size} kondisi tersedia"

        binding.btnCari.setOnClickListener {
            cari(binding.etCari.text.toString().trim())
        }
    }

    private fun cari(kata: String) {
        val hasil = daftarKondisi.filter {
            it.nama.contains(kata, ignoreCase = true) ||
                    it.ringkasan.contains(kata, ignoreCase = true)
        }

        adapter.clear()
        adapter.addAll(hasil)

        binding.tvHasil.text = when {
            kata.isEmpty() -> "${hasil.size} kondisi tersedia"
            hasil.isEmpty() -> "Kondisi tidak ditemukan"
            else -> "${hasil.size} hasil untuk \"$kata\""
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}