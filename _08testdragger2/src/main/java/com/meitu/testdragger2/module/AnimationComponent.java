package com.meitu.testdragger2.module;

import com.meitu.testdragger2.test1.MainActivity;

import dagger.Component;

/**
 * @Author shaowenwen
 * @Date 2020-09-06 11:07
 */
@Component(modules = AnimationModule.class)
public interface AnimationComponent {

    void injectAnimation(MainActivity mainActivity);

}
