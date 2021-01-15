package com.example.smartcompliance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class EntryActivity extends AppCompatActivity {
    Button addBtn;
    EditText getValue, haulier, delivery, destination, variance, loaded, replace, under;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_activity);
        listView = findViewById(R.id.main_list);
        addBtn = findViewById(R.id.add_btn);
        getValue = findViewById(R.id.truck);
        haulier = findViewById(R.id.haulier);
        delivery = findViewById(R.id.delivery);
        destination = findViewById(R.id.destination);
        variance = findViewById(R.id.variance);
        loaded = findViewById(R.id.loaded);
        replace = findViewById(R.id.replace);
        under = findViewById(R.id.under);
        listView = findViewById(R.id.main_list);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();

            }
        });
    }
        private void openActivity() {
            Intent intent = new Intent(this, MainList.class);
            startActivity(intent);
        }

    }

