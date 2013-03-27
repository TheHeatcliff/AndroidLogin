package ar.com.globallogic.receivers;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import ar.com.globallogic.LoginActivity;

public class BootUpReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(LoginActivity.class.getSimpleName());
        i.setClass(context, LoginActivity.class);
        context.startService(i);
    }
}