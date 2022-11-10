package com.example.application


import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity






class MainActivity : AppCompatActivity() {

    var inbindservice:Ibindservices?=null
    var bt_bindservices:Button?=null
    var bt_unbindservices:Button?=null
    lateinit var value:String
   companion object {
       var txt_msg: TextView? = null
   }
    var mservice:Boolean?=false
    lateinit var mserviceconnection:ServiceConnection
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_bindservices=findViewById(R.id.bt_gettimestamp)
        bt_unbindservices=findViewById(R.id.bt_stop)
        txt_msg=findViewById(R.id.txt_msg)

        onStart()

        bt_bindservices?.setOnClickListener {


                var intent:Intent= Intent(this@MainActivity,Ibindservices::class.java)

                bindService(intent, mserviceconnection!!, BIND_AUTO_CREATE)





        }
        bt_unbindservices?.setOnClickListener {

            if(mservice!!)
            {
                unbindService(mserviceconnection)
                mservice=false
            }


        }


        mserviceconnection=object :ServiceConnection
       {
           override fun onServiceConnected(p0: ComponentName?, ser: IBinder?) {

               mservice = true

           }

           override fun onServiceDisconnected(p0: ComponentName?) {

               mservice=false
           }

       }
    }
}