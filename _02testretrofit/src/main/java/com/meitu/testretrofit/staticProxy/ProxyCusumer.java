package com.meitu.testretrofit.staticProxy;

/**
 * @Description TODO
 * @Author shaowenwen
 * @Date 2020-08-27 21:44
 */
public class ProxyCusumer implements BuyInterface {

    private Cusumer mCusumer;

    public ProxyCusumer(Cusumer mCusumer) {
        this.mCusumer = mCusumer;
    }

    @Override
    public void buy() {
        // TODO: xxx  by shaowenwen 2020-08-27
        // ...

        mCusumer.buy();
    }

}
