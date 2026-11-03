package com.example.project_cintung

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.project_cintung.databinding.ItemKartuKondisiBinding

class KartuKondisiAdapter(
    context: Context,
    private val data: List<KondisiModel>
) : ArrayAdapter<KondisiModel>(context, 0, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemKartuKondisiBinding.inflate(LayoutInflater.from(context), parent, false)
        val item = data[position]

        Glide.with(context)
            .load(item.iconRes)
            .into(binding.imgKartu)

        binding.tvNamaKartu.text = item.nama

        return binding.root
    }
}