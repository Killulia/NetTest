package com.example.hencoderplus.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hencoderplus.R;

public class ViewDrawProcess extends Activity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        textView = findViewById(R.id.tvViewProcess);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        v.requestLayout();
                        textView.setText(Thread.currentThread().getName());
                    }
                });
                thread.start();
            }
        });




    }
}
