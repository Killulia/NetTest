package com.bksx.nettest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bksx.nettest.R;
import com.bksx.nettest.bean.Person;
import com.bksx.nettest.bean.Plan;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class RxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        rxTest();
    }

    private void rxTest() {
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
}
