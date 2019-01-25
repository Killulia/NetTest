package com.example.framework.network;


import android.util.Log;
import com.example.framework.LogUtils;
import com.example.framework.basemodel.BaseModel;
import org.reactivestreams.Subscriber;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import retrofit2.HttpException;

/**
 * create by libo
 * create on 2018/11/13
 * description 自定义请求数据回调和过滤
 */
public abstract class ApiCallBack<M extends BaseModel> implements Observer<M> {

    @Override
    public void onComplete() {
        Log.d("ccg", "onComplete");
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        Log.d("ccg", "onError");
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int code = httpException.code();

            //Http状态码提示
            if (code >=400  && code< 500) {
                LogUtils.e("请求错误");
            } else if (code >= 500) {
                LogUtils.e("服务器错误");
            }
        }
    }

    @Override
    public void onNext(M baseModel) {
        Log.d("ccg", "onNext");
        handleStatusCode(baseModel);
    }

    /**
     * 后台statuscode状态码处理，状态码类型封装在StatusCodeEnum中
     * @param baseModel
     */
    private void handleStatusCode(M baseModel) {
        Log.d("ccg", "handleStatusCode");
        String statusCode = baseModel.code;
        StatusCodeEnum statusCodeEnum = StatusCodeEnum.getByCode(statusCode);
        switch (statusCodeEnum) {
            case RESULT_OK:  //请求成功
                Log.d("ccg", "RESULT_OK");
                onSuccess(baseModel);
                break;
            case RESULT_TOKENINVALID:  //token失效
                // TODO: 2018/11/23 token失效，删除本地用户信息储存并退出登录
                break;
            default:
                LogUtils.e("请求失败错误");
                break;
        }
    }

    /**
     * onSuccess回调的数据为程序具体需要的业务状态码，具体数据等
     */
    public abstract void onSuccess(M m);
}