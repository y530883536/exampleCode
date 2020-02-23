package com.zero;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author yechangfeng
 * @date 2018/12/22
 */
@EnableCaching
@SpringBootApplication
@MapperScan(basePackages={"com.zero.toToSix.mapper","com.zero.eightSix.mapper"})
public class SpringBootYcfApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootYcfApplication.class);
    }
}
