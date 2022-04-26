package binar.greta.pertemuan1.Tugas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.greta.pertemuan1.R
import kotlinx.android.synthetic.main.activity_tugas_thread.*

class TugasThread : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tugas_thread)
    threadTugas()
    }

    fun threadTugas(){
        Thread(Runnable {
            btn_hitung.setOnClickListener {
                val bb = edt_bb.text.toString().toInt()
                val tb = edt_tb.text.toString().toInt()
                val BMI : Double

                BMI = bb/((tb/100.0)*(tb/100.0))

                val IMT = if (BMI < 18.5){
                    "Kurus"
                }else if(BMI in 18.5 .. 24.9){
                    "Normal"
                }else if(BMI in 25.0 .. 29.9){
                    "Overweight"
                }else{
                    "Obesitas"
                }

                txt_hasilBMI.post(Runnable { txt_hasilBMI.text = BMI.toString() })
                txt_hasilIMT.post(Runnable { txt_hasilIMT.text = IMT })

            }
        }).start()
    }
}