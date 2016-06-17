package com.lang.application;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private Button mStartButtom,mStopButton,mBindService,mUnbindService;
    private MyService.DownBinder binder;
    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder= (MyService.DownBinder) service;
            binder.startDownload();
            binder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStartButtom= (Button) findViewById(R.id.start_service);
        mStopButton= (Button) findViewById(R.id.start_service);
        mBindService = (Button) findViewById(R.id.bind_service);
        mUnbindService = (Button) findViewById(R.id.unbind_service);
        mStartButtom.setOnClickListener(this);
        mStopButton.setOnClickListener(this);
        mBindService.setOnClickListener(this);
        mUnbindService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.start_service:
                Intent startintent=new Intent(this,MyService.class);
                startService(startintent);
            break;
            case R.id.stop_service:
                Intent stopintent=new Intent(this,MyService.class);
                stopService(stopintent);

            break;
            case R.id.bind_service:
                Intent binderintent = new Intent(this, MyService.class);
                bindService(binderintent, connection, BIND_AUTO_CREATE);

            break;
            case R.id.unbind_service:

                //执行onDestroy方法
                unbindService(connection);
                break;
            default:
                break;

        }

    }
}
