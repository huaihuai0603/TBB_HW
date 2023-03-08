package com.example.gov_api_hw_copy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller_govapi {
    //@GetMapping用來指定API端點的路徑，這邊指定"/opendata"
    @GetMapping("/opendata")
    public String getOpenData() {
        //創建一個新的RestTemplate對象
        RestTemplate restTemplate = new RestTemplate();
        //將網址設成url
        String url = "https://ws.yunlin.gov.tw/001/Upload/539/opendata/15369/1540/1b51d152-0925-4b6d-8e8d-1511c9621e41.json";
        //呼叫opendata URL並取得回應資料
        String response = restTemplate.getForObject(url, String.class);
        //將回應資料返回客戶端
        return response;
    }
}
