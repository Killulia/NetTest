package com.example.artexploration;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.artexploration.part3.GuolinLayout;
import com.example.artexploration.part3.SonView;

public class MainActivity extends AppCompatActivity {

    private GuolinLayout guolinLayout;
    private Button btn1,btn2;
    private SonView sonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Context context = this;


    }

    private void initView() {
        testBoolean();
//        guolinLayout = findViewById(R.id.my_layout);
//        btn1 = findViewById(R.id.button1);
//        btn2 = findViewById(R.id.button2);
//        guolinLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.d("TAG", "myLayout on touch");
//                return false;
//            }
//        });
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("TAG", "You clicked button1");
//            }
//        });
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("TAG", "You clicked button2");
//            }
//        });
        sonView = findViewById(R.id.sonView);
        sonView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()!=2){
                    Log.e("TAG", "MainActivity-onTouch:--" + event.getAction());
                }
                return true;
            }
        });
    }

    private void testBoolean() {
        boolean anr = false;
        boolean bnr = false;
        if (!anr && !bnr){
            Log.d("ccg", "1:"+anr);
        }else {
            Log.d("ccg", "2:"+anr);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()!=2){
            Log.e("TAG", "MainActivity-onTouchEvent前:--" + event.getAction());
        }

        boolean result =super.onTouchEvent(event);
        if (event.getAction()!=2){
            Log.e("TAG", "MainActivity-onTouchEvent后:--" + event.getAction()  + "result:"+result);
        }

        return result;
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction()!=2){
            Log.e("TAG", "MainActivity-dispatchTouchEvent前:--" + ev.getAction());
        }

        boolean result =super.dispatchTouchEvent(ev);
        if (ev.getAction()!=2){
            Log.e("TAG", "MainActivity-dispatchTouchEvent后:--" + ev.getAction()  + "result:"+result);
        }

        return result;
    }



}
