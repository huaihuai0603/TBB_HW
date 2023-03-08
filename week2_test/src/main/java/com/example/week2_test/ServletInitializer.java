package com.example.week2_test;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.week2_test.controller.RateApplication;

public class ServletInitializer extends SpringBootServletInitializer {

	// @Override
	// protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	// 	return application.sources(Week2TestApplication.class);
	// }
	//這個事week2 外匯資料查詢的
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RateApplication.class);
	}
}
