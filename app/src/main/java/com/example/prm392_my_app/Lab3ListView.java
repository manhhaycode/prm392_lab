package com.example.prm392_my_app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Lab3ListView extends AppCompatActivity {
    ListView listView;
    EditText editText;
    Button btn_add, btn_update;
    Integer position = 0;
    ArrayList<String> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_list_view);
        initializeViews();
        eventListeners();
    }

    private void initializeViews() {
        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editText);
        btn_add = findViewById(R.id.btn_add);
        btn_update = findViewById(R.id.btn_update);
        arr.add("Android");
        arr.add("iOS");
        arr.add("PHP");
        arr.add("Unity");
        arr.add("ASP.net");

        // view in list

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                arr
        );

        listView.setAdapter(adapter);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void deteleItem(int position) {
        arr.remove(position);
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                arr
        );

        listView.setAdapter(adapter);
    }

    private void updateItem(int position, String value) {
        arr.set(position, value);
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                arr
        );

        listView.setAdapter(adapter);
    }

    private void addItem(String value) {
        arr.add(value);
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                arr
        );

        listView.setAdapter(adapter);
    }


    private void clearEditText(){
        editText.setText("");
    }

    private void setItemSelectionToEditText(int position){
        editText.setText(arr.get(position));
        this.position = position;
    }


    private void eventListeners() {
        listView.setOnItemClickListener((parent, view, position, id) -> {
            setItemSelectionToEditText(position);
            showToast(arr.get(position));
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            deteleItem(position);
            return false;
        });

        btn_add.setOnClickListener(v -> {
            String value = editText.getText().toString();
            if (value.isEmpty()) {
                showToast("Please enter value");
                return;
            }
            addItem(value);
            clearEditText();
        });

        btn_update.setOnClickListener(v -> {
            String value = editText.getText().toString();
            if (value.isEmpty()) {
                showToast("Please enter value");
                return;
            }
            updateItem(position, value);
            clearEditText();
        });
    }
}