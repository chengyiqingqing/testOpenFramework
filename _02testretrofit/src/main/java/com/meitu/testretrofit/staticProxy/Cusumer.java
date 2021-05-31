package com.meitu.testretrofit.staticProxy;

import android.util.Log;

/**
 * @Author shaowenwen
 * @Date 2020-08-27 21:43
 */
public class Cusumer implements BuyInterface {

    private static final String TAG = "Custumer";

    @Override
    public void buy() {
        Log.e(TAG, "buy() called:消费者购买");
    }

}
