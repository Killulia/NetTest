package com.example.sdkdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

public class MainActivity extends AppCompatActivity {

    private Button btLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btLogin = findViewById(R.id.bt_login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QQ qq = new QQ();
                login(qq);
            }
        });
    }


    private void login(Platform platform) {
        //获取用户信息
        String userId = platform.getDb().getUserId();
        if(!TextUtils.isEmpty(userId))
        {
            //直接跳转到登陆成功的界面
            Log.i("info","not empty");



        }
        else
        {
            //设置平台动作监听
            platform.setPlatformActionListener(new PlatformActionListener() {
                /**
                 * 成功接入
                 * @param platform
                 * @param i:接入的类型【1.要数据不要功能，2.要功能不要数据】
                 * @param hashMap:数据【要依赖于接入的类型】
                 */
                @Override
                public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

                    if(i == Platform.ACTION_AUTHORIZING)//要功能不要数据
                    {
                        //直接跳转到登陆成功的界面
                        Log.i("info","登陆成功");
                    }
                    else if(i == Platform.ACTION_USER_INFOR)//要数据不要功能
                    {
                        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                            Log.i("info","key:"+entry.getKey()+"\tvalue:"+entry.getValue());
                        }
                    }
                }

                /**
                 * 登陆失败
                 * @param platform
                 * @param i
                 * @param throwable:失败的原因
                 */
                @Override
                public void onError(Platform platform, int i, Throwable throwable) {
                    Log.i("info","登陆失败");
                }

                /**
                 * 取消认证
                 * @param platform
                 * @param i
                 */
                @Override
                public void onCancel(Platform platform, int i) {
                    Log.i("info","取消登陆");
                }
            });

            //进行授权--要数据不要功能
            platform.showUser(null);

            //进行授权--要功能不要数据
            //platform.authorize();
        }
    }

}



