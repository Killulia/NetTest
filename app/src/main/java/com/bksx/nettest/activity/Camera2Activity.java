package com.bksx.nettest.activity;

import android.os.Bundle;

import com.bksx.nettest.R;
import com.bksx.nettest.testclass.DraggerA;
import com.bksx.nettest.testclass.DraggerA_Factory;
import com.bksx.nettest.testclass.DraggerB;
import com.example.android.camera2basic.Camera2BasicFragment;

import androidx.appcompat.app.AppCompatActivity;

public class Camera2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera2);
        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2BasicFragment.newInstance())
                    .commit();
        }

    }
}
