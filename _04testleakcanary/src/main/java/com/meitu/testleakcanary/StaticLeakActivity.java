package com.meitu.testleakcanary;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * @Author shaowenwen
 * @Date 2020-08-31 07:39
 * 2.非静态内部类 被创建成静态实例，持有外部类引用，造成外部类的内存泄漏
 *
 * 修复方法：修改为【静态内部类】即可。
 *
 */
public class StaticLeakActivity extends Activity {

    private static NoneStaticClass noneStaticClass = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noneStaticClass = new NoneStaticClass();
    }

    // 修复方法：修改为【静态内部类】即可。
    private class NoneStaticClass {

    }

}
