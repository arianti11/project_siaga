package com.example.project_cintung

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import com.example.project_cintung.databinding.FragmentBantuanBinding

class BantuanFragment : Fragment() {

    private var _binding: FragmentBantuanBinding? = null
    private val binding get() = _binding!!

    private val dataBantuan = listOf(
        mapOf("title" to "Panggilan Darurat", "desc" to "112"),
        mapOf("title" to "Ambulans", "desc" to "118 atau 119"),
        mapOf("title" to "Basarnas", "desc" to "115")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBantuanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Bantuan"

        val adapter = SimpleAdapter(
            requireContext(),
            dataBantuan,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
        binding.listBantuan.adapter = adapter

        binding.listBantuan.setOnItemClickListener { _, _, position, _ ->
            val item = dataBantuan[position]
            Toast.makeText(
                requireContext(),
                "Kamu memilih: ${item["title"]} (${item["desc"]})",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.listBantuan.setOnItemClickListener { _, _, position, _ ->
            val item = dataBantuan[position]
            Log.d("BANTUAN", "Dipilih: ${item["title"]}")

            Snackbar.make(binding.root, "Kontak: ${item["title"]} (${item["desc"]})", Snackbar.LENGTH_LONG)
                .setAnchorView(requireActivity().findViewById<View>(R.id.bottom_nav_view))
                .setAction("OK") {
                    Log.e("BANTUAN", "Snackbar ditutup")
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}