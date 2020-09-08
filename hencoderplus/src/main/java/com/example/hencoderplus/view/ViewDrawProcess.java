package com.example.hencoderplus.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hencoderplus.R;

public class ViewDrawProcess extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        textView = findViewById(R.id.tvViewProcess);
        textView.setText(Thread.currentThread().getName());

    }
}
