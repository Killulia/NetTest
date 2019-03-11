package com.bksx.nettest.activity;


import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;
import com.bksx.nettest.R;
import com.bksx.nettest.custom.GestureListenerImpl;
import com.bksx.nettest.custom.TestButton;
import com.bksx.nettest.custom.TestLayoyt;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity {

    private TestButton mButton;
    private TestLayoyt mLayout;
    private GestureDetector gestureDetector;
    boolean disallow = true;
    protected static final String TAG = "ccg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        initGesture();
        initView();
    }

    private void initGesture() {
        gestureDetector = new GestureDetector(this,new
                GestureListenerImpl());
    }

    private void initView() {

//        mButton = findViewById(R.id.bt_double);
//        mLayout = findViewById(R.id.myLayout);
//        mLayout.setOnTouchListener(this);
//        mButton.setOnTouchListener(this);

//        mLayout.setOnClickListener(this);
//        mButton.setOnClickListener(this);
//        Toast.makeText(this, "mLayout.isClickable():" + mLayout.isClickable(), Toast.LENGTH_SHORT).show();

    }




//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.bt_double:
//                Toast.makeText(this, "button click", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.myLayout:
//                Toast.makeText(this, "layout click", Toast.LENGTH_SHORT).show();
//                break;
//        }
//    }

//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
////        switch (v.getId()){
////            case R.id.bt_double:
////                Toast.makeText(this, "button touch", Toast.LENGTH_SHORT).show();
////                break;
////            case R.id.myLayout:
////                Toast.makeText(this, "layout touch", Toast.LENGTH_SHORT).show();
////                break;
////        }
////        return false;
//        int action = event.getAction();
//
//        switch (action)
//        {
//            case MotionEvent.ACTION_DOWN:
//                Log.e(TAG, "onTouch ACTION_DOWN");
//                break;
//            case MotionEvent.ACTION_MOVE:
//                Log.e(TAG, "onTouch ACTION_MOVE");
//                break;
//            case MotionEvent.ACTION_UP:
//                Log.e(TAG, "onTouch ACTION_UP");
//                break;
//            default:
//                break;
//        }
//
//        return false;
//
//
//    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "ac-dispatchTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "ac-dispatchTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "ac-dispatchTouchEvent ACTION_UP");
                break;

            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        int action = event.getAction();
//
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                Log.e(TAG, "ac-onTouchEvent ACTION_DOWN");
//                break;
//            case MotionEvent.ACTION_MOVE:
//                Log.e(TAG, "ac-onTouchEvent ACTION_MOVE");
//                break;
//            case MotionEvent.ACTION_UP:
//                Log.e(TAG, "ac-onTouchEvent ACTION_UP");
//                break;
//            default:
//                break;
//        }
//        return super.onTouchEvent(event);


        return gestureDetector.onTouchEvent(event);
    }
}
