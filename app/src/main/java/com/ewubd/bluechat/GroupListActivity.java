package com.ewubd.bluechat;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GroupListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);

        // Sample data for the group list
        List<String> groupData = new ArrayList<>();
        groupData.add("Group 1 | Members: 10 | Delay: 5 sec");
        groupData.add("Group 2 | Members: 8 | Delay: 3 sec");
        groupData.add("Group 3 | Members: 15 | Delay: 8 sec");

        // Set up the ListView
        ListView listViewGroups = findViewById(R.id.listViewGroups);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, groupData);
        listViewGroups.setAdapter(adapter);
    }
}
