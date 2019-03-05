package com.bksx.nettest.activity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.bksx.nettest.R;
import com.bksx.nettest.testclass.DraggerA;
import com.bksx.nettest.testclass.DraggerB;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class BannerActivity extends AppCompatActivity {
    @Inject
    DraggerA draggerA;
    private Context context = this;
    private List<Integer> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        initImg();
        showDialog();
//        showPopWindow();
    }

    private void initImg() {
        imageList.add(R.mipmap.hahah);
        imageList.add(R.mipmap.tmac);
        imageList.add(R.mipmap.vava);
        imageList.add(R.mipmap.hehe);
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(context);
        //Banner显示多张图片
        View view = LayoutInflater.from(context).inflate(R.layout.showbinner, null);
        dialog.setContentView(view);
        final Banner banner = view.findViewById(R.id.vp_showImg);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(imageList);
        //禁止自动轮播
        banner.isAutoPlay(false);
        banner.start();
        dialog.setContentView(view);
        dialog.show();
        final WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.width = 800;
        params.height = 800;
        dialog.getWindow().setAttributes(params);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


    }

    private void showPopWindow() {
        Toast.makeText(context, "pop", Toast.LENGTH_SHORT).show();
        final PopupWindow popupWindow = new PopupWindow(this);
        //Banner显示多张图片
        View view = LayoutInflater.from(context).inflate(R.layout.showbinner, null);

        final Banner banner = view.findViewById(R.id.vp_showImg);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(imageList);
        //禁止自动轮播
        banner.isAutoPlay(false);
        banner.start();
        popupWindow.setContentView(view);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorAccent)));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(false);

        popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.CENTER, 0, 0);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                popupWindow.dismiss();
            }
        });
    }
}
