package com.bksx.nettest.activity;

import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewConfiguration;
import android.widget.ListView;
import android.widget.Toast;

import com.bksx.nettest.R;
import com.bksx.nettest.adapter.NewsAdapter;
import com.bksx.nettest.bean.NewsBean;
import com.bksx.nettest.testclass.Crash;
import com.bksx.nettest.testclass.Gerbil;
import com.bksx.nettest.testclass.Hamster;
import com.bksx.nettest.testclass.Hero;
import com.bksx.nettest.testclass.Mouse;
import com.bksx.nettest.testclass.RealT;
import com.bksx.nettest.testclass.Rodent;
import com.bksx.nettest.testclass.Test;
import com.bksx.nettest.testpackage.InterfaceTest;
import com.bksx.nettest.utils.Constants;
import com.bksx.nettest.utils.OkHttpUtil;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    List<NewsBean.ResultBean.DataBean> dataBeans = new ArrayList<>();
    NewsAdapter adapter;
    ListView mListView;
    Rodent[] rodents = new Rodent[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initView();
//        loadData(Constants.NEWS_URL);
//        rodents[0] = new Mouse();
//        rodents[1] = new Gerbil();
//        rodents[hehe] = new Hamster();
//        for (Rodent rodent : rodents) {
//            rodent.play();
//        }
//        Crash crash = new Crash() {
//            @Override
//            public void test() {
//                super.test();
//            }
//        };
//        crash.test();
        InterfaceTest interfaceTest = new InterfaceTest();
        interfaceTest.doF(interfaceTest);
        RealT realT = new RealT();
//        realT.print();
        Hero hero = new Hero();
        hero.speak();
        hero.say();
        boolean hasAnnotation = Hero.class.isAnnotationPresent(Test.class);
        Log.d("ccg", "hasAnnotation:" + hasAnnotation);
        if ( hasAnnotation ) {
            Test testAnnotation = Hero.class.getAnnotation(Test.class);

            Log.d("ccg", "testAnnotation.id():" + testAnnotation.id());
            ViewConfiguration.get(getApplicationContext()).getScaledTouchSlop();
        }

    }

    private void initView() {
        mListView = findViewById(R.id.lv_news);
        adapter = new NewsAdapter(this, dataBeans);
        mListView.setAdapter(adapter);
    }

    private void loadData(String url) {
        OkHttpUtil.doAsycGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("ccg", "faile");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    String jsonString = response.body().string();
                    Gson gson = new Gson();
                    final NewsBean newsBean = gson.fromJson(jsonString, NewsBean.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.addData(newsBean.getResult().getData(),true);
                        }
                    });

                }
            }
        });
    }
}
