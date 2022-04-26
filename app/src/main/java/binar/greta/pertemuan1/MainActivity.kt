package binar.greta.pertemuan1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import binar.greta.pertemuan1.latihan.LatihanThread
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        contohThreadSatu()
//        contohHandler()
        contohHandlerThread()
        contohHT()
    }

    fun contohThreadSatu(){
        Thread(Runnable {
            btn_change.setOnClickListener {
                txt_satu.post(Runnable {txt_satu.text = "Hello Binar Academy"  })
            }
            txt_satu.post(Runnable { txt_satu.text = "Hello" })
//            txt_dua.postDelayed(Runnable { txt_dua.text = "Welcome" }, 2000)
        }).start()

    }

    fun contohHandler(){
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            startActivity(Intent(this, LatihanThread :: class.java))
        }, 3000)

        Handler().post { Runnable {
            txt_dua.setText("Halllooooo")
        } }
    }

    fun contohHandlerThread(){
        val han = object : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val pesan2 = msg.obj as String
                txt_dua.text = pesan2
            }
        }

        Thread(Runnable {
            val a = "Contoh"
            val pesan = Message.obtain()
            pesan.obj = a
            pesan.target = han
            pesan.sendToTarget()
        }).start()
    }

    fun contohHT(){
        Thread(Runnable {
            val targetHan = object  : Handler(Looper.getMainLooper()){
                override fun handleMessage(msg: Message) {
                    super.handleMessage(msg)
                    val b = msg.obj as String
                    txt_satu.text = b
                }
            }
            val a = Message.obtain()
            a.obj = "qwerty"
            a.target = targetHan
            a.sendToTarget()
        }).start()
    }




}