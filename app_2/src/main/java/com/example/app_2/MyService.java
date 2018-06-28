package com.example.app_2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Misaya on 2018/6/26.
 */

public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG","*****oncreate*****");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG","---onStartCommand---");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("TAG","---onDestroy---");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
