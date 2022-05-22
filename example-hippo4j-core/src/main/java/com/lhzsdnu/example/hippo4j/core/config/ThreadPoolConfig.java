package com.lhzsdnu.example.hippo4j.core.config;

import com.lhzsdnu.example.hippo4j.core.util.ThreadPoolUtil;

import cn.hippo4j.core.executor.DynamicThreadPool;
import cn.hippo4j.core.executor.support.ResizableCapacityLinkedBlockIngQueue;
import cn.hippo4j.core.executor.support.ThreadPoolBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 线程池 配置
 * </p>
 *
 * @author lhz
 */
@Configuration
public class ThreadPoolConfig {

    @Bean
    @DynamicThreadPool
    public ThreadPoolExecutor messageDynamicExecutor() {
        // 服务端创建的线程池ID
        String threadPoolId = "message";

        // 通过 ThreadPoolBuilder 构建动态线程池，只有 threadFactory、threadPoolId 为必填项，其它参数会从配置中心拉取
        return ThreadPoolBuilder.builder().threadFactory(threadPoolId).threadPoolId(threadPoolId)
                .corePoolSize(ThreadPoolUtil.calculateCoreNum())
                .maxPoolNum(ThreadPoolUtil.calculateMaxNum())
                .keepAliveTime(30, TimeUnit.SECONDS)
                .workQueue(new ResizableCapacityLinkedBlockIngQueue<>(512))
                // 拒绝策略
                .rejected(new ThreadPoolExecutor.CallerRunsPolicy())
                // 是否允许核心线程超时
                .allowCoreThreadTimeOut(false)
                // 等待所有任务结束后再关闭线程池
                .waitForTasksToCompleteOnShutdown(true)
                // 等待任务完成的时间
                .awaitTerminationMillis(5000L)
                .dynamicPool()
                .build();
    }

}
