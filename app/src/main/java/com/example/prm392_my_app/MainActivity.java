package com.example.prm392_my_app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.prm392_my_app.databinding.ActivityMainBinding;

import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private EditText etMin, etMax;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        etMin = findViewById(R.id.et_min);
        etMax = findViewById(R.id.et_max);
        tvResult = findViewById(R.id.tv_result);
    }

    public void generateRandom(View view) {
        try {
            // Get input values
            int min = Integer.parseInt(etMin.getText().toString());
            int max = Integer.parseInt(etMax.getText().toString());

            if (min > max) {
                tvResult.setText("Result: Invalid range");
                return;
            }

            // Generate random number
            Random random = new Random();
            int randomNum = random.nextInt((max - min) + 1) + min;
            tvResult.setText("Result: " + randomNum);
        } catch (NumberFormatException e) {
            tvResult.setText("Result: Invalid input");
        }
    }


}