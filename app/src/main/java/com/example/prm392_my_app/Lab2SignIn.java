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

public class Lab2SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_sign_in);

        // Initialize Sign-In Views
        EditText usernameSignIn = findViewById(R.id.usernameSignIn);
        EditText passwordSignIn = findViewById(R.id.passwordSignIn);
        Button signInButton = findViewById(R.id.signInButton);
        TextView notAccount = findViewById(R.id.notAccount);

        // Navigate to Sign-Up Screen
        notAccount.setOnClickListener(v -> {
            Intent intent = new Intent(this, Lab2SignUp.class);
            startActivity(intent);
        });

        // Sign-In Validation
        signInButton.setOnClickListener(v -> {
            String username = usernameSignIn.getText().toString().trim();
            String password = passwordSignIn.getText().toString().trim();

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show();
            } else {
                // Assume sign-in logic is valid
                Toast.makeText(this, "Sign In Successful!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}