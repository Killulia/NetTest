package com.bksx.nettest;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Config;

import com.bksx.nettest.db.DbManager;
import com.bksx.nettest.db.Helper;
import com.bksx.nettest.gen.DaoMaster;
import com.bksx.nettest.gen.DaoSession;
import com.bksx.nettest.utils.MigrationHelper;
import com.orhanobut.logger.Logger;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;


public class BaseApplication extends Application{
    private DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
//        MobSDK.init(this);
        initGreenDao();
        UMShareAPI.get(this);//初始化sdk
        UMConfigure.init(this,"5badc945f1f55634ef000184","Umeng", UMConfigure.DEVICE_TYPE_PHONE,"");
        UMConfigure.setLogEnabled(true);
        //开启debug模式，方便定位错误，具体错误检查方式可以查看http://dev.umeng.com/social/android/quick-integration的报错必看，正式发布，请关闭该模式
//        Config.DEBUG = true;

    }

    /**
     * 初始化GreenDao
     */
    private void initGreenDao() {
//        daoSession = DbManager.getDaoSession(getApplicationContext());
//        mDevOpenHelper = new Helper(getApplicationContext(), DB_NAME);
//        Helper helper = new Helper(this,"local_database.db");//自定义的 OpenHelper
//        SQLiteDatabase db = helper.getWritableDatabase();
//        DaoMaster daoMaster = new DaoMaster(db);
//        daoSession = daoMaster.newSession();


    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    //各个平台的配置
    {
        //微信
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
//        //新浪微博(第三个参数为回调地址)
//        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad","http://sns.whalecloud.com/sina2/callback");
//        //QQ
//        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }

}
