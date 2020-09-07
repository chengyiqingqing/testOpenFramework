package com.meitu.testretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * @Author shaowenwen
 * @Date 2020-08-27 21:19
 */
public interface TestService {

    /*@GET("user/{name}")
    Call getUserInfo(@Path("name") String name);*/

    @GET("/get?id=sww&sww=fals")
    Call getUserInfo();
//    Call getUserInfo(@Query("id") String id, @Query("sww") String name);

    @GET
    Call<String> getBaidu(@Url String url);

    @GET
    Call<ResponseModel> getUserModel(@Url String url);

    @GET("/aKbvvyKx.mock/user_info")
    Call<ResponseModel> getUserModel(@Query("id") String id, @Query("name") String name);

}
