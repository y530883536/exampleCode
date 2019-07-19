package com.zero;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zero.eightSix.model.User;
import com.zero.eightSix.service.IUserService;
import com.zero.toToSix.mapper.CompanyMapper;
import com.zero.toToSix.mapper.ProductMapper;
import com.zero.toToSix.model.Company;
import com.zero.toToSix.model.Product;
import com.zero.toToSix.service.ICompanyService;
import com.zero.toToSix.service.IProductService;
import com.zero.utils.ProductUtils;
import com.zero.utils.TestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//这个类主要还是用来校验@Autowired相关的初始化以及如何调用
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ICompanyService companyService;

    @Autowired
    private TestUtils testUtils;

    @GetMapping("/listTest")
    public List<User> listTest(){
        return userService.list();
    }

    @GetMapping("/staticTest")
    public List<Product> staticTest(){
        return ProductUtils.getAll();
    }

    @GetMapping("/pageTest")
    public IPage<User> pageTest(){
        log.error("error级别");
        log.warn("warn级别");
        log.info("info级别");
        Page<User> page = new Page<>();
        return userService.page(page);
    }

    @GetMapping("/updateTest")
    public boolean updateTest(){
        Product product = new Product();
        product.setId(3);
        product.setName("飞洒fsaf发");
        product.setProductArea(null);
        return productService.updateById(product);
    }

    @GetMapping("/nullTest")
    public List<Product> nullTest(){
        List<Integer> idList = new ArrayList<>();
        idList.add(3);
        idList.add(4);
        idList.add(null);
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(Product::getId,idList);
        return productService.list(wrapper);
    }

    @GetMapping("/nullTest2")
    public List<Product> nullTest2(){
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Product::getId,null);
        return productService.list(wrapper);
    }

    @GetMapping("/nullTest3")
    public Product nullTest3(){
        return productService.getById(null);
    }

    @GetMapping("/testXmlList")
    public List<Product> testSqlList(){
        List<Integer> idList = new ArrayList<>();
        idList.add(4);
        idList.add(6);
        return productMapper.testXmlList(idList);
    }

    @GetMapping("/testReload")
    public List<Product> testReload(){
        testUtils.test();
        return productMapper.testReload();
    }

    @GetMapping("/testCompanySql/{id}")
    public List<Company> testCompanySql(@PathVariable Integer id){
        return companyService.testCompanySql(id);
    }

    @GetMapping("getCompanyById/{id}")
    public Company getCompanyById(@PathVariable Integer id){
        return companyService.getById(id);
    }
}
