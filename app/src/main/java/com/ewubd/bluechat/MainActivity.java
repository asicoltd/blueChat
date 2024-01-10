package com.ewubd.bluechat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int WELCOME_DELAY = 100; // 1 second
    private Button btnCreateGroup, btnFindGroup, btnPersonalMessage, btnBroadcastMessage, btnOption, btnAbout, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set title
        TextView appTitle = findViewById(R.id.appTitle);
        appTitle.setText("BlueChat");


        // Set buttons
        btnCreateGroup = findViewById(R.id.btnCreateGroup);
        btnFindGroup = findViewById(R.id.btnFindGroup);
        btnPersonalMessage = findViewById(R.id.btnPersonalMessage);
        btnBroadcastMessage = findViewById(R.id.btnBroadcastMessage);
        btnOption = findViewById(R.id.btnOption);
        btnAbout = findViewById(R.id.btnAbout);
        btnExit = findViewById(R.id.btnExit);

        // Initially hide buttons
        btnCreateGroup.setVisibility(View.INVISIBLE);
        btnFindGroup.setVisibility(View.INVISIBLE);
        btnPersonalMessage.setVisibility(View.INVISIBLE);
        btnBroadcastMessage.setVisibility(View.INVISIBLE);
        btnOption.setVisibility(View.INVISIBLE);
        btnAbout.setVisibility(View.INVISIBLE);
        btnExit.setVisibility(View.INVISIBLE);

        // Use Handler to delay the visibility change
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Delay for 1 second
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Reveal buttons after 1 second
                        btnCreateGroup.setVisibility(View.VISIBLE);
                        btnFindGroup.setVisibility(View.VISIBLE);
                        btnPersonalMessage.setVisibility(View.VISIBLE);
                        btnBroadcastMessage.setVisibility(View.VISIBLE);
                        btnOption.setVisibility(View.VISIBLE);
                        btnAbout.setVisibility(View.VISIBLE);
                        btnExit.setVisibility(View.VISIBLE);
                    }
                }, WELCOME_DELAY);
            }
        }, 0); // Initial delay of 0 milliseconds

        // Set click listener for all buttons
        // Set click listener for all buttons
        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class<?> destinationActivity = null;

                if (view.getId() == R.id.btnCreateGroup) {
                    destinationActivity = CreateGroupActivity.class;
                } else if (view.getId() == R.id.btnFindGroup) {
                    destinationActivity = GroupListActivity.class;
                } else if (view.getId() == R.id.btnPersonalMessage) {
                    destinationActivity = PersonalMessageActivity.class;
                } else if (view.getId() == R.id.btnBroadcastMessage) {
                    destinationActivity = BroadcastMessageActivity.class;
                } else if (view.getId() == R.id.btnOption) {
                    destinationActivity = OptionsActivity.class;
                } else if (view.getId() == R.id.btnAbout) {
                    destinationActivity = AboutActivity.class;
                } else if (view.getId() == R.id.btnExit) {
                    finish();
                }

                // Start the appropriate activity
                if (destinationActivity != null) {
                    Intent intent = new Intent(MainActivity.this, destinationActivity);
                    startActivity(intent);
                }
            }
        };


        // Set the click listener for all buttons
        btnCreateGroup.setOnClickListener(buttonClickListener);
        btnFindGroup.setOnClickListener(buttonClickListener);
        btnPersonalMessage.setOnClickListener(buttonClickListener);
        btnBroadcastMessage.setOnClickListener(buttonClickListener);
        btnOption.setOnClickListener(buttonClickListener);
        btnAbout.setOnClickListener(buttonClickListener);
        btnExit.setOnClickListener(buttonClickListener);
    }
}
