package com.meitu.testretrofit;

/**
 * @Author shaowenwen
 * @Date 2020-08-27 21:27
 */
//{
//        "args":{
//              "id":"sww",
//              "sww":"fals"
//        },
//        "headers":{
//              "Accept":"text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
//              "Accept-Encoding":"gzip, deflate",
//              "Accept-Language":"zh-CN,zh;q=0.9",
//              "Host":"httpbin.org",
//              "Upgrade-Insecure-Requests":"1",
//              "User-Agent":"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4238.2 Safari/537.36",
//              "X-Amzn-Trace-Id":"Root=1-5f4a07ab-01f07fe37036b58ba55ff1f8"
//        },
//        "origin":"222.129.130.85",
//        "url":"http://httpbin.org/get?id=sww&sww=fals"
//}
public class UserModel {

    public String sww;
    public String id;

    @Override
    public String toString() {
        return "UserModel{" +
                "sww='" + sww + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}
