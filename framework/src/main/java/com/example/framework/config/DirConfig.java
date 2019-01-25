package com.example.framework.config;

import android.os.Environment;

public class DirConfig {
    /**
     * 请求数据缓存
     */
    public static final String HTTP_CACHE = Environment.getExternalStorageDirectory().getAbsolutePath() + "/httpCache";
}
