package com.wander.train;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * @author 86191
 */

@SpringBootApplication
@EnableCaching
public class TrainApplication {


    public static void main(String[] args) {
        SpringApplication.run(TrainApplication.class, args);
    }



}
