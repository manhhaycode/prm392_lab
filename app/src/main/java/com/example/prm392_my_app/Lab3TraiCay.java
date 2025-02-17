package com.example.prm392_my_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Lab3TraiCay extends AppCompatActivity {
    ListView lvTraiCay;
    ArrayList<TraiCay> arrayTraiCay;
    TraiCayAdapter adapter;
    Button buttonAdd;
    private static final int REQUEST_CODE_DETAIL = 1;
    private static final int REQUEST_CODE_ADD = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_trai_cay);

        // Initialize views
        lvTraiCay = findViewById(R.id.listViewTraiCay);
        buttonAdd = findViewById(R.id.buttonAdd);
        arrayTraiCay = new ArrayList<>();

        // Add sample data
        arrayTraiCay.add(new TraiCay("Chuối tiêu", "Chuối tiêu Long An", R.drawable.ic_launcher_background));
        arrayTraiCay.add(new TraiCay("Thanh Long", "Thanh long ruột đỏ", R.drawable.ic_launcher_foreground));

        // Initialize adapter
        adapter = new TraiCayAdapter(this, R.layout.fruit_layout, arrayTraiCay);
        lvTraiCay.setAdapter(adapter);
        // Item click listener
        // Navigate to DetailActivity for editing
        lvTraiCay.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, Lab3TraiCayEdit.class);
            intent.putExtra("isNewItem", false); // Not a new item
            intent.putExtra("position", position);
            intent.putExtra("item", arrayTraiCay.get(position));
            startActivityForResult(intent, REQUEST_CODE_DETAIL);
        });

        // Navigate to DetailActivity for creating a new item
        buttonAdd.setOnClickListener(v -> {
            Intent intent = new Intent(this, Lab3TraiCayEdit.class);
            intent.putExtra("isNewItem", true); // New item
            startActivityForResult(intent, REQUEST_CODE_ADD);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_DETAIL) {
            if (resultCode == RESULT_OK && data != null) {
                // Update item
                TraiCay updatedItem = (TraiCay) data.getSerializableExtra("item");
                int position = data.getIntExtra("position", -1);

                if (position != -1 && updatedItem != null) {
                    arrayTraiCay.set(position, updatedItem);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(this, "Item updated successfully", Toast.LENGTH_SHORT).show();
                }
            } else if (resultCode == RESULT_FIRST_USER && data != null) {
                // Delete item
                int position = data.getIntExtra("position", -1);

                if (position != -1) {
                    arrayTraiCay.remove(position);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(this, "Item deleted successfully", Toast.LENGTH_SHORT).show();
                }
            }
        } else if (requestCode == REQUEST_CODE_ADD) {
            if (resultCode == RESULT_OK && data != null) {
                // Add new item
                TraiCay newItem = (TraiCay) data.getSerializableExtra("item");

                if (newItem != null) {
                    arrayTraiCay.add(newItem);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(this, "Item added successfully", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
