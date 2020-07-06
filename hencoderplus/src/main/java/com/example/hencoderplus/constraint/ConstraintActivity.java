package com.example.hencoderplus.constraint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;

import com.example.hencoderplus.R;

public class ConstraintActivity extends AppCompatActivity {

    ConstraintSet constraintSet1 = new ConstraintSet();
    ConstraintSet constraintSet2 = new ConstraintSet();
    ConstraintLayout constraintLayout;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*  constraintlyout-base    */
//        setContentView(R.layout.constraint_base);

        /* constraintlyout-barrier_and_chain */
//        setContentView(R.layout.constraint_barrier_and_chain);

        /* constraintlyout-flow_and_set */
//        setContentView(R.layout.constraint_flow);
//        constraintLayout = findViewById(R.id.cl_flow);
//        imageView = findViewById(R.id.iv_1);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onApplyClick(v);
//            }
//        });

        /* constraintlyout-review */
        setContentView(R.layout.constraint_review1);

    }


    public void onApplyClick(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);//过度动画
        constraintSet1.clone(this,R.layout.constraint_flow_set);
        constraintSet1.applyTo(constraintLayout);
    }
}
