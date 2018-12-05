package com.example.josh.week7daily1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.sql.Time;
import java.util.Calendar;

public class HomeActivity extends AppCompatActivity{
    SharedPreferences sharedPreferences;
    public static final String TAG = "_TAG";
    static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sharedPreferences = this.getSharedPreferences("time",Context.MODE_PRIVATE);
        sharedPreferences.edit().putLong("time", Calendar.getInstance().getTime().getTime()).apply();
        startUserInactivityDetectThread();
    }
    public static Context getContext(){
        return context;
    }
    public void startUserInactivityDetectThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(15000);
                        long currentTime = Calendar.getInstance().getTime().getTime();
                        long lastTime = sharedPreferences.getLong("time",0);
                        Log.d(TAG, "run: " + currentTime + " " + lastTime);
                        Log.d(TAG, "run: " + (currentTime - lastTime));
                        if(currentTime - lastTime > 60000){
                            finish();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }


    public void onInteract(View view) {
        sharedPreferences.edit().putLong("time", Calendar.getInstance().getTime().getTime()).apply();
        Log.d(TAG, "onClick: ");
    }
}
