package com.ewubd.bluechat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateGroupActivity extends AppCompatActivity {

    private EditText editTextGroupName;
    private EditText editTextPin;
    private RadioGroup radioGroupPrivacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        editTextGroupName = findViewById(R.id.edtGroupName);
        editTextPin = findViewById(R.id.edtPin);
        radioGroupPrivacy = findViewById(R.id.radioGroupPrivacy);

        Button btnCreate = findViewById(R.id.btnCreate);

        // Toggle visibility of PIN EditText based on the selected radio button
        radioGroupPrivacy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);

                // Toggle visibility of PIN EditText based on the selected radio button
                if (radioButton != null && radioButton.getText().toString().equals("Private")) {
                    editTextPin.setVisibility(View.VISIBLE);
                } else {
                    editTextPin.setVisibility(View.GONE);
                }
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check privacy option selected
                int selectedPrivacyId = radioGroupPrivacy.getCheckedRadioButtonId();
                RadioButton radioButtonPrivacy = findViewById(selectedPrivacyId);

                if (radioButtonPrivacy != null) {
                    String privacyOption = radioButtonPrivacy.getText().toString();

                    // Handle group creation based on privacy option
                    if (privacyOption.equals("Public")) {
                        // Public group: Only require group name
                        if (validateGroupName()) {
                            createGroup();
                        }
                    } else if (privacyOption.equals("Private")) {
                        // Private group: Require both group name and PIN
                        if (validateGroupName() && validatePin()) {
                            createGroup();
                        }
                    }
                }
            }
        });
    }

    private boolean validateGroupName() {
        String groupName = editTextGroupName.getText().toString().trim();
        if (groupName.isEmpty()) {
            Toast.makeText(this, "Please enter a group name", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean validatePin() {
        String pin = editTextPin.getText().toString().trim();
        if (pin.isEmpty()) {
            Toast.makeText(this, "Please enter a PIN for the private group", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void createGroup() {
        // Handle group creation logic here
        // ...

        Toast.makeText(this, "Group created", Toast.LENGTH_SHORT).show();

        // Open the ChatActivity when the group is created
        // Example code in another activity where you create the group chat
        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra("chat_name", editTextGroupName.getText().toString()); // Add the group name as an extra
        startActivity(intent);


        // Finish the current activity (optional)
        finish();
    }
}
