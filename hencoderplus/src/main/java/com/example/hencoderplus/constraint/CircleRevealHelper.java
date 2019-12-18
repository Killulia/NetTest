package com.example.hencoderplus.constraint;

import android.animation.Animator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CircleRevealHelper extends ConstraintHelper {
    public CircleRevealHelper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void updatePostLayout(ConstraintLayout container) {
        super.updatePostLayout(container);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View[] views = getViews(container);
            for (View view : views) {
                Animator anim = ViewAnimationUtils.createCircularReveal(view, view.getWidth() / 2,
                        view.getHeight() / 2, 0f,
                        (float) Math.hypot((view.getHeight() / 2), (view.getWidth() / 2)));
                anim.setDuration(3000);
                anim.start();
            }

        }
    }
}
