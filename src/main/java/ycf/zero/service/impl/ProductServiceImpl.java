package ycf.zero.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ycf.zero.mapper.ProductMapper;
import ycf.zero.model.Product;
import ycf.zero.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> testSql() {
        return productMapper.testSql();
    }

    @Override
    public List<Product> testXml() {
        return productMapper.testXml();
    }
}
