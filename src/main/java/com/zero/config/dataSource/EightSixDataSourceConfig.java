package com.zero.config.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class EightSixDataSourceConfig {

    @Bean(name = "eightSixDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.eight-six")
    public DataSource eightSixDataSource(){
        return new DruidDataSource();
    }

}
