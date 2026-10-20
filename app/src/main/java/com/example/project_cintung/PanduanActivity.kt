package com.example.project_cintung

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_cintung.databinding.ActivityPanduanBinding
import com.google.android.material.snackbar.Snackbar

class PanduanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPanduanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPanduanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ambil data yang dikirim dari halaman Kondisi
        val nama = intent.getStringExtra("EXTRA_NAMA")
        val ringkasan = intent.getStringExtra("EXTRA_RINGKASAN")
        Log.w("PANDUAN", "Kondisi dibuka: $nama")

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = nama
            subtitle = "Panduan pertolongan pertama"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        binding.tvJudul.text = nama
        binding.tvRingkasan.text = ringkasan

        // TODO: ganti dengan langkah khusus tiap kondisi dari PMI atau Kemenkes
        binding.tvLangkah.text = "1. Pastikan area sekitar aman bagi kamu dan korban.\n" +
                "2. Tetap tenang, lalu periksa kondisi korban.\n" +
                "3. Hubungi bantuan darurat jika kondisi berat atau korban tidak sadar."

        binding.btnBantuan.setOnClickListener {
            Snackbar.make(binding.root, "Segera hubungi 112 jika kondisi berat", Snackbar.LENGTH_LONG)
                .setAction("OK") {
                    Log.e("PANDUAN", "Snackbar ditutup")
                }
                .show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.panduan_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            R.id.action_bantuan -> {
                Toast.makeText(this, "Daftar nomor darurat ada di tab Bantuan", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_tentang -> {
                Toast.makeText(this, "SIAGA: panduan pertolongan pertama", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}