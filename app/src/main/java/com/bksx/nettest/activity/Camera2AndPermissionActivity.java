package com.bksx.nettest.activity;

import android.os.Bundle;

import com.bksx.nettest.R;
import com.bksx.nettest.fragment.PermissionFragment;


import androidx.appcompat.app.AppCompatActivity;


public class Camera2AndPermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera2);
        if (null == savedInstanceState) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, PermissionFragment.newInstance())
                    .commit();
        }

    }
}
