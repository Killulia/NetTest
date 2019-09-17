package com.bksx.nettest.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.bksx.nettest.R;
import com.bksx.nettest.fragment.BuildingFragment;
import permissions.dispatcher.RuntimePermissions;

public class UnitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        initFragment();
    }

    private void initFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.cl_root, BuildingFragment.newInstance("",""))
                .commit();
    }





}
