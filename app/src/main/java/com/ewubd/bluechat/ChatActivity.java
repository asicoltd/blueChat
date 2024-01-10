package com.ewubd.bluechat;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {

    private LinearLayout linearChat;
    private EditText editTextMessage;

    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // Retrieve chat name from the Intent
        String chatName = getIntent().getStringExtra("chat_name");

        // Set title as the chat name
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(chatName);
        }

        linearChat = findViewById(R.id.linearChat);
        editTextMessage = findViewById(R.id.editTextMessage);

        // Sample incoming and outgoing messages (for testing purposes)
        receiveMessage("Hello there!"); // Incoming message
        sendMessage("Hi! How can I help?"); // Outgoing message

        // Start the countdown timer
        startCountdownTimer();
    }

    private void startCountdownTimer() {
        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Update the timer every second
                setTitle("Timer: " + millisUntilFinished / 1000 + " seconds");
            }

            @Override
            public void onFinish() {
                // Handle actions when the timer finishes (e.g., logout, show a message)
                setTitle("Timer finished!");
            }
        }.start();
    }

    private void sendMessage(String message) {
        if (!message.isEmpty()) {
            // Create a new TextView for the outgoing message
            TextView tvMessage = new TextView(this);
            tvMessage.setText(message);
            tvMessage.setBackgroundResource(R.drawable.outgoing_message_bg);
            tvMessage.setPadding(16, 8, 16, 8);
            tvMessage.setGravity(Gravity.END);

            // Add the TextView to the chat layout
            linearChat.addView(tvMessage);

            // Clear the message input
            editTextMessage.getText().clear();

            // Scroll the ScrollView to the bottom to show the latest message
            ScrollView scrollViewChat = findViewById(R.id.scrollViewChat);
            scrollViewChat.post(new Runnable() {
                @Override
                public void run() {
                    scrollViewChat.fullScroll(ScrollView.FOCUS_DOWN);
                }
            });
        }
    }

    private void receiveMessage(String message) {
        if (!message.isEmpty()) {
            // Create a new TextView for the incoming message
            TextView tvMessage = new TextView(this);
            tvMessage.setText(message);
            tvMessage.setBackgroundResource(R.drawable.incoming_message_bg);
            tvMessage.setPadding(16, 8, 16, 8);
            tvMessage.setGravity(Gravity.START);

            // Add the TextView to the chat layout
            linearChat.addView(tvMessage);

            // Scroll the ScrollView to the bottom to show the latest message
            ScrollView scrollViewChat = findViewById(R.id.scrollViewChat);
            scrollViewChat.post(new Runnable() {
                @Override
                public void run() {
                    scrollViewChat.fullScroll(ScrollView.FOCUS_DOWN);
                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Cancel the countdown timer to prevent memory leaks
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
