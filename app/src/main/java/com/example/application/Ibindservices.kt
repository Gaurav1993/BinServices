package com.example.application

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log



class Ibindservices : Service() {
    private val LOG_TAG = "BoundService"
    val ibind:IBinder=Binder();


    override fun onCreate() {
        super.onCreate()



    }

    override fun onBind(p0: Intent?): IBinder? {

        MainActivity.txt_msg?.text="Bind Services"
        Log.v(LOG_TAG, "in onBind");
        return ibind
    }

    override fun onRebind(intent: Intent?) {
        Log.v(LOG_TAG, "in onRebind");
        super.onRebind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(LOG_TAG, "in onDestroy");



    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.v(LOG_TAG, "in onUnbind");
        MainActivity.txt_msg?.text="UnBind Services"
        return true

    }


}


