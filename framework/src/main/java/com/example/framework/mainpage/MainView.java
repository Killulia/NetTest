package com.example.framework.mainpage;

import com.example.framework.baseview.IBaseView;
import com.example.framework.bean.DataBean;
import com.example.framework.bean.ToutiaoBean;

public interface MainView extends IBaseView {

    void getNewsData(ToutiaoBean<DataBean> toutiaoBeanBaseModel);
}
