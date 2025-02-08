package com.example.prm392_my_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Lab3TraiCayEdit extends AppCompatActivity {

    private EditText editTextTen, editTextMota;
    private ImageView imageViewDetail;
    private Button buttonUpdate, buttonDelete;

    private int position;
    private TraiCay traiCay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_trai_cay_edit);

        // Bind views
        editTextTen = findViewById(R.id.editTextTen);
        editTextMota = findViewById(R.id.editTextMota);
        imageViewDetail = findViewById(R.id.imageViewDetail);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonDelete = findViewById(R.id.buttonDelete);

        // Get data from intent
        Intent intent = getIntent();
        position = intent.getIntExtra("position", -1);
        traiCay = (TraiCay) intent.getSerializableExtra("item");

        if (traiCay != null) {
            editTextTen.setText(traiCay.getTen());
            editTextMota.setText(traiCay.getMota());
            imageViewDetail.setImageResource(traiCay.getHinh());
        }

        // Update button
        buttonUpdate.setOnClickListener(v -> {
            traiCay.setTen(editTextTen.getText().toString().trim());
            traiCay.setMota(editTextMota.getText().toString().trim());

            Intent resultIntent = new Intent();
            resultIntent.putExtra("item", traiCay);
            resultIntent.putExtra("position", position);
            setResult(RESULT_OK, resultIntent);
            finish();
        });

        // Delete button
        buttonDelete.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("position", position);
            setResult(RESULT_FIRST_USER, resultIntent);
            finish();
        });
    }
}
