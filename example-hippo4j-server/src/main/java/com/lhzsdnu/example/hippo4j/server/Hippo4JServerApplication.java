package com.lhzsdnu.example.hippo4j.server;

import cn.hippo4j.core.enable.EnableDynamicThreadPool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDynamicThreadPool
@SpringBootApplication
public class Hippo4JServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hippo4JServerApplication.class, args);
    }

}
