package binar.greta.pertemuan1.pertemuankedua

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.greta.pertemuan1.R
import kotlinx.android.synthetic.main.activity_main_async.*


@Suppress("DEPRECATION")
class MainAsync : AppCompatActivity() {
    lateinit var  cont : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_async)

        cont = this

        contohAsynTask().execute()
    }

    inner class contohAsynTask : AsyncTask<Int, Void, String>(){

        lateinit var pdialog : ProgressDialog

        override fun onPreExecute() {
            super.onPreExecute()

            pdialog = ProgressDialog(cont)
            pdialog.show()
        }
        override fun doInBackground(vararg params: Int?): String {
            val count = 12+9
            return  count.toString()
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            txt_hasilAsync.text = result
            pdialog.dismiss()
        }


    }


}