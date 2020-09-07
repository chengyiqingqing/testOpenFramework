package com.meitu.testdragger2;

import android.util.Log;

import javax.inject.Inject;

/**
 * @Description TODO
 * @Author shaowenwen
 * @Date 2020-09-04 22:50
 */
public class Product {

    private static final String TAG = "Product";

    @Inject
    public Product() {
    }

    public void logProduct(){
        Log.e(TAG, "logProduct: " );
    }

}
