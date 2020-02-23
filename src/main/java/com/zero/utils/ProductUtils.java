package com.zero.utils;

import com.zero.toToSix.model.Product;
import com.zero.toToSix.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//如何给static的Component加上@Autowired？用@PostConstruct
//如何给static的变量加上@Value？在非静态的set方法上用@Value，同时可以用@PostConstruct进行二次赋值
@Component
@PropertySource({"classpath:test.properties"})
public class ProductUtils {

    //public static String abc;
    public static List<String> testList = new ArrayList<>();

    @Value("${abc}")
    public void setAbc123(String abc) {
        //System.out.println("dsad"+abc);
        testList.add(abc);
    }

    @Autowired
    private IProductService productServiceOrigin;

    private static IProductService productService;

    @PostConstruct
    public void init(){
        productService = productServiceOrigin;
        //abc = abc + "hahahah";
    }

    public static List<Product> getAll(){
        List<Product> list = productService.list();
        //System.out.println(abc);
        System.out.println(testList);
        return list;
    }
}
