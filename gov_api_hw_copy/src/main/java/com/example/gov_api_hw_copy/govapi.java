package com.example.gov_api_hw_copy;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class govapi {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://ws.yunlin.gov.tw/001/Upload/539/opendata/15369/1540/1b51d152-0925-4b6d-8e8d-1511c9621e41.json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String jsonData = response.body().string();
                System.out.println(jsonData);
            } else {
                System.out.println("Failed to retrieve data: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}
