package com.bksx.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

import com.bksx.customview.customview.CameraView;
import com.bksx.customview.customview.CircleView;
import com.bksx.customview.customview.ClipBitmapView;
import com.bksx.customview.customview.ImageTestView;
import com.bksx.customview.customview.MatrixTestView;
import com.bksx.customview.customview.MatrixView;
import com.bksx.customview.customview.RadarView;
import com.bksx.customview.customview.RectangleView;
import com.bksx.customview.customview.SportView;

public class MainActivity extends AppCompatActivity {


      RectangleView testView;
      ImageView ivAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        ivAnimation.animate()
//                .translationX(Utils.dp2px(200))
//                .setStartDelay(1000)
//                .start();
//        ObjectAnimator animator = ObjectAnimator.ofFloat(testView, "radius", Utils.dp2px(150));
//        animator.setStartDelay(1000);
//        animator.start();

        AnimatorSet animatorSet;
    }

    private void initView() {
        testView = findViewById(R.id.cv_test);
//        ivAnimation = findViewById(R.id.iv_animaition);
    }
}