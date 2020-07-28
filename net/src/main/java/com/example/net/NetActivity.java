package com.example.net;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.net.bean.LoginResponse;
import com.example.net.util.Constans;
import com.example.net.util.OkHttp3Utils;
import com.example.net.util.OkHttpUtil;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetActivity extends AppCompatActivity {

    private OkHttpClient client;
    private Button btSend;
    private TextView tvResponse;
    private HashMap<String, String> headerMap, paramasMap;
    private SobMiniWebInterface sobMiniWebInterface;
    private retrofit2.Call<LoginResponse> call;

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
                paramasMap = new HashMap<>();
                paramasMap.put("glybm", "0812125");
                paramasMap.put("password", "21218cca77804d2ba1922c33e0151105");
                paramasMap.put("imsi", "e1aa424501775aa7");
                paramasMap.put("version", "45");

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constans.LOGIN)
                        .client(OkHttpUtil.getOkHttpSingletonInstance())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                sobMiniWebInterface = retrofit.create(SobMiniWebInterface.class);
                sobMiniWebInterface.getLoginResponse(paramasMap).enqueue(new retrofit2.Callback<LoginResponse>() {
                    @Override
                    public void onResponse(retrofit2.Call<LoginResponse> call, final retrofit2.Response<LoginResponse> response) {
                        if (response.isSuccessful()) {

                            tvResponse.setText(Objects.requireNonNull(response.body()).getReturnMsg());


                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<LoginResponse> call, Throwable t) {

                    }
                });

            }
        });
    }

    private void okHttpTest() {
        headerMap = new HashMap<>();
        headerMap.put("sessionConf", Constans.SEESSION);
        paramasMap = new HashMap<>();
        paramasMap.put("syfw_jzbh", "3cda31b6473e4202abbc46c3c249f8a8");
        try {
            OkHttpUtil.postJSONAsync(Constans.YHXX, paramasMap, null, new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    Log.d("ccg", "error:" + e.getMessage());
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    final String str = response.body().string();
                    if (response.isSuccessful()) {
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

}
