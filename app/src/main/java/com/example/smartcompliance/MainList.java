package com.example.smartcompliance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainList extends AppCompatActivity {
   DbHelper dbHelper;
   List<Data> dataList;
    RecyclerView mRecyclerView;
    DataAdapter dataAdapter;
    Button shareBtn;
     RecyclerView.LayoutManager mLayoutManager;
     String filter = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlist);
        //initialize the variables
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler);
        shareBtn = (Button) findViewById(R.id.shareBtn);
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(),DividerItemDecoration.VERTICAL));

        //populate recyclerview
        populateRecyclerView(filter);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,dataList.toString());
                intent.setType("text/plain");
                startActivity(intent);
            }
        });
        }

    private void populateRecyclerView(String filter){
        dbHelper = new DbHelper(this);
        dataList = dbHelper.dataList(filter);
        dataAdapter = new DataAdapter(dataList, this, mRecyclerView);
        mRecyclerView.setAdapter(dataAdapter);

    }
    @Override
    protected void onResume() {
        super.onResume();
        dataAdapter.notifyDataSetChanged();
    }
    }