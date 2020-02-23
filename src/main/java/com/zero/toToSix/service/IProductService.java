package com.zero.toToSix.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zero.toToSix.model.Product;

import java.util.List;
import java.util.Map;

public interface IProductService extends IService<Product> {
    List<Product> testSql(String productArea);
    List<Product> testXml(String productArea,Integer price);
    List<Map> testMap();
    List<Map> testJoinTable();
    List<Product> testScript(List<String> idList);
}
