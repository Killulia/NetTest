package com.bksx.customview;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bksx.customview.customview.CameraView;
import com.bksx.customview.customview.CanvasBitmap;
import com.bksx.customview.customview.CanvasTestView;
import com.bksx.customview.customview.CheckView;
import com.bksx.customview.customview.MeasureTest;
import com.bksx.customview.customview.MyTextView;
import com.bksx.customview.customview.PieView;
import com.bksx.customview.customview.TopBar;
import com.bksx.customview.customview.ValueAnimatorTest;

public class Custom1Activity extends AppCompatActivity {

    private TopBar mCustomView;// 我们的自定义View
    private Button button;
    private ViewWrapper viewWrapper;//包装类




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom1);
        mCustomView = findViewById(R.id.cv_test);
        mCustomView.setTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                finish();
            }

            @Override
            public void rightClick() {
                Toast.makeText(Custom1Activity.this, "more", Toast.LENGTH_SHORT).show();
            }
        });
//        mCustomView.setSweepAngle(30);
        button = findViewById(R.id.bt_test);
        viewWrapper = new ViewWrapper(button);
//        ObjectAnimator animator = ObjectAnimator.ofFloat(button, "rotation", 0f, 360f);
        ObjectAnimator animator = ObjectAnimator.ofInt(viewWrapper, "width", button.getLayoutParams().width, 500);
        animator.setDuration(2000);
        animator.start();
//        new Thread(mCustomView).start();
    }

    /*
    ObjectAnimator属性动画包装类（防止某些类的set get方法已经有别的用处）
     */
    private static class ViewWrapper{

        private View target;

        public ViewWrapper(View target) {
            this.target = target;
        }

        public void setWidth(int width){
            target.getLayoutParams().width = width;
            target.requestLayout();
        }

        public int getWidth(){
            return target.getLayoutParams().width;
        }
    }
}
