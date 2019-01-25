package com.example.framework.mainpage;

import android.util.Log;

import com.example.framework.basemodel.BaseModel;
import com.example.framework.basepresenter.BasePresenter;
import com.example.framework.bean.DataBean;
import com.example.framework.bean.NewsBean;
import com.example.framework.bean.ToutiaoBean;
import com.example.framework.network.ApiCallBack;

import java.util.Map;

import io.reactivex.disposables.Disposable;

public class MainPresenter extends BasePresenter<MainView> {


    public MainPresenter(MainView mainView) {
        attachView(mainView);
    }

    public void getNewsData(Map map) {
        subscribe(apiService.getNewsList(map), new ApiCallBack<BaseModel<NewsBean>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("ccg", "mainp onSubscribe");
                mCompositeSubscription.add(d);
            }

            @Override
            public void onSuccess(BaseModel<NewsBean> toutiaoBeanBaseModel) {
                Log.d("ccg", "mainp success");
                view.getNewsData(toutiaoBeanBaseModel);
            }
        });
    }
}
