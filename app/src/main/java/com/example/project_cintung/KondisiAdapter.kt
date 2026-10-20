package com.example.project_cintung

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.project_cintung.databinding.ItemKondisiBinding

class KondisiAdapter(
    context: Context,
    private val kondisiList: List<KondisiModel>
) : ArrayAdapter<KondisiModel>(context, 0, kondisiList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemKondisiBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root
        val data = kondisiList[position]

        Glide.with(context)
            .load(data.iconRes)
            .into(binding.imgKondisi)

        binding.tvNamaKondisi.text = data.nama
        binding.tvRingkasan.text = data.ringkasan

        view.setOnClickListener {
            val intent = Intent(context, PanduanActivity::class.java)
            intent.putExtra("EXTRA_NAMA", data.nama)
            intent.putExtra("EXTRA_RINGKASAN", data.ringkasan)
            context.startActivity(intent)
        }

        return view
    }
}