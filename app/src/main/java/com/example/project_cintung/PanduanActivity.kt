package com.example.project_cintung

import android.content.Intent
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
        val langkah = intent.getStringExtra("EXTRA_LANGKAH")
        val bantuan = intent.getStringExtra("EXTRA_BANTUAN")
        val sumber = intent.getStringExtra("EXTRA_SUMBER")
        val url = intent.getStringExtra("EXTRA_URL")
        val nomor = intent.getIntExtra("EXTRA_NOMOR", 0)
        Log.w("PANDUAN", "Kondisi nomor $nomor: $nama")

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
        binding.tvLangkah.text = langkah
        binding.tvBantuan.text = bantuan
        binding.tvSumber.text = "Sumber: $sumber"

        binding.btnSumber.setOnClickListener {
            val intentWeb = Intent(this, WebViewActivity::class.java)
            intentWeb.putExtra("EXTRA_URL", url)
            startActivity(intentWeb)
        }

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
                Toast.makeText(this, "FAST Rescue: panduan pertolongan pertama", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}