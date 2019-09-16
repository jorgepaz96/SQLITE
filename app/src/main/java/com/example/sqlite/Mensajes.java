package com.example.sqlite;

import android.app.Activity;
import android.widget.Toast;

class Mensajes {
    public static void Msg(Activity activity, String msg){
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }
}
