package com.example.prm392_my_app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Lab2Calculator extends AppCompatActivity {

    private EditText firstNumber, secondNumber;
    private TextView result;
    private Button addButton, subtractButton, multiplyButton, divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_calculator);

        // Initialize views
        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        result = findViewById(R.id.result);
        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);

        // Add button listener
        addButton.setOnClickListener(v -> performOperation("add"));

        // Subtract button listener
        subtractButton.setOnClickListener(v -> performOperation("subtract"));

        // Multiply button listener
        multiplyButton.setOnClickListener(v -> performOperation("multiply"));

        // Divide button listener
        divideButton.setOnClickListener(v -> performOperation("divide"));
    }

    private void performOperation(String operation) {
        String num1Str = firstNumber.getText().toString();
        String num2Str = secondNumber.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập cả hai số!", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double resultValue = 0;

        switch (operation) {
            case "add":
                resultValue = num1 + num2;
                break;
            case "subtract":
                resultValue = num1 - num2;
                break;
            case "multiply":
                resultValue = num1 * num2;
                break;
            case "divide":
                if (num2 == 0) {
                    Toast.makeText(this, "Không thể chia cho 0!", Toast.LENGTH_SHORT).show();
                    return;
                }
                resultValue = num1 / num2;
                break;
        }

        result.setText("Kết quả: " + resultValue);
    }
}