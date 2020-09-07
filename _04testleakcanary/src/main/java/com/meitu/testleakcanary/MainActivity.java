package com.meitu.testleakcanary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * （1）内存泄漏由谁产生的？导致了谁内存泄漏？
 * （2）常见的内存泄漏方式
 *
 * <p>
 * 原理：watch一个即将要销毁的对象。
 *
 *  内存：
 *  栈：基本类型，对象的引用【是对象的引用，而不是对象】
 *  堆：new出来的对象，或创建的数组。【由gc管理，堆区数据是线程共享的】
 *  方法区：静态区，所有的class对象，【是线程共享的】
 *
 *  为什么会产生内存泄漏？
 *  （1）当一个对象已经不需要再使用了
 *  （2）有些对象只有有限的生命周期
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}
