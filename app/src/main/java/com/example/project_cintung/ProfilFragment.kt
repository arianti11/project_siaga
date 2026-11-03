package com.example.project_cintung

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.example.project_cintung.databinding.FragmentProfilBinding

class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Profil"

        val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        binding.tvNama.text = sharedPref.getString("username", "Pengguna")

        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                    requireActivity().finish()
                }
                .setNegativeButton("Tidak") { dialog, _ -> dialog.dismiss() }
                .show()
        }
        binding.btnTentang.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Tentang FAST Rescue")
                .setMessage("FAST Rescue adalah aplikasi panduan pertolongan pertama berbasis Android. Aplikasi ini bukan pengganti tenaga medis.")
                .setPositiveButton("Tutup") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Dialog Tentang ditutup")
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}