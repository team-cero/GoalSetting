package com.example.goalsetting

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

class AlarmBroadcastReceiver() : BroadcastReceiver()  {

    override fun onReceive(context: Context?, intent: Intent?) {
        //check the recivement with toast
        Toast.makeText(context,"Received",Toast.LENGTH_LONG).show()
    }
}