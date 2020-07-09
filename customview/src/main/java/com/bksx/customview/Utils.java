package com.bksx.customview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;

public class Utils {

    public static float dp2px(float dp){
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,dp, Resources.getSystem().getDisplayMetrics());
    }

    public static float sp2px(float sp){
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP,sp, Resources.getSystem().getDisplayMetrics());
    }


    public static Bitmap getHeadImg(Resources res ,int width){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, R.drawable.hencoder, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(res, R.drawable.hencoder, options);
    }

    public static float getZFromCamera(float z,Resources resources) {
        return z * resources.getDisplayMetrics().density;
    }
}