package com.ewubd.bluechat;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView aboutMessage = findViewById(R.id.aboutMessage);
        aboutMessage.setText("Developed by students of EWU for research purpose. We aim to contribute to the advancement of technology and innovation.");
    }
}
