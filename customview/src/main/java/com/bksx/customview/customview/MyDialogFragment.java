package com.bksx.customview.customview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bksx.customview.R;

import java.util.Objects;

public class MyDialogFragment extends DialogFragment {

    private View view;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        view = Objects.requireNonNull(getActivity()).getLayoutInflater().inflate(R.layout.fragment_dialog, null, false);
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setTitle("warnning")
//                .setMessage("dangerous")
//                .setPositiveButton("ok", null)
//                .setNegativeButton("cancel", null)
//                .setCancelable(false)
//                .setView(view);
        Dialog dialog = new Dialog(getActivity());
        // 关闭标题栏，setContentView() 之前调用
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
        View clRoot = view.findViewById(R.id.cl_root);
        params.width = clRoot.getLayoutParams().width;
        params.height = clRoot.getLayoutParams().height;
        getDialog().getWindow().setAttributes(params);

        super.onResume();
    }
}
