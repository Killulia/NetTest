package com.bksx.nettest.fragment;

import android.Manifest;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bksx.nettest.BuildConfig;
import com.bksx.nettest.R;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class PermissionFragment extends Fragment implements View.OnClickListener {


    private static final int REQUEST_CAMERA_PERMISSION = 101;
    private static boolean isNeverRequest = false;


    public PermissionFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        final RxPermissions rxPermissions = new RxPermissions(this);
//        rxPermissions.requestEach(Manifest.permission.CAMERA)
//                .subscribe(permission -> {
//                    if (permission.granted) {
//                        show("用户给权限啦");
//                        doWork();
//                        return;
//                    }
//                    if ((!permission.shouldShowRequestPermissionRationale) && (!permission.granted)){
//                        show("用户不再询问");
//                        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");//魅族的
//                        intent.addCategory(Intent.CATEGORY_DEFAULT);
//                        intent.putExtra("packageName", BuildConfig.APPLICATION_ID);
//                        startActivity(intent);
//                    }
//                    if (permission.shouldShowRequestPermissionRationale) {
//                        show("用户不给权限");
//                        return;
//                    }
//                    show("弹窗不显示");
//                });
    }


     void show(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
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
        Log.d("ccg", "ON RESUME");
        super.onResume();
//        openCamera();

    }
//
    //TODO原始方法
//    private void openCamera() {
//        Log.d("ccg", "OPEN CAMERA");
//        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)
//                != PackageManager.PERMISSION_GRANTED) {
////            requestCameraPermission()
//            if (!isNeverRequest) {
//                requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
//            } else {//TODO 点击过不再询问之后，引导用户跳到系统设置
//                Log.d("ccg", "never");
//                Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");//魅族的
//                intent.addCategory(Intent.CATEGORY_DEFAULT);
//                intent.putExtra("packageName", BuildConfig.APPLICATION_ID);
//                startActivity(intent);
//
//
//            }
//
//
//        }else {
//            doWork();
//        }
//
//
//    }

    /**
     * 请求权限
     */
//    private void requestCameraPermission() {
//        Log.d("ccg", "requestCameraPermission");
//        if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){//点击拒绝后
//            new Camera2BasicFragment.ConfirmationDialog().show(getChildFragmentManager(),"点击拒绝后");
//        }else {//点击过允许或者不再询问，第一次进必走这里
//            Log.d("ccg", "sury");
//            requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA_PERMISSION);
//        }
//    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == REQUEST_CAMERA_PERMISSION) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Log.d("ccg", "已授权");
//                doWork();
//            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED && shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
//                Log.d("ccg", "拒绝"+grantResults[1]);
//            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED && !shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
//                Log.d("ccg", "不再询问");
//                isNeverRequest = true;
//
//            }
//
//        } else {
//            Log.d("ccg", "默认");
//            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        }
//    }


//    private void doWork() {
//        Log.d("ccg", "具体工作");
//    }
    public static PermissionFragment newInstance() {
        return new PermissionFragment();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.picture: {
//                openCamera();
//                doWork();
                //TODO 不直接调用doWork,要像 下面这样写法
                PermissionFragmentPermissionsDispatcher.doWorkWithPermissionCheck(this);
                break;
            }
        }
    }


//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        PermissionFragmentPermissionsDispatcher.onRequestPermissionsResult(this,requestCode,grantResults);
//    }


    @NeedsPermission(Manifest.permission.CAMERA)
    void doWork() {
        Log.d("ccg", "具体工作");
    }

    @OnNeverAskAgain(Manifest.permission.CAMERA)
    void doNever() {
        Log.d("ccg", "不再询问");
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");//魅族的
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("packageName", BuildConfig.APPLICATION_ID);
        startActivity(intent);
    }

    @OnPermissionDenied(Manifest.permission.CAMERA)
    void doDenied() {
        Log.d("ccg", "拒绝");
    }




}
