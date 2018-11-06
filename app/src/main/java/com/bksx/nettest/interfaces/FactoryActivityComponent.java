package com.bksx.nettest.interfaces;

import com.bksx.nettest.activity.BannerActivity;

import dagger.Component;

@Component
public interface FactoryActivityComponent {
    void inject(BannerActivity bannerActivity);
}
