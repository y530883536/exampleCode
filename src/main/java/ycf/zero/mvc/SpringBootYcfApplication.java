package ycf.zero.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author yechangfeng
 * @date 2018/12/22
 */
@EnableCaching
@SpringBootApplication
public class SpringBootYcfApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootYcfApplication.class);
    }
}
