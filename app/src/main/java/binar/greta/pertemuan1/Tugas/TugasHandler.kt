package binar.greta.pertemuan1.Tugas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import binar.greta.pertemuan1.R
import kotlinx.android.synthetic.main.activity_tugas_handler.*

class TugasHandler : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tugas_handler)

        tugasHandler()
    }

    fun tugasHandler(){
        val hand = object : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
//                val pesanSatu = msg.obj as String
//                txt_hasilBMIHandler.text = pesanSatu

                val pesanDua = msg.obj as String
                txt_hasilIMTHandler.text = pesanDua
            }


        }

        Thread(Runnable {
            btn_hitungHandler.setOnClickListener {
                val bb = edt_bbHandler.text.toString().toInt()
                val tb = edt_tbHandler.text.toString().toInt()

                val BMIHandler : Double = bb/((tb/100.0)*(tb/100.0))

                val IMTHandler = if(BMIHandler < 18.5){
                    "Kurus"
                }else if(BMIHandler in 18.5 .. 24.9){
                    "Normal"
                }else if(BMIHandler in 25.0 .. 29.9){
                    "Overweigt"
                }else{
                    "Obesitas"
                }

//                val pesanBMI = Message.obtain()
//                pesanBMI.obj = BMIHandler.toString()
//                pesanBMI.target = hand
//                pesanBMI.sendToTarget()

                val pesanIMT = Message.obtain()
                pesanIMT.obj = IMTHandler
                pesanIMT.target = hand
                pesanIMT.sendToTarget()
            }

        }).start()
    }


}