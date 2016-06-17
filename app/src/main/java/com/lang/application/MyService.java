package com.lang.application;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/17 0017.
 */
public class MyService extends Service {
    String TAG = "MyService";
    private DownBinder binder=new DownBinder();
    class DownBinder extends Binder{
        public void startDownload(){
            Log.d(TAG, "startDownload: ");
        }
        public int  getProgress(){
            Log.d(TAG, "getProgress: ");
            return  0;
    }

    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: excuted");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: excuted");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: excuted");
    }
}
