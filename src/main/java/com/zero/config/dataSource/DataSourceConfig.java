package com.zero.config.dataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Resource(name = "toToSixDataSource")
    private DataSource toToSixDataSource;

    @Resource(name = "eightSixDataSource")
    private DataSource eightSixDataSource;

    @Primary
    @Bean(name = "dataSource")
    @DependsOn({"toToSixDataSource","eightSixDataSource"})
    public DataSource dataSource(){
        DynamicDataSource dataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("toToSixDataSource", toToSixDataSource);
        targetDataSources.put("eightSixDataSource",eightSixDataSource);
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(toToSixDataSource);
        return dataSource;
    }

}
