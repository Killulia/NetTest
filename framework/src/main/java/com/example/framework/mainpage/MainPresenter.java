package com.example.framework.mainpage;

import android.util.Log;

import com.example.framework.basepresenter.BasePresenter;
import com.example.framework.bean.DataBean;
import com.example.framework.bean.ToutiaoBean;
import com.example.framework.network.ApiCallBack;

import java.util.Map;

import io.reactivex.disposables.Disposable;

public class MainPresenter extends BasePresenter<MainView> {


    public MainPresenter(MainView mainView) {
        attachView(mainView);
    }

    public void getNewsData(Map map) {
        subscribe(apiService.getNewsList(map), new ApiCallBack<ToutiaoBean<DataBean>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("ccg", "mainp onSubscribe");
                mCompositeSubscription.add(d);
            }

            @Override
            public void onSuccess(ToutiaoBean<DataBean> toutiaoBeanBaseModel) {
                Log.d("ccg", "mainp success");
                view.getNewsData(toutiaoBeanBaseModel);
            }
        });
    }
}
