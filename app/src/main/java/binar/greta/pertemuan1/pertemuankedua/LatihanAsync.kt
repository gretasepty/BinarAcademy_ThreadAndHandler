package binar.greta.pertemuan1.pertemuankedua

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.greta.pertemuan1.R
import kotlinx.android.synthetic.main.activity_latihan_async.*

class LatihanAsync : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan_async)

        btn_hasilAsync.setOnClickListener {
            hitungBM().execute()
        }
    }

//  Class Hitung IMT
    inner class hitungBM : AsyncTask<Int, Void, String>(){

        override fun onPreExecute() {
            super.onPreExecute()
        }
        override fun doInBackground(vararg params: Int?): String {
            val beratB = edt_bbAsync.text.toString().toDouble()
            val tinggiB = edt_tbAsync.text.toString().toDouble()

            val imt = beratB/(tinggiB*tinggiB)

            var output = if(imt < 18.5){
                "Kurus"
            }else if (imt in 18.5 .. 24.9){
                "Normal"
            }else if(imt in 25.0 .. 29.9){
                "Overweight"
            }else{
                "Obesitas"
            }
            return output
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            txt_output.text = result
        }

    }
}