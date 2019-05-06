package com.example.artexploration.part12;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListView;

import com.example.artexploration.R;
import com.example.artexploration.part12.adapter.ImageAdapter;
import com.example.artexploration.part12.constant.ImgUrl;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class GridviewActivity extends AppCompatActivity {

    ListView gridView;
    ImageAdapter adapter;
    boolean able = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        gridView = findViewById(R.id.gridview1);
        adapter = new ImageAdapter(ImgUrl.getUrls(), this);
        gridView.setAdapter(adapter);
        gridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
                    able = true;
                    adapter.notiAble(able);
                    adapter.notifyDataSetChanged();
                }else {
                    able = false;
                    adapter.notiAble(able);
                }


            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });


    }
}
