package com.meitu.testblockcanary;

import android.app.Application;

import com.github.moduth.blockcanary.BlockCanary;
import com.github.moduth.blockcanary.BlockCanaryContext;

/**
 * @Author shaowenwen
 * @Date 2020-09-01 22:03
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BlockCanary
                .install(this, new BlockCanaryContext())
                .start();
    }

}
