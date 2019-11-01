package com.bksx.nettest.db;

import android.content.Context;
import android.util.Log;

import com.bksx.nettest.gen.DaoMaster;


import org.greenrobot.greendao.database.Database;

public class Helper extends DaoMaster.DevOpenHelper{


    Helper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        if (oldVersion<newVersion){
            //升级操作
            Log.d("akb", "oldVersion  <  newVersion");
        }else {
            Log.d("akb", "oldVersion  >=  newVersion");
        }
    }
}
