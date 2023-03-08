package com.example.okhttp3_practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.okhttp3_practice.Fundation;

@RestController
public class GetController {
    @GetMapping(value="/okhttp3/get/params")
    public String getParams(@RequestParam(value="param1")String param1,@RequestParam("param2")String param2){
        System.out.println("==>/okhttp3/get/params,param1:"+param1+",param2:"+param2);
        return "/okhttp3/get/params Success!!!";
    }

    @GetMapping(value="/okhttp3/get/form")
    public String getForm(Fundation fundation){
        System.out.println("==>/okhttp3/get/form,fundation:"+fundation);
        return "/okhttp3/get/form Success!!!";
    }
    }

