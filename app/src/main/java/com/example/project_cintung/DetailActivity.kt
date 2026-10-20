package com.example.project_cintung

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_cintung.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.tvJudul.text = "SIAGA: Aplikasi Panduan Pertolongan Pertama Berbasis Android"

        binding.tvDeskripsi.text =
            "SIAGA adalah aplikasi mobile Android yang membantu pengguna melakukan pertolongan pertama pada kondisi darurat sederhana sebelum bantuan medis tiba." +
                    "\n\n" +
                    "Cedera sering terjadi di rumah dan lingkungan sekitar. Orang yang pertama menolong biasanya orang awam yang panik dan bingung harus mulai dari mana, sementara materi pertolongan pertama yang ada umumnya berupa artikel atau penyuluhan yang kurang praktis dibuka saat kejadian." +
                    "\n\n" +
                    "Karena itu SIAGA dirancang agar pengguna bisa memilih atau mencari kondisi seperti pingsan, luka atau pendarahan, luka bakar, tersedak, keseleo, dan kecelakaan ringan, lalu mengikuti panduan langkah demi langkah yang singkat. Dari halaman panduan, pengguna juga bisa langsung menghubungi nomor darurat." +
                    "\n\n" +
                    "Tujuannya adalah menyediakan panduan yang ringkas, mudah dipahami, dan siap dibuka kapan saja."
        
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Tentang SIAGA"
        binding.toolbar.setNavigationOnClickListener { finish() }

        binding.tvJudul.text = "SIAGA: Aplikasi Panduan Pertolongan Pertama Berbasis Android"
        binding.tvDeskripsi.text = "SIAGA membantu pengguna melakukan tindakan awal pada kondisi darurat sederhana seperti pingsan, luka, luka bakar, tersedak, dan keseleo. Panduan disajikan langkah demi langkah sehingga pengguna tidak perlu membaca artikel panjang saat situasi mendesak."
    }
}