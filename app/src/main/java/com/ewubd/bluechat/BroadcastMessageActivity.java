package com.ewubd.bluechat;

import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BroadcastMessageActivity extends AppCompatActivity{
        private void createGroup() {
            Intent intent = new Intent(BroadcastMessageActivity.this, ChatActivity.class);
            intent.putExtra("chat_name", "Personal Message"); // Add the group name as an extra
            startActivity(intent);
            finish();
        }
}
