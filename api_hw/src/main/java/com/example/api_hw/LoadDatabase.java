package com.example.api_hw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//The following class will get loaded automatically by Spring:
//這LoadDB是要來將新資料存到資料庫用的，會請SPRING幫助自動載入，透過Repository介面來寫入DB
@Configuration//這個annotation其中一個用法是搭配@Bean來宣告下面的initDatabase是Bean
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {//這邊是需要透過Repository來幫忙寫入DB
  
      return args -> {
        log.info("Preloading " + repository.save(new Employee("Bilbo", "Baggins", "burglar")));
        log.info("Preloading " + repository.save(new Employee("Frodo", "Baggins", "thief")));      };
    }
}

