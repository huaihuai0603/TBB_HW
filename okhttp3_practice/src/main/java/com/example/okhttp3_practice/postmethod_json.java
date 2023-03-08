package com.example.okhttp3_practice;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class postmethod_json {
    public static void main(String[] agrs){
        String url="http://localhost:8080/okhttp3/post/jaon";
        String json="{\"Fundation\":\"testfundation\",\"Address\":\"AAA\"}";
        httpMethod(url,json);
    }

    public static void httpMethod(String url,Sting json){
        OkHttpClient client=new OkHttpClient()
            .newBuilder()
            .connectTimeout(10,TimeUnit.SECONDS)
            .readTimeout(10,TimeUnit.SECONDS)
            .writeTimeout(10,TimeUnit.SECONDS)
            .build();

            RequestBody body=RequestBody.create(json,MediaType.gey("application/json;charset=UTF-8"));

            Request request=new Request.Builder()
            .url(url)
            .post(body)
            .build();
            try(Response response=client.newCall(request).execute()){
                System.out.println("httpMethod 方式二請求返回結果"+response.body().string());
            }
            catch(IOException e){
                e.printStackTrace();
            }
    
    }



    }
}
