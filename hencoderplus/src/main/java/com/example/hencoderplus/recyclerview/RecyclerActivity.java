package com.example.hencoderplus.recyclerview;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hencoderplus.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView rvTest;
    SmartRefreshLayout sl;
    List<User> users = new ArrayList<>();
    DemoAdapter adapter;
    String path = Environment.getExternalStorageDirectory() + File.separator + "test.txt";
    int count = 1;
//    Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*  recyclerView  */
        rvTest = findViewById(R.id.rv_test);
        sl = findViewById(R.id.smart);
        //RecyclerView的原生Bug，在数据更新时会出现Inconsistency detected. Invalid view holder adapter positionViewHolder这个Bug，
        //错误解决的方式是自定义一个LayoutManager，重写onLayoutChildren方法，在遇到这个异常时，直接抛出异常。
        rvTest.setLayoutManager(new WrapContentLinearLayoutManager(this));
        rvTest.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new DemoAdapter(this, users);
        adapter.setOnItemClickListener(new DemoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerActivity.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });
        rvTest.setHasFixedSize(true);//当recyclerviewm高固定，item数量变化且item宽高不变时，避免重新计算item宽高度
        rvTest.setAdapter(adapter);
        sl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                List<User> news = new ArrayList<>();
                news.add(new User("001", "龙珠"));
                news.add(new User("002", "火影"));
                news.add(new User("003", "海贼"));
                news.add(new User("004", "灌篮"));
                User user5 = new User("005", "EVA");
                if (count > 1) {
                    user5.setName("巨人");
                    news.add(new User("006", "高达"));
                }
                news.add(user5);
                adapter.refreshData(news);
                sl.finishRefresh();
                count++;
            }
        });
    }




}
