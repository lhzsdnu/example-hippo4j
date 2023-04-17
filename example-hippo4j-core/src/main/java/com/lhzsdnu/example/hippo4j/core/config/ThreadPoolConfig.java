package com.lhzsdnu.example.hippo4j.core.config;

import cn.hippo4j.core.enable.EnableDynamicThreadPool;
import cn.hippo4j.core.executor.DynamicThreadPool;
import cn.hippo4j.core.executor.support.ThreadPoolBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>
 * 线程池 配置
 * </p>
 *
 * @author lhz
 */
@EnableDynamicThreadPool
@Configuration
public class ThreadPoolConfig {

    @DynamicThreadPool
    @Bean
    public ThreadPoolExecutor messageDynamicExecutor() {
        // 服务端创建的线程池ID
        String threadPoolId = "message";

        // 通过 ThreadPoolBuilder 构建动态线程池，只有 threadFactory、threadPoolId 为必填项，其它参数会从配置中心拉取
        return ThreadPoolBuilder.builder().threadFactory(threadPoolId).threadPoolId(threadPoolId)
                .dynamicPool()
                .build();
    }

}