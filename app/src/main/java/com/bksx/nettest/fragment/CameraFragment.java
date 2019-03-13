package com.bksx.nettest.fragment;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;

import com.bksx.nettest.R;
import com.bksx.nettest.utils.AutoFitTextureView;
import com.example.android.camera2basic.Camera2BasicFragment;

import java.io.File;

public class CameraFragment extends Fragment implements View.OnClickListener{


    private static final int REQUEST_CAMERA_PERMISSION = 101;

    public CameraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.picture).setOnClickListener(this);
        view.findViewById(R.id.info).setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        openCamera();//TODO 放到按钮的click模拟一下

    }

    private void openCamera() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){
            requestCameraPermission();

        }



    }

    /**
     * 请求权限
     */
    private void requestCameraPermission() {
        if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){//点击拒绝后
            new Camera2BasicFragment.ConfirmationDialog().show(getChildFragmentManager(),"点击拒绝后");
        }else {//点击过允许或者不再询问，第一次进必走这里
            requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CAMERA_PERMISSION){
            if (grantResults.length!=1 || grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                Log.d("ccg", "未授权");
//                requestCameraPermission();
            }
        }else {
            Log.d("ccg", "已授权");
            super.onRequestPermissionsResult(requestCode,permissions,grantResults);
            doWork();
        }
    }

    private void doWork() {
        Log.d("ccg", "具体工作");
    }

    public static CameraFragment newInstance(){
        return new CameraFragment();
    }

    @Override
    public void onClick(View v) {

    }




}
