package com.bksx.mvptest.view.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.bksx.mvptest.presenter.MainPresenterImpl;
import com.bksx.mvptest.R;
import com.bksx.mvptest.util.Constans;
import com.bksx.mvptest.view.interfaces.MainView;
import java.io.File;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MainView {

    ProgressBar pb;
    ImageView ivImg;
    Button btDown;
    final String IMG_PATH = Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator  +"tesla.jpg";
    MainPresenterImpl mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mainPresenter = new MainPresenterImpl(this);

    }

    private void initView() {
        pb = findViewById(R.id.pb);
        ivImg = findViewById(R.id.iv_img);
        btDown = findViewById(R.id.bt_down);
        btDown.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        try {
            mainPresenter.loadImg(Constans.IMG_URL,IMG_PATH);//改成retrofit+rxjava后第一个参数没用
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showImg(final Bitmap bitmap) {
        //okhttp 写法:因为回调在子线程，需要切换到ui线程
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                ivImg.setImageBitmap(bitmap);
//            }
//        });

        //RxJava
        ivImg.setImageBitmap(bitmap);

    }
}
