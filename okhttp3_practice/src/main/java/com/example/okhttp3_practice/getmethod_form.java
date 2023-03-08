package com.example.okhttp3_practice;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class getmethod_form {
    public static void main(String[]args){
        String url="http://localhost:8080/okhttp3/get/form?Fundation=AAA&Address=BBB";
        OkHttpClient client=new OkHttpClient()
            .newBuilder()
            .connectTimeout(10,TimeUnit.SECONDS)
            .readTimeout(10,TimeUnit.SECONDS)
            .writeTimeout(10,TimeUnit.SECONDS)
            .build();
        Request request =new Request.Builder()
            .url(url)
            .build();
        try(Response response=client.newCall(request).execute()){
            System.out.println("/okhttp3/get/form 返回結果:"+response.body().string());
        }
        catch(IOException e){
            e.printStackTrace();
        }


    }
}
