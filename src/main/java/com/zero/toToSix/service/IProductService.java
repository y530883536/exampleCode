package com.zero.toToSix.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zero.toToSix.model.Product;

import java.util.List;

public interface IProductService extends IService<Product> {
    List<Product> testSql(String productArea);
    List<Product> testXml(String productArea,Integer price);
}
