package com.example.gradletest;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

public class Utils {

    public static void drawLine(Activity activity) {
        ViewGroup decorView = (ViewGroup)activity.getWindow().getDecorView();
        View line = new View(activity);
        line.setBackgroundColor(Color.YELLOW);
        decorView.addView(line,200,100);

    }

}
