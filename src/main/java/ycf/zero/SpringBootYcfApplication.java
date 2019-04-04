package ycf.zero;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yechangfeng
 * @date 2018/12/22
 */
@EnableCaching
@SpringBootApplication
@MapperScan(basePackages={"ycf.zero.toToSix.mapper","ycf.zero.eightSix.mapper"})
public class SpringBootYcfApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootYcfApplication.class);
    }
}
