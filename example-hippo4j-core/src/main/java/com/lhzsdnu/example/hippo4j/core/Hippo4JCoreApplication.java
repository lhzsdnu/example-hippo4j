package com.lhzsdnu.example.hippo4j.core;

import cn.hippo4j.core.enable.EnableDynamicThreadPool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDynamicThreadPool
@SpringBootApplication
public class Hippo4JCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hippo4JCoreApplication.class, args);
    }

}
