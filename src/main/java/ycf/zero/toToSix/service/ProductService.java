package ycf.zero.toToSix.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ycf.zero.toToSix.model.Product;

import java.util.List;

public interface ProductService extends IService<Product> {
    List<Product> testSql(String productArea);
    List<Product> testXml(String productArea);
}
