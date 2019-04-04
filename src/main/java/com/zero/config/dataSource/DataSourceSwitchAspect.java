package com.zero.config.dataSource;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 数据源切面
 */
@Component
@Order(value = -100)
@Aspect
public class DataSourceSwitchAspect {

    @Pointcut("execution(* com.zero.eightSix.*.*(..)) ")
    private void eightSixAspect() {
    }

    @Pointcut("execution(* com.zero.eightSix.*.*(..)) ")
    private void toToSixAspect() {
    }


    @Before("eightSixAspect()")
    public void eightSix() {
        System.out.println("切换到86数据源...");
    }

    @Before("toToSixAspect()")
    public void toToSix() {
        System.out.println("切换到226数据源...");
    }

}