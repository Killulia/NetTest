package com.example.hencoderplus.recyclerview;

import android.os.Bundle;
import android.os.Environment;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hencoderplus.R;

import java.io.File;

public class RecyclerviewActivity extends AppCompatActivity {

    RecyclerView rvTest;
    DemoAdapter adapter = new DemoAdapter(this);
    String path = Environment.getExternalStorageDirectory() + File.separator + "test.txt";
    Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*  recyclerview  */
        btAdd = findViewById(R.id.bt_add);
        rvTest = findViewById(R.id.rv_test);
        rvTest.setLayoutManager(new LinearLayoutManager(this));
        rvTest.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter.setOnItemClickListner(new DemoAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerviewActivity.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });
        rvTest.setAdapter(adapter);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.insertOne();
            }
        });
    }



}
