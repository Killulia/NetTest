package com.example.artexploration.part12;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.example.artexploration.R;
import com.example.artexploration.part12.adapter.ImageAdapter;
import com.example.artexploration.part12.constant.ImgUrl;

import androidx.appcompat.app.AppCompatActivity;

public class GridviewActivity extends AppCompatActivity {

    GridView gridView;
    ImageAdapter adapter;
    String string = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        gridView = findViewById(R.id.gridview1);
        adapter = new ImageAdapter(ImgUrl.getUrls(), this);
        gridView.setAdapter(adapter);
        if (string.length()>0){
            Log.d("ccg", "s");
        }

    }
}
