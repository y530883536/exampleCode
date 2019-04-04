package ycf.zero.controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/dataSource")
    public Map<String,Object> dataSource(){
        Map<String,Object> dataSourceMap = new HashMap<>();
        DruidDataSource druidDataSource = (DruidDataSource) this.dataSource;
        dataSourceMap.put("class",druidDataSource.getClass().getName());
        dataSourceMap.put("properties",druidDataSource.getProperties());
        dataSourceMap.put("maxActive",druidDataSource.getMaxActive());
        dataSourceMap.put("initialSize",druidDataSource.getInitialSize());
        dataSourceMap.put("maxWait",druidDataSource.getMaxWait());
        return dataSourceMap;
    }

}
