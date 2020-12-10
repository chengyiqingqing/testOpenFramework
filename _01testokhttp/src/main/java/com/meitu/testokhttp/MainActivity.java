package com.meitu.testokhttp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    // 通过
    private OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    return null;
                }
            })
            .addNetworkInterceptor(new Interceptor() {  // 可以重新定义请求体。
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    RequestBody body = request.body();
                    if (body instanceof FormBody) {
                        FormBody formBody = (FormBody) body;
                        Map<String, String> formMap = new HashMap<>();
                        // 从 formBody 中拿到请求参数，放入 formMap 中
                        for (int i = 0; i < formBody.size(); i++) {
                            formMap.put(formBody.name(i), formBody.value(i));
                        }
                        // 将 formMap 转化为 json 然后 AES 加密
//                        Gson gson = new Gson();
//                        String jsonParams = gson.toJson(formMap);
//                        String encryptParams = AESCryptUtils.encrypt(jsonParams.getBytes(CHARSET), AppConstant.getAESKey());
                        // 重新修改 body 的内容
                        body = new FormBody.Builder().add("FORM_NAME", "encryptParams").build();
                    }
                    if (body != null) {
                        request = request.newBuilder()
                                .post(body)
                                .build();
                    }
                    return chain.proceed(request);
                }
            })
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

//    https://www.jianshu.com/p/b7e45037ccd3

}
