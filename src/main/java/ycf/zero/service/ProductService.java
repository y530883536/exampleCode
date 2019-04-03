package ycf.zero.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ycf.zero.model.Product;

import java.util.List;

public interface ProductService extends IService<Product> {
    List<Product> testSql();
    List<Product> testXml();
}
