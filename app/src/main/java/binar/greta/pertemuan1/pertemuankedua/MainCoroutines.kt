package binar.greta.pertemuan1.pertemuankedua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.greta.pertemuan1.R
import kotlinx.android.synthetic.main.activity_main_coroutines.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainCoroutines : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_coroutines)
        contohCoroutines()

        }
    fun contohCoroutines(){
        GlobalScope.launch {
//            delay(2000)
//            txt_coroutines.text = "Hello Binar"

            hasil()
        }
    }

    suspend fun hasil():String{
        delay(2000)
        val a = txt_coroutines.setText("Hello Binar")
        return  a.toString()
    }
}