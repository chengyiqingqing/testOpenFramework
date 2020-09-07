package com.meitu.testdragger2;

import com.meitu.testdragger2.test1.MainActivity;

import dagger.Component;

/**
 * @Author shaowenwen
 * @Date 2020-09-04 22:52
 */
@Component
public interface MainComponent {

    void inject(MainActivity activity);

    void inject(TestModel testModel);

}
