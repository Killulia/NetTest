package com.bksx.nettest.activity;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bksx.nettest.R;
import com.bksx.nettest.bean.RegionCode;
import com.bksx.nettest.db.DbManager;
import com.bksx.nettest.gen.RegionCodeDao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GreenDaoActivity extends AppCompatActivity {

    StringBuilder builder;
    List<RegionCode> regionCodes = new ArrayList<>();
    //数据库文件路径
    private static final String DB_PATH = "/data/data/com.bksx.nettest/databases";
    //数据库文件名
    private static final String DB_NAME = "local_database.db";
    Context context = this;
    Handler handler = new Handler();
    RegionCodeDao regionCodeDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao);
        builder = new StringBuilder();
        //测试 kraken
        copyDatabase();
//        quearyAllCodes();
    }

    /**
     * 复制raw下的db文件到database目录
     */
    private void copyDatabase() {
        new Thread(){
            @Override
            public void run() {
                InputStream in = null;
                FileOutputStream out = null;
                String databaseFilename = DB_PATH + "/" + DB_NAME;
                File dir = new File(DB_PATH);
                if (!dir.exists())
                    dir.mkdir();


                File file = new File(databaseFilename);

                if (!file.exists()) {
                    try {
                        Log.d("ccg", "copy");
                        in = context.getResources().openRawResource(R.raw.local_database); // 从raw目录下复制
                        out = new FileOutputStream(file);
                        int length = -1;
                        byte[] buf = new byte[1024];
                        while ((length = in.read(buf)) != -1) {
                            out.write(buf, 0, length);
                        }
                        out.flush();

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (in != null) in.close();
                            if (out != null) out.close();
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    quearyAllCodes();
                                }
                            });

                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
//                            quearyAllCodes();
                            quearySomeCodes("110105022");
                        }
                    });
                }




            }
        }.start();

    }

    /**
     * 模糊条件查询
     * @param condition
     */
    private void quearySomeCodes(String condition) {
        regionCodes.clear();
        regionCodeDao = DbManager.getDaoSession(context).getRegionCodeDao();
        regionCodes.addAll(regionCodeDao.queryBuilder()
                .where(RegionCodeDao.Properties.Id.like("%" + condition + "%"))
                //降序
                .orderDesc(RegionCodeDao.Properties.Id)
                .list());
        printReginCodes();


    }

    /**
     * 由数据库查询所有数据
     */
    private void quearyAllCodes() {
        regionCodeDao = DbManager.getDaoSession(context).getRegionCodeDao();
        regionCodes.addAll(regionCodeDao.loadAll());
        printReginCodes();
    }

    /**
     * 打印查询结果
     */
    private void printReginCodes() {
        Log.d("ccg", "总条数:" + regionCodes.size());
        for (RegionCode regionCode : regionCodes) {
            Log.d("ccg", regionCode.getName()+"\n");
        }
    }
}
