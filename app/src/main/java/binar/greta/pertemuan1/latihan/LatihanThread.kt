package binar.greta.pertemuan1.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import binar.greta.pertemuan1.R
import kotlinx.android.synthetic.main.activity_latihan_thread.*
import kotlinx.android.synthetic.main.activity_main.*

class LatihanThread : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan_thread)

        threadLatihan()
    }


    fun threadLatihan(){
        Thread(Runnable {
            btn_cetak.setOnClickListener {
                val nama = edt_nama.text.toString()
                val tahunLahir = edt_tahunLahir.text.toString()
                val hitung  = 2022 - tahunLahir.toInt()
                txt_cetak.post(Runnable { txt_cetak.text = nama })
                txt_cetakDua.post(Runnable { txt_cetakDua.text = hitung.toString() })
            }
        }).start()
    }


}