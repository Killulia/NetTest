package com.example.artexploration.part10;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.example.artexploration.R;
import androidx.appcompat.app.AppCompatActivity;

public class ThreadActivity extends AppCompatActivity {

    private static final String TAG = "ccg";
    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        threadLocal.set("主线程");
//        Log.d(TAG, "localMain:"+threadLocal.get());
        new Thread(){
            @Override
            public void run() {
                super.run();
                threadLocal.set("1线程");
                Log.d(TAG, "local1:"+threadLocal.get());
            }
        };
        new Thread(){
            @Override
            public void run() {
                super.run();
//                threadLocal.set("2线程");
                Log.d(TAG, "local2:"+threadLocal.get());
            }
        };
        Intent intent = new Intent(this,MyIntentService.class);
        intent.putExtra("action", "tmac");
        startService(intent);
        intent.putExtra("action", "kobe");
        startService(intent);
        debug();




    }

    public void debug(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            sugar();
            System.out.println(i);
        }
    }

    private void sugar() {
        int count = 100;
        System.out.println(count);
    }


}


