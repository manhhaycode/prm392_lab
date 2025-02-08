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
    private Button buttonSave, buttonDelete;

    private boolean isNewItem;
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
        buttonSave = findViewById(R.id.buttonUpdate);
        buttonDelete = findViewById(R.id.buttonDelete);

        // Get data from Intent
        Intent intent = getIntent();
        isNewItem = intent.getBooleanExtra("isNewItem", false);
        position = intent.getIntExtra("position", -1);
        traiCay = (TraiCay) intent.getSerializableExtra("item");

        // Set up UI based on mode
        if (isNewItem) {
            buttonSave.setText("Create");
            buttonDelete.setVisibility(View.GONE); // Hide delete button for new items
            traiCay = new TraiCay("", "", R.drawable.ic_launcher_background);
        } else if (traiCay != null) {
            editTextTen.setText(traiCay.getTen());
            editTextMota.setText(traiCay.getMota());
            imageViewDetail.setImageResource(traiCay.getHinh());
        }

        // Save button click listener
        buttonSave.setOnClickListener(v -> {
            String title = editTextTen.getText().toString().trim();
            String description = editTextMota.getText().toString().trim();

            if (title.isEmpty() || description.isEmpty()) {
                Toast.makeText(this, "Fields cannot be empty!", Toast.LENGTH_SHORT).show();
                return;
            }

            traiCay.setTen(title);
            traiCay.setMota(description);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("item", traiCay);
            resultIntent.putExtra("position", position);
            resultIntent.putExtra("isNewItem", isNewItem);
            setResult(RESULT_OK, resultIntent);
            finish();
        });

        // Delete button click listener
        buttonDelete.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("position", position);
            setResult(RESULT_FIRST_USER, resultIntent);
            finish();
        });
    }
}
