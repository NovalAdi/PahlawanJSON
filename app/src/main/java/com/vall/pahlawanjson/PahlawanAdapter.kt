package com.vall.pahlawanjson

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

class PahlawanAdapter(private val dataPahlawan: ArrayList<PahlawanItem>): RecyclerView.Adapter<PahlawanAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val txtNama: TextView = view.findViewById(R.id.tv_nama)
        val imgPahlawan: ImageView = view.findViewById(R.id.img_pahlawan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.pahlawan_item, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataPahlawan[position]

        holder.txtNama.text = data.nama
        holder.imgPahlawan.load(data.img)

        holder.itemView.setOnClickListener {
            val i = Intent(it.context, DetailActivity::class.java)
            i.putExtra(DetailActivity.DATA, data)
            it.context.startActivity(i)
        }
    }

    override fun getItemCount() = dataPahlawan.size
}