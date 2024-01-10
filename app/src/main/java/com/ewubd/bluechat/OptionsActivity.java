package com.ewubd.bluechat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        final RadioGroup radioGroupAlgorithm = findViewById(R.id.radioGroupAlgorithm);
        final RadioGroup radioGroupManualOptions = findViewById(R.id.radioGroupManualOptions);
        final Spinner spinnerTheme = findViewById(R.id.spinnerTheme);
        final Button btnResetBluetooth = findViewById(R.id.btnResetBluetooth);

        // Setup theme spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.theme_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTheme.setAdapter(adapter);

        // Set click listeners for each button
        btnResetBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle "Reset Bluetooth Permission" button click
                Toast.makeText(OptionsActivity.this, "Resetting Bluetooth Permission", Toast.LENGTH_SHORT).show();
            }
        });

        // Set radio group listeners
        radioGroupAlgorithm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                // Handle algorithm selection
                RadioButton selectedRadioButton = findViewById(checkedId);

                if (selectedRadioButton.getId() == R.id.radioManual) {
                    // If Manual is selected, show the manual options
                    radioGroupManualOptions.setVisibility(View.VISIBLE);
                } else {
                    // If Auto is selected, hide the manual options
                    radioGroupManualOptions.setVisibility(View.GONE);
                }
            }
        });

        // Set spinner listener
        spinnerTheme.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                // Handle theme selection
                String selectedTheme = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(OptionsActivity.this, "Selected Theme: " + selectedTheme, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Handle when nothing is selected
            }
        });
    }
}
