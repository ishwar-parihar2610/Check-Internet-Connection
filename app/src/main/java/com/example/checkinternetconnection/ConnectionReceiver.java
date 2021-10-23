package com.example.checkinternetconnection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.TextView;
import android.widget.Toast;

public class ConnectionReceiver extends BroadcastReceiver {
    Context mContext;


    @Override
    public void onReceive(Context context, Intent intent) {
        if (isConnected(context)) {
            Toast.makeText(context, "Internet  Connected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Internet Not Connected", Toast.LENGTH_SHORT).show();

        }
    }


    public boolean isConnected(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            return (networkInfo != null && networkInfo.isConnected());

        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }

    }

}
