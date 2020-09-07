package com.meitu.testdragger2.module;

import dagger.Module;
import dagger.Provides;

/**
 * @Author shaowenwen
 * @Date 2020-09-04 22:49
 */
@Module
public class AnimationModule {

    @Provides
    public Animation provideAnimation(){
        return new Animation();
    }

}
