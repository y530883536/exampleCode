package com.zero.config.dataSource;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.eight-six")
public class EightSixDataSourceConfig {

    private String name;
    private String type;
    private String url;
    private String username;
    private String password;
}
