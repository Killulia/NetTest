package com.bksx.nettest.db;

import android.content.Context;
import android.util.Log;

import com.bksx.nettest.gen.DaoMaster;
import com.bksx.nettest.gen.DaoSession;
import com.bksx.nettest.gen.RegionCodeDao;
import com.bksx.nettest.utils.MigrationHelper;

import org.greenrobot.greendao.database.Database;

public class Helper extends DaoMaster.DevOpenHelper{


    public Helper(Context context, String name) {
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
