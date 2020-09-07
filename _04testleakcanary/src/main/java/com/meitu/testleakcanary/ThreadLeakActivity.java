package com.meitu.testleakcanary;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * @Author shaowenwen
 * @Date 2020-08-31 07:53
 * 4.将Thread对象与AsyncTask定义为非静态内部类，造成造成内存泄漏
 *
 * 修复方法1：修改为【静态内部类】即可。
 * 修复方法2：将activity以弱引用的形式进行传入，以调用。
 *
 */
public class ThreadLeakActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void testThreadLeak() {
        AsyncTask asyncTask = new AsyncTask<Void,Void,Void>() {


            @Override
            protected Void doInBackground(Void... voids) {
                return null;
            }
        };
        asyncTask.execute();

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

    }

}
