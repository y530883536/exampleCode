package com.zero.config.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class ToToSixDataSourceConfig {

    @Bean(name = "toToSixDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.to-to-six")
    public DataSource toToSixDataSource(){
        return new DruidDataSource();
    }

}
