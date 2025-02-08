package com.example.prm392_my_app;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Lab3TraiCay extends AppCompatActivity {
    ListView lvTraiCay;
    ArrayList<TraiCay> arrayTraiCay;
    TraiCayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_trai_cay);

        // Initialize views
        lvTraiCay = findViewById(R.id.listViewTraiCay);
        arrayTraiCay = new ArrayList<>();

        // Add sample data
        arrayTraiCay.add(new TraiCay("Chuối tiêu", "Chuối tiêu Long An", R.drawable.ic_launcher_background));
        arrayTraiCay.add(new TraiCay("Thanh Long", "Thanh long ruột đỏ", R.drawable.ic_launcher_foreground));

        // Initialize adapter
        adapter = new TraiCayAdapter(this, R.layout.fruit_layout, arrayTraiCay);
        lvTraiCay.setAdapter(adapter);
    }
}
