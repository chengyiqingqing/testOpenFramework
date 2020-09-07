package com.meitu.testdragger2.module;

import android.util.Log;

import javax.inject.Inject;

/**
 * @Description TODO
 * @Author shaowenwen
 * @Date 2020-09-06 08:09
 */
public class Animation {

    private static final String TAG = "Product";

    @Inject
    public Animation() {
    }

    public void logAnimation() {
        Log.e(TAG, "logAnimation: ");
    }

}
