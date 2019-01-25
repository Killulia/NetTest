package com.example.framework.basepresenter;

import com.example.framework.baseview.IBaseView;
import com.example.framework.network.ApiService;
import com.example.framework.network.NetManager;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * create by libo
 * create on 2018/11/13
 * description presenter基类，绑定observable与subscriber
 */
public class BasePresenter<V extends IBaseView> implements Ipresenter<V> {
    protected V view;
    protected ApiService apiService;
    protected CompositeDisposable mCompositeSubscription;

    @Override
    public void attachView(IBaseView v) {
        this.view = (V) v;
        apiService = NetManager.getApiService();
    }

    @Override
    public void detachView() {
        this.view = null;
        unSubscribe();
    }

    @Override
    public void subscribe(Observable observable, Observer observer) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeDisposable();
        }

        //绑定observable与consumer
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);

    }

    @Override
    public void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.clear();
        }
    }
}
