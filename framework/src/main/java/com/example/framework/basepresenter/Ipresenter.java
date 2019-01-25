package com.example.framework.basepresenter;

import com.example.framework.baseview.IView;

import org.reactivestreams.Subscriber;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

/**
 * create by libo
 * create on 2018/11/13
 * description
 */
public interface Ipresenter<V extends IView> {
    /**
     * 关联P与V
     * @param v
     */
    void attachView(V v);

    /**
     * 取消关联P与V
     */
    void detachView();

    /**
     * Rx订阅
     */
    void subscribe(Observable observable, Observer observer);

    /**
     * Rx取消订阅
     */
    void unSubscribe();
}
