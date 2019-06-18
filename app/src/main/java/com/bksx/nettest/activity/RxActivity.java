package com.bksx.nettest.activity;

import android.app.Activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bksx.nettest.R;
import com.bksx.nettest.bean.Person;
import com.bksx.nettest.bean.Plan;
import com.bksx.nettest.bean.mob.LoginResponse;
import com.bksx.nettest.bean.mob.RegisterResponse;
import com.bksx.nettest.net.ApiService;
import com.bksx.nettest.utils.Constants;
import com.bksx.nettest.utils.OkHttp3Utils;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RxActivity extends AppCompatActivity implements View.OnClickListener {

    ApiService apiService;
    private Retrofit retrofit;
    private String userName,passWord;
    private EditText edUsername,edPwd;
    private Button btRegist,btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
//        rxTest();
//        rxTest2();

        initNet();
        initView();

    }

    private void initView() {
        edUsername = findViewById(R.id.ed_username);
        edPwd = findViewById(R.id.ed_pwd);
        btRegist = findViewById(R.id.bt_regist);
        btLogin = findViewById(R.id.bt_login);
        btRegist.setOnClickListener(this);
        btLogin.setOnClickListener(this);
    }

    private void initNet() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.MOB_BASE)
                .client(OkHttp3Utils.getOkHttpSingletonInstance())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);

    }

    /*
    用户注册
     */
    private void regist() {

        apiService.regist(Constants.APP_KEY,edUsername.getText().toString(),edPwd.getText().toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterResponse registerResponse) {
                        if ("200".equals(registerResponse.getRetCode())){
                            Toast.makeText(RxActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(RxActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                            Log.d("ccg", registerResponse.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RxActivity.this, "网络故障", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    private void rxTest2() {
        Log.d("ccg", "rx2");
        Observable.just(1,2,3,4,5)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer % 2 == 1;
                    }
                })
//                .map(new Function<Integer, Double>() {
//
//                    @Override
//                    public Double apply(Integer integer) throws Exception {
//                        return Math.sqrt(integer);
//                    }
//                })

                .subscribe(new Observer<Integer>() {
                    private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                Log.d("ccg", "integer:" + String.valueOf(integer));
                if (integer==1){
                    mDisposable.dispose();
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void rxTest() {
        List<Person> personList = getPerson();
        Observable.fromIterable(personList)
                .flatMap(new Function<Person, ObservableSource<Plan>>() {
                    @Override
                    public ObservableSource<Plan> apply(Person person) throws Exception {
                        return Observable.fromIterable(person.getPlanList());
                    }
                })
                .flatMap(new Function<Plan, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Plan plan) throws Exception {
                        return Observable.fromIterable(plan.getActionList());
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {


                        Log.d("ccg:", s);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @NonNull
    private List<Person> getPerson() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<Plan> planList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                Plan plan = new Plan("plan", "Sdas");
                List<String> actionList = new ArrayList<>();
                String a = "person" + i + " plan" + j + " action-a";
                String b = "person" + i + " plan" + j + " action-b";
                String c = "person" + i + " plan" + j + " action-c";
                actionList.add(a);
                actionList.add(b);
                actionList.add(c);
                plan.setActionList(actionList);
                planList.add(plan);
            }
            Person person = new Person("person" + i, planList);
            personList.add(person);
        }
        return personList;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_regist:
                regist();
                break;
            case R.id.bt_login:
                login();
                break;
        }
    }

    private void login() {
        apiService.login(Constants.APP_KEY,edUsername.getText().toString(),edPwd.getText().toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        if ("200".equals(loginResponse.getRetCode())){
                            Toast.makeText(RxActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(RxActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                            Log.d("ccg", loginResponse.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RxActivity.this, "网络故障", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
