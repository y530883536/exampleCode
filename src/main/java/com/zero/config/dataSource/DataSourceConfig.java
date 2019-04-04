package com.zero.config.dataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

//@Configuration
public class DataSourceConfig {

    //@Bean
    public DataSource dataSource(DataSource eightSixDataSource, DataSource toToSixDataSource){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object,Object> targetDataSources = new HashMap<>();
        targetDataSources.put("86",eightSixDataSource);
        targetDataSources.put("226",toToSixDataSource);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(toToSixDataSource);
        return dynamicDataSource;
    }
}
