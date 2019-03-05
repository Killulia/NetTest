package com.example.artexploration.part12;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;
import com.example.artexploration.R;

import java.util.HashMap;
import java.util.LinkedHashMap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class BitmapActivity extends AppCompatActivity {

    LruCache<String,Bitmap> mMemoryCache;
    Bitmap bitmap,bitmap2,bitCache;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        imageView = findViewById(R.id.img);
        lruCache();
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.wade);
        if (bitmap!=null){
            Log.d("ccg", "bit not null");
        }
        mMemoryCache.put("kingwag", bitmap);
        bitmap2 = mMemoryCache.get("kingwag");
        imageView.setImageBitmap(bitmap2);
    }

    private void lruCache() {
        int maxMemory = (int) (Runtime.getRuntime().totalMemory()/1024);
        int cacheSize = maxMemory / 8;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(@NonNull String key, @NonNull Bitmap value) {
//                return value.getByteCount()/1024;
                return value.getRowBytes()*value.getHeight()/1024;
            }
        };


    }
}
