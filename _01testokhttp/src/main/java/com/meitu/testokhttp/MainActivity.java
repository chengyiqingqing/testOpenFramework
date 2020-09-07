package com.meitu.testokhttp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    // 通过
    private OkHttpClient client = new OkHttpClient
            .Builder()
            .readTimeout(5, TimeUnit.SECONDS) // 超时时间为5s
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                syncRequest();
            }
        }).start();*/

        asynncRequest();

    }

    public void syncRequest(){
        Request request = new Request.Builder()
                .get()
                .url("https://www.baidu.com/")
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            Log.e(TAG, "syncRequest: " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void asynncRequest() {
        Request request = new Request.Builder()
                .get()
//                .url("https://www.baidu.com/")
//                .url("http://httpbin.org/get?id=sww&sww=fals")
                .url("http://mock-api.com/aKbvvyKx.mock/user_info?id=1234&name=sww")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e(TAG, "onResponse: " + response.body().string());
            }
        });
    }

}
