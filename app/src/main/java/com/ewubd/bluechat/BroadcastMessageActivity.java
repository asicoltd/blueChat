package com.ewubd.bluechat;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import com.ewubd.bluechat.matrix_maeny.bluetoothchat.MainActivity2;

import java.util.Objects;

@SuppressLint("CustomSplashScreen")
public class BroadcastMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Thread(){
            @RequiresApi(api = Build.VERSION_CODES.S)
            public void run(){
                try{
                    sleep(200);
                }catch (Exception ignored){

                }finally {
                    startActivity(new Intent(BroadcastMessageActivity.this, MainActivity2.class));
                    finish();
                }
            }
        }.start();
    }
}