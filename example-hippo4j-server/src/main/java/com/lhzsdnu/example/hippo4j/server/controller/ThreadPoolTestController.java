package com.lhzsdnu.example.hippo4j.server.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@RestController
public class ThreadPoolTestController {

    @Resource
    private ThreadPoolExecutor messageDynamicExecutor;

    @GetMapping("hippo4j-server")
    public void task() {
        log.info("线程池【messageDynamicExecutor】: {}", JSON.toJSON(messageDynamicExecutor));

        CompletableFuture.runAsync(() -> {
            log.info("当前线程: " + Thread.currentThread().getId());
        }, messageDynamicExecutor);
    }

}
