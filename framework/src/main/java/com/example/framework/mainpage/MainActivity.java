package com.example.framework.mainpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.framework.BaseMvpActivity;
import com.example.framework.R;
import com.example.framework.basemodel.BaseModel;
import com.example.framework.bean.DataBean;
import com.example.framework.bean.NewsBean;
import com.example.framework.bean.ToutiaoBean;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<String, String> map = new HashMap<>();
        map.put("type", "top");
        map.put("key", "6ce2dfc57ad2abef3f6a51cf02cf9993");
        mPresenter.getNewsData(map);

    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void getNewsData(BaseModel<NewsBean> toutiaoBeanBaseModel) {
        Log.d("ccg", "回调");
        for (NewsBean.ResultBean.DataBean datum : toutiaoBeanBaseModel.data.getResult().getData()) {
            Log.d("ccg", "item: "+datum.getTitle());
        }
    }
}
