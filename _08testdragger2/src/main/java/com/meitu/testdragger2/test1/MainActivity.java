package com.meitu.testdragger2.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.meitu.testdragger2.R;
import com.meitu.testdragger2.TestModel;
import com.meitu.testdragger2.module.Animation;
import com.meitu.testdragger2.module.DaggerAnimationComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DaggerMainComponent.builder()
//                .build()
//                .inject(this);
//        mProduct.logProduct();
//        animation.logAnimation();

        new TestModel();

        DaggerAnimationComponent.builder()
                .build()
                .injectAnimation(this);
        animation.logAnimation();

    }

}
