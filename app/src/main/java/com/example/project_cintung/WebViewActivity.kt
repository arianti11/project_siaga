package com.example.project_cintung

import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_cintung.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://www.google.com/aclk?sa=L&ai=DChsSEwig5r6WvsiXAxV_mWYCHbcrAGcYACICCAEQABoCc20&ae=2&co=1&ase=2&gclid=EAIaIQobChMIoOa-lr7IlwMVf5lmAh23KwBnEAAYASAAEgKMl_D_BwE&cid=CAAS0wHkaGq9HHy9NRt7G4wXwVgys0_NZeQAfVfsSErI5Kpo_ynKVkv5NKN3fKWNdx_k-gWkOsePSUA_ccI231NgzCyYhXMHdfFsiG13PDT1tX0t8ds5biATJYBOiPgEcsGjAIo6IdtajQg11Gwgc1XjyGfwW4qk9O46xPiwsnzPb_TsNRSfMZ76Ay0RQV7dl7aFfXj_uO1WWxxkJXudTEq_XK-9n20t_bu4C-OnMOgbhUZuqfp1wfpEjwhFWt3mpWoJcabRKUEI4Erij-cMDsLYYERbpt_D&cce=2&category=acrcp_v1_71&sig=AOD64_1sdHehhvc_MBTKymBRVJXYlk0vwA&q&nis=4&adurl&ved=2ahUKEwiKxriWvsiXAxVq1DgGHZYMOS8Q0Qx6BAgZEAE")

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Sumber Referensi"
            subtitle = "Palang Merah Indonesia"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        // Agar Toolbar hide/show saat scroll web
        binding.webView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            if (scrollY > oldScrollY) {
                binding.appBar.setExpanded(false, true)
            } else if (scrollY < oldScrollY) {
                binding.appBar.setExpanded(true, true)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}