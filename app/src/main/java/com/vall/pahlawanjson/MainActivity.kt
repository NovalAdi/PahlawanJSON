package com.vall.pahlawanjson

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = parsingJSON()
        Log.i("JSON", "prsingJSON: $data")

        findViewById<RecyclerView>(R.id.rv_pahlawan).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = PahlawanAdapter(parsingJSON())
        }

//        val json = getJSONFromAsset()
//        Log.i("JSON", "onCreate: $json")
    }

    private fun parsingJSON(): ArrayList<PahlawanItem> {
        val json = getJSONFromAsset()
        Log.i("JSON", "parsingJSON: $json")

        //ambil dari json root
        val getRootJSON = JSONObject(json)

        //get array yang ada di dalam json
        val getArrayPahlawanFromJson = getRootJSON.getJSONArray(
            "daftar_pahlawan"
        )
        //wadah penampung untuk hasil data parsing
        val arrayPahlawan = ArrayList<PahlawanItem>()

        //ngambil data dari tiap array
        for (i in 0 until getArrayPahlawanFromJson.length()) {

            val getItemPahlawan = getArrayPahlawanFromJson.getJSONObject(i)

            //penampung untuk setiap item
            val pahlawan = PahlawanItem(
                nama = getItemPahlawan.getString("nama"),
                nama2 = getItemPahlawan.getString("nama2"),
                kategori = getItemPahlawan.getString("kategori"),
                asal = getItemPahlawan.getString("asal"),
                lahir = getItemPahlawan.getString("lahir")
            )
            pahlawan.usia = getItemPahlawan.getString("usia")
            pahlawan.gugur = getItemPahlawan.getString("gugur")
            pahlawan.lokasimakam = getItemPahlawan.getString("lokasimakam")
            pahlawan.history = getItemPahlawan.getString("history")
            pahlawan.img = getItemPahlawan.getString("img")

            //
            arrayPahlawan.add(pahlawan)
        }

        return arrayPahlawan
    }

    private fun getJSONFromAsset(): String {
        val json: String //ini adalah penampung json

        //mengambil json dari assest manager
        val stream = assets.open("pahlawan_nasional.json")

        val size = stream.available() //mengecek apakah ada inputan
        val buffer = ByteArray(size) //menyimpan data di ByteArray

        stream.read(buffer) //membaca inputan

        stream.close() //menghentikannya

        json = String(buffer, Charsets.UTF_8) //pengisian val json

        return json
    }
}
