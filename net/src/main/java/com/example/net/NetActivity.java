package com.example.net;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.net.util.Constans;
import com.example.net.util.OkHttp3Utils;
import com.example.net.util.OkHttpUtil;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class NetActivity extends AppCompatActivity {

    private OkHttpClient client;
    private Button btSend;
    private TextView tvResponse;
    private HashMap<String, String> headerMap,paramasMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        initView();
    }

    private void initView() {
        btSend = findViewById(R.id.bt_send);
        tvResponse = findViewById(R.id.tv_response);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerMap = new HashMap<>();
                headerMap.put("sessionConf", Constans.SEESSION);
                paramasMap = new HashMap<>();
                paramasMap.put("syfw_jzbh", "c7184ace74fe453e9234e808d64bbcd7");
                try {
                    OkHttpUtil.postJSONAsync(Constans.YHXX, paramasMap, headerMap, new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull IOException e) {
                            Log.d("ccg", "error:" + e.getMessage());
                        }

                        @Override
                        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                            final String str = response.body().string();
                            Log.d("ccg", "onResponse:" + str);
                            if (response.isSuccessful()){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tvResponse.setText(str);
                                    }
                                });

                            }
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
