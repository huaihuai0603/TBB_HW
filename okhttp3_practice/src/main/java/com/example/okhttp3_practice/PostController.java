package com.example.okhttp3_practice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.okhttp3_practice.Fundation;

@RestController
public class PostController {
    @PostMapping(value="/okhttp3/post/json"
    ,consumes={MediaType.APPLICATION_JSON_UTF8_VALUE}
    ,produces={MediaType.APPLICATION_JSON_UTF8_VALUE})
    
    public String json(@RequestBody Fundation fundation){
        System.out.println("==>/okhttp3/post/json:"+fundation);
        return "okhttp3/post/json SUCCESS!";
    }
    
}
