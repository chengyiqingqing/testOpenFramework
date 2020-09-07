package com.meitu.testleakcanary;

import android.content.Context;

/**
 * @Author shaowenwen
 * @Date 2020-08-31 07:33
 * 1.单例导致内存泄漏
 */
public class SingletonActivityContext {

    private Context context;

    private SingletonActivityContext() {

    }

    private static final class InnnerHolder {
        private static final SingletonActivityContext instance = new SingletonActivityContext();
    }

    public static SingletonActivityContext getInstance() {
        return InnnerHolder.instance;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
