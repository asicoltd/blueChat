package com.ewubd.bluechat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PersonalMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_message);

        // Set title for the activity
        setTitle("Personal Message");

        // Assuming you have a button to open the chat in your layout
        Button btnOpenChat = findViewById(R.id.btnOpenChat);
        btnOpenChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the ChatActivity with the title "Personal Message"
                openChatActivity("Personal Message");
            }
        });
    }

    private void openChatActivity(String chatTitle) {
        // Create an intent to open the ChatActivity
        Intent intent = new Intent(PersonalMessageActivity.this, ChatActivity.class);

        // Pass the chat title to the ChatActivity
        intent.putExtra("chat_name", chatTitle);

        // Start the ChatActivity
        startActivity(intent);
    }
}
