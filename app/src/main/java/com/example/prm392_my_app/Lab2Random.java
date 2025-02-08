package com.example.prm392_my_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class Lab2Random extends AppCompatActivity {
    private EditText minInput, maxInput;
    private TextView result;
    private Button generateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_random);

        // Initialize views
        minInput = findViewById(R.id.minInput);
        maxInput = findViewById(R.id.maxInput);
        result = findViewById(R.id.result);
        generateButton = findViewById(R.id.generateButton);

        // Set click listener for the button
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumber();
            }
        });
    }

    private void generateRandomNumber() {
        String minStr = minInput.getText().toString();
        String maxStr = maxInput.getText().toString();

        if (minStr.isEmpty() || maxStr.isEmpty()) {
            Toast.makeText(this, "Please enter both Min and Max values.", Toast.LENGTH_SHORT).show();
            return;
        }

        int min = Integer.parseInt(minStr);
        int max = Integer.parseInt(maxStr);

        if (min > max) {
            Toast.makeText(this, "Min value cannot be greater than Max value.", Toast.LENGTH_SHORT).show();
            return;
        }

        Random random = new Random();
        int randomNumber = random.nextInt((max - min) + 1) + min;
        result.setText(String.valueOf(randomNumber));
    }
}