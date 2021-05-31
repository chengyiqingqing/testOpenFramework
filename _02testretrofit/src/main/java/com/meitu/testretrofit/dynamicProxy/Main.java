package com.meitu.testretrofit.dynamicProxy;

import android.util.Log;

import com.meitu.testretrofit.staticProxy.BuyInterface;
import com.meitu.testretrofit.staticProxy.Cusumer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description TODO
 * @Author shaowenwen
 * @Date 2020-08-27 21:59
 */
public class Main {

    private static final String TAG = "Main";
    public static void main() {

        final Cusumer cusumer = new Cusumer();
        BuyInterface buyInterface = (BuyInterface) Proxy.newProxyInstance(cusumer.getClass().getClassLoader(),
                cusumer.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
//                        return method.invoke(cusumer, objects);
                        Log.e(TAG, "buy111() called:消费者购买");
                        method.invoke(cusumer, objects);
                        return null;
                    }
                });
        buyInterface.buy();

/*        Cusumer buyInterface = (Cusumer) Proxy.newProxyInstance(cusumer.getClass().getClassLoader(),
                cusumer.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        return method.invoke(cusumer, objects);
                    }
                });
        buyInterface.buy();*/

    }

}
