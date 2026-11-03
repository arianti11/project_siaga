package com.example.project_cintung

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.project_cintung.databinding.ItemKondisiBinding

class KondisiAdapter(
    context: Context,
    kondisiList: List<KondisiModel>
) : ArrayAdapter<KondisiModel>(context, 0, kondisiList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemKondisiBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root
        val data = getItem(position)!!

        Glide.with(context)
            .load(data.iconRes)
            .into(binding.imgKondisi)

        binding.tvNamaKondisi.text = data.nama
        binding.tvRingkasan.text = data.ringkasan

        view.setOnClickListener {
            bukaPanduan(context, data)
        }

        return view
    }
}