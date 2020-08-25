package com.bksx.customview.customview;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import com.bksx.customview.R;
import com.bksx.customview.Utils;

import java.util.Objects;

public class MyDialogFragment extends DialogFragment {

    private View rootView;

//    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        View view = Objects.requireNonNull(getActivity()).getLayoutInflater().inflate(R.layout.fragment_dialog, null, false);
//        Dialog dialog = new Dialog(getActivity());
//        // 关闭标题栏，setContentView() 之前调用
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(view);
//        dialog.setCanceledOnTouchOutside(false);
//        return dialog;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("ccg", "onCreateView");
        if (container == null){
            Log.d("ccg", "container == null" );
        }
        final Window window = getDialog().getWindow();
        rootView = Objects.requireNonNull(getActivity()).getLayoutInflater().inflate(R.layout.fragment_dialog, ((ViewGroup) window.findViewById(android.R.id.content)), false);
//        rootView = Objects.requireNonNull(getActivity()).getLayoutInflater().inflate(R.layout.fragment_dialog, container, false);
//        WindowManager.LayoutParams lp = getDialog().getWindow().getAttributes();
//        lp.width = rootView.getLayoutParams().width;
//        lp.height = rootView.getLayoutParams().height;
//        Log.d("ccg", "clRoot-width:" + rootView.getLayoutParams().width);
//        Log.d("ccg", "clRoot-height:" + rootView.getLayoutParams().height);
//        window.setLayout(lp.width, lp.height);
        return rootView;
    }


    @Override
    public void onStart() {
        Log.d("ccg", "onStart");
        super.onStart();


    }

    @Override
    public void onResume() {
        super.onResume();
        resizeDialogFragment();
    }

    private void resizeDialogFragment() {
        Dialog dialog = getDialog();
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = getDialog().getWindow().getAttributes();
        lp.width = rootView.getLayoutParams().width;
        lp.height = rootView.getLayoutParams().height;
        Log.d("ccg", "cl-width:" + Utils.dp2px(250));
        Log.d("ccg", "cl-height:" + Utils.dp2px(200));
        Log.d("ccg", "clRoot-width:" + rootView.getLayoutParams().width);
        Log.d("ccg", "clRoot-height:" + rootView.getLayoutParams().height);
//        lp.height = (400);//获取屏幕的宽度，定义自己的宽度
//        lp.width = (500);
        if (window != null) {
            window.setLayout(lp.width, lp.height);
        }
    }



}
