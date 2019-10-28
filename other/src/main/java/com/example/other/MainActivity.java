package com.example.other;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.other.fragment.BlankFragment1;
import com.example.other.fragment.BlankFragment2;

public class MainActivity extends AppCompatActivity {

    private BlankFragment1 blankFragment1;
    private BlankFragment2 blankFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ccg", "生命周期-MainActivity-onCreate");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        blankFragment1 = new BlankFragment1();
        blankFragment2 = new BlankFragment2();
        ft.add(R.id.fl_container, blankFragment1, "f1");
        ft.commit();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ccg", "生命周期-MainActivity-onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ccg", "生命周期-MainActivity-onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ccg", "生命周期-MainActivity-onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ccg", "生命周期-MainActivity-onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ccg", "生命周期-MainActivity-onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ccg", "生命周期-MainActivity-onRestart");
    }


}
