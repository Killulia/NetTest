package com.example.artexploration.part10;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.artexploration.part10.action.FOO";
    private static final String ACTION_BAZ = "com.example.artexploration.part10.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.example.artexploration.part10.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.artexploration.part10.extra.PARAM2";

    public MyIntentService() {
       super("hh");
    }




    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            SystemClock.sleep(1000);
            String action = intent.getStringExtra("action");
            if ("kobe".equals(action)) {
                final String param1 = intent.getStringExtra("action");
                Log.d("ccg", "onHandleIntent: "+param1);
            } else if ("tmac".equals(action)) {
                final String param1 = intent.getStringExtra("action");
                Log.d("ccg", "onHandleIntent: "+param1);
            }
        }
    }

    @Override
    public void onDestroy() {
        Log.d("ccg", "service distroyed ");
        super.onDestroy();
    }
}
