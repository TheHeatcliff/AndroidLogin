package ar.com.globallogic.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;


public class MyService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        Log.i("BootUpReceiver", "Got to onReceive, about to start service");
        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
    }

    public void onDestroy() {
    	Log.i("BootUpReceiver", "Got to onReceive, about to start service");
    	super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();

    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
		Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
		Log.i("BootUpReceiver", "Got to onReceive, about to start service");
		return 1;
   }
    
    
    @Override
    public void onStart(Intent intent, int startId) {
        while (true)
        {
            Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
            try {
            	Log.i("BootUpReceiver", "Got to onReceive, about to start service");
            	Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}