package com.lhzsdnu.example.hippo4j.server.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <p>
 * 线程池 工具类
 * </p>
 *
 * @author lhz
 */
public class ThreadPoolUtil {

    public static Integer calculateCoreNum() {
        int cpuCoreNum = Runtime.getRuntime().availableProcessors();
        return new BigDecimal(cpuCoreNum).divide(new BigDecimal("0.2"), 4, RoundingMode.HALF_UP).intValue();
    }

    public static Integer calculateMaxNum() {
        return ThreadPoolUtil.calculateCoreNum() + (ThreadPoolUtil.calculateCoreNum() >> 1);
    }

}
