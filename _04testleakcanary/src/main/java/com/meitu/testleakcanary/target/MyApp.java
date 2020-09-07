package com.meitu.testleakcanary.target;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * @Author shaowenwen
 * @Date 2020-08-31 20:39
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

}
