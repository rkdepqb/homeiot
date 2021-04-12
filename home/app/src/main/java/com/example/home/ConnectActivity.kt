package com.example.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_connect.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.io.DataInput
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.OutputStream
import java.net.Socket
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

class ConnectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connect)

        var a_ip = input_ip.text.toString()
        var a_port = input_port.text.toString()

        btn_Connect.setOnClickListener {
            var thread = NetworkThread()
            thread.start()

           // var Ip = input_ip.text.toString()
           // var Port = input_port.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            Toast.makeText(this, "연결성공", Toast.LENGTH_SHORT).show()

            intent.putExtra("u_ip", a_ip)       // 사용자가 입력한 서버 ip
            intent.putExtra("u_port", a_port)   // 사용자가 입력한 포트

            startActivity(intent)

        }

    }

    inner class NetworkThread : Thread() {
        override fun run() {

            var a_ip = input_ip.text.toString()
            var a_port= input_port.text.toString()
            var u_port = a_port.toInt()

            try {
                var socket = Socket(a_ip,u_port)
                var input = socket.getInputStream()
                var dis = DataInputStream(input)

                var output = socket.getOutputStream()
                var dos = DataOutputStream(output)

                var data1 = dis.readInt()
                var data2 = dis.readDouble()
                var data3 = dis.readUTF()

            /*    var data : ArrayList<String> = ArrayList<String>()
                while(!dis.)
                {
                    data.add("$dis")

                    }

*/
           //     intent.putExtra("senseordata", data)


                dos.writeInt (200)
                dos.writeDouble(22.22)
                dos.writeUTF("클라이언트가 보낸 문자열")

                socket.close()

                runOnUiThread {
                    textView.text = "data1 : ${data1}\n"
                    textView.append("data2 : ${data2}\n")
                    textView.append("data2 : ${data3}\n")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


    }

}




