package com.example.hencoderplus.gradle;

import android.app.Activity;

import com.example.hencoderplus.PriceUtils;
import com.example.hencoderplus.RangeUtils;
import com.example.hencoderplus.Utils;

public class GradleTest {
    /*  gradle  */
    public static void buildTypeTest(Activity activity) {
        PriceUtils.display();
        RangeUtils.display();
        Utils.drawBadge(activity);
    }
}
