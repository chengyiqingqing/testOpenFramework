package com.meitu.testleakcanary;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @Author shaowenwen
 * @Date 2020-08-31 07:39
 * 2.Handler作为非静态内部类 持有外部类引用，造成外部类的内存泄漏
 *
 * 修复方法1：修改为【静态内部类】即可。
 * 修复方法2：将activity修改为弱引用。
 *
 */
public class HandlerLeakActivity extends Activity {

    private final Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 60 * 1000);
        finish();
    }



}
