package com.example.hencoderplus;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.example.hencoderplus.recyclerview.DemoAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends Activity {


    RecyclerView rvTest;
    DemoAdapter adapter = new DemoAdapter(this);
    String path = Environment.getExternalStorageDirectory()+File.separator+"test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //part-recyclerview
        rvTest = findViewById(R.id.rv_test);
        rvTest.setLayoutManager(new LinearLayoutManager(this));
        rvTest.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter.setOnItemClickListner(new DemoAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
            }
        });
        rvTest.setAdapter(adapter);

        //io
        File file = new File(path);
        if (!file.exists()) {
            Log.d("ccg", "io1");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(file);
            writer.write("abc");
            writer.flush();
        } catch (IOException e) {
            Log.d("ccg", "异常："+e.getMessage());
            e.printStackTrace();
        }

    }
}
