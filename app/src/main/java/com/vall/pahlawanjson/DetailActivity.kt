package com.vall.pahlawanjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.vall.pahlawanjson.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val DATA = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<PahlawanItem>(DATA)

        binding.imageView2.load(data?.img)
        binding.txtKategori.text = data?.kategori
        binding.txtNama.text = data?.nama
        binding.txtNama2.text = data?.nama2
        binding.txtAsal.text = data?.asal
        binding.txtUsia.text = data?.usia
        binding.txtGugur.text = data?.gugur
        binding.txtLahir.text = data?.lahir
        binding.txtLokasiMakam.text = data?.lokasimakam
        binding.txtHistory.text = data?.history


    }
}