package com.example.week2_test.controller;

// // 可以執行，但是只會直接顯示字串（localhost:8080/
// @RestController
// public class userController {
// 	//透過 @RequestMapping 指定從/會被對應到此hello()方法
//   @RequestMapping("/MyFirstPage")
//   public String hello(){
//       return "Hello World!!!";
//   }
// }

//week_2 CRNC_RATE 外匯查詢的作業
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    @Autowired
    private RateRepository RateRepository;

    /**
     * @return
     */
    @GetMapping("/rate")
    public List<Rate> getAllCrncRates() {
        return RateRepository.findAll();
    }
}