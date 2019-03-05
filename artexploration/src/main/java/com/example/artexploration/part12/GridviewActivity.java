package com.example.artexploration.part12;

import android.os.Bundle;
import android.widget.GridView;

import com.example.artexploration.R;

import androidx.appcompat.app.AppCompatActivity;

public class GridviewActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        gridView = findViewById(R.id.gridview1);

    }
}
