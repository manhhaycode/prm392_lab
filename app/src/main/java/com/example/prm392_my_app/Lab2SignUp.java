package com.example.prm392_my_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Lab2SignUp extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_sign_up);

        // Initialize Sign-Up Views
        EditText usernameSignUp = findViewById(R.id.usernameSignUp);
        EditText passwordSignUp = findViewById(R.id.passwordSignUp);
        EditText confirmPasswordSignUp = findViewById(R.id.confirmPasswordSignUp);
        Button signUpButton = findViewById(R.id.signUpButton);
        TextView alreadyAccount = findViewById(R.id.alreadyAccount);

        // Navigate to Sign-In Screen
        alreadyAccount.setOnClickListener(v -> {
            Intent intent = new Intent(this, Lab2SignIn.class);
            startActivity(intent);
        });

        // Sign-Up Validation
        signUpButton.setOnClickListener(v -> {
            String username = usernameSignUp.getText().toString().trim();
            String password = passwordSignUp.getText().toString().trim();
            String confirmPassword = confirmPasswordSignUp.getText().toString().trim();

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPassword)) {
                Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}