package com.lhzsdnu.example.hippo4j.server;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class Hippo4JServerApplicationTests {

    /**
     * 创建租户、项目、线程池
     * =============================================================================================
     * 内置四种报警策略:
     *   活跃度报警、队列容量报警、拒绝策略报警、运行时间过长报警
     * =============================================================================================
     * hippo4j.core.clean-history-data-period=30
     *   线程池历史数据保留时间，默认 30 分钟
     * hippo4j.core.clean-history-data-enable=true
     *   是否开启线程池历史数据清洗，默认开启
     */
    @Test
    void contextLoads() {
        System.out.println("hello example-hippo4j-server");
    }

}
