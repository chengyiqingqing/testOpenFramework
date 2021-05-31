package com.meitu.testretrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.meitu.testretrofit.dynamicProxy.Main;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doMain();
//        doRequest();

        findViewById(R.id.button_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doRequest();
            }
        });
    }

    public void testProxy(String content) {

    }

    public static void doMain() {
        Main.main();
    }



    public void doRequest() {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.baidu.com/")
//                    .baseUrl("http://httpbin.org/")
//                    .baseUrl("http://mock-api.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            TestService testService = retrofit.create(TestService.class);
            Call call = testService.getBaidu("111");
//            Call call = testService.getUserModel("http://httpbin.org/get?id=swwId&sww=false");
//            Call call = testService.getUserModel("http://mock-api.com/aKbvvyKx.mock/user_info?id=1234&name=sww");
//            Call call = testService.getUserModel("1234", "sww");
//            Call call = testService.getUserInfo();
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    Log.e(TAG, "onResponse() called with: response = [" + response.body() + "]");
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    Log.e(TAG, "onFailure() called with: t = [" + t + "]");
                }
            });

            /*call.enqueue(new Callback<ResponseModel>() {

                @Override
                public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                }

                @Override
                public void onFailure(Call<ResponseModel> call, Throwable t) {

                }
            });*/

        } catch (Throwable throwable) {
            Log.e(TAG, "onFailure() called with: t = [" + throwable.getMessage() + "]");
            throwable.printStackTrace();
        }

    }

}
