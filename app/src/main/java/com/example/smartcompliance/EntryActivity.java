package com.example.smartcompliance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EntryActivity extends AppCompatActivity {
    DbHelper dbHelper;
    Button addBtn, viewBtn;
    EditText getValue, haulier, delivery, destination, variance, loaded, replace, under;
    String mValue, mHaulier, mDelivery, mDestination, mVariance, mLoaded, mReplace, mUnderOver;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry_activity);
        addBtn = findViewById(R.id.add_btn);
        viewBtn = findViewById(R.id.view_btn);
        getValue = findViewById(R.id.truck);
        haulier = findViewById(R.id.haulier);
        delivery = findViewById(R.id.delivery);
        destination = findViewById(R.id.destination);
        variance = findViewById(R.id.variance);
        loaded = findViewById(R.id.loaded);
        replace = findViewById(R.id.replace);
        under = findViewById(R.id.under);

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();


            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();

            }
        });
    }

    private void openActivity() {
        Intent intent = new Intent(this, MainList.class);
        startActivity(intent);

    }
    private void saveData(){
        mValue = getValue.getText().toString().trim();
        mHaulier = haulier.getText().toString().trim();
        mDelivery = delivery.getText().toString().trim();
        mDestination = destination.getText().toString().trim();
        mVariance = variance.getText().toString().trim();
        mLoaded = loaded.getText().toString().trim();
        mReplace = replace.getText().toString().trim();
        mUnderOver = under.getText().toString().trim();


        dbHelper = new DbHelper(this);

        if(mValue.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a Truck No", Toast.LENGTH_SHORT).show();
        }

        if(mHaulier.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a Haulier", Toast.LENGTH_SHORT).show();
        }

        if(mDelivery.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a Delivery No", Toast.LENGTH_SHORT).show();
        }

        if(mDestination.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a Destination", Toast.LENGTH_SHORT).show();
        }
        if(mVariance.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a Variance", Toast.LENGTH_SHORT).show();
        }

        if(mLoaded.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter an Loaded UDV", Toast.LENGTH_SHORT).show();
        }

        if(mReplace.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter a a Replace", Toast.LENGTH_SHORT).show();
        }

        if(mUnderOver.isEmpty()){
            //error name is empty
            Toast.makeText(this, "You must enter an UnderOver", Toast.LENGTH_SHORT).show();
        }
        //create new person
        Data data = new Data(mValue, mHaulier, mDelivery, mDestination, mVariance,mLoaded,mReplace,mUnderOver);
        dbHelper.saveNewData(data);

        //finally redirect back home
        // NOTE you can implement an sqlite callback then redirect on success delete
       // goBackHome();
        Toast.makeText(this,"saved successfully",Toast.LENGTH_LONG).show();

    }
    private void goBackHome(){
        startActivity(new Intent(EntryActivity.this, MainActivity.class));
    }
}

