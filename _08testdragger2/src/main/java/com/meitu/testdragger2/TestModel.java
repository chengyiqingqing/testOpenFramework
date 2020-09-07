package com.meitu.testdragger2;

import javax.inject.Inject;

/**
 * @Author shaowenwen
 * @Date 2020-09-06 08:36
 */
public class TestModel {

    @Inject
    Product mProduct;

    public TestModel() {
        DaggerMainComponent.builder()
                .build()
                .inject(this);
        mProduct.logProduct();
    }

}
