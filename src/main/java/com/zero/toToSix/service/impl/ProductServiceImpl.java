package com.zero.toToSix.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.toToSix.mapper.ProductMapper;
import com.zero.toToSix.model.Product;
import com.zero.toToSix.service.IProductService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> testSql(String productArea) {
        return productMapper.testSql(productArea);
    }

    @Override
    public List<Product> testXml(String productArea,Integer price) {
        return productMapper.testXml(productArea,price);
    }

    @Override
    public List<Map> testMap() {
        return productMapper.testMap();
    }

    @Override
    public List<Map> testJoinTable() {
        return productMapper.testJoinTable();
    }

    @Override
    public List<Product> testScript(List<String> idList) {
        return productMapper.testScript(idList);
    }
}
