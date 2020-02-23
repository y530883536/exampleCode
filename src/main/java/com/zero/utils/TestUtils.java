package com.zero.utils;

import com.zero.toToSix.model.Product;
import com.zero.toToSix.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestUtils {

    @Autowired
    private IProductService productService;

    public void test(){
        Product product = productService.getById(1);
        System.out.println("OKKKKKKKKKKKK");
    }

}
