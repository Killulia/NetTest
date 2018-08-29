package com.bksx.nettest.testclass;

import android.util.Log;

public class RealT extends BaseT {
    int value = 2;

    @Override
    public void print() {
        Log.d("RealT", "value:" + value);
    }
}
