package ycf.zero.toToSix.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import ycf.zero.toToSix.model.Product;
import ycf.zero.toToSix.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@PropertySource({"classpath:test.properties"})
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Value("${abc}")
    private int port;

    @GetMapping("/getById/{id}")
    public Product getById(@PathVariable Integer id){
        Product product = productService.getById(id);
        System.out.println(port);
        return product;
    }

    @GetMapping("/updateById")
    public boolean updateById(@RequestBody Product product){
        boolean isSuccess = productService.updateById(product);
        return isSuccess;
    }

    @GetMapping("/saveProduct")
    public boolean saveProduct(@RequestBody Product product){
        boolean isSuccess = productService.saveOrUpdate(product);
        return isSuccess;
    }

    @GetMapping("/removeById/{id}")
    public boolean deleteProduct(@PathVariable Integer id){
        boolean isSuccess = productService.removeById(id);
        return isSuccess;
    }

    @GetMapping("/selectOne")
    public Product selectOne(){
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        //wrapper.eq("price",60);
        wrapper.eq("product_area","China");
        //最后一个参数不加，查询到多个结果就会抛异常；加了的话就会返回多个结果中的第一个
        Product product = productService.getOne(wrapper,false);
        return product;
    }

    //一般不用这个,用selectList代替
    @GetMapping("/selectByMap")
    public List<Product> selectByMap(){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("product_area","usa");
        List<Product> productList = (List)productService.listByMap(paramMap);
        return productList;
    }

    @GetMapping("/selectCount")
    public int selectCount(){
        //使用LambdaQueryWrapper代替QueryWrapper
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Product::getProductArea,"USA");
        //QueryWrapper<Product> wrapper = new QueryWrapper<>();
        //wrapper.eq("product_area","Canada");
        int count = productService.count(wrapper);
        return count;
    }

    @GetMapping("/selectList")
    public List<Product> selectList(){
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Product::getProductArea,"USA");
        List<Product> productList = productService.list(wrapper);
        return productList;
    }

    //只能返回一条记录的Map，很少场景能够用这个
    @GetMapping("/selectMaps")
    public Map<String, Object> selectMaps(){
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Product::getProductArea,"China");
        Map<String, Object> productMap = productService.getMap(wrapper);
        return productMap;
    }

    //返回第一个字段（正常情况都是id）的集合，在某些特定的只需要id的场景可以使用（像深空无限的villageId）
    @GetMapping("/selectObjs")
    public List<Object> selectObjs(){
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Product::getProductArea,"China");
        List<Object> objectList = productService.listObjs(wrapper);
        return objectList;
    }

    @GetMapping("/selectPage/{currentPage}")
    public IPage<Product> selectPage(@PathVariable int currentPage){
        Page<Product> page = new Page<>();
        page.setSize(3);
        page.setCurrent(currentPage);
        LambdaQueryWrapper<Product> wrapper = new LambdaQueryWrapper<>();
        wrapper.ge(Product::getPrice,40);
        productService.page(page, wrapper);
        return page;
    }

    @GetMapping("/batchUpdate")
    public boolean batchUpdate(){
        LambdaUpdateWrapper<Product> wrapper = new UpdateWrapper<Product>().lambda();
        wrapper.eq(Product::getPrice,40);
        wrapper.set(Product::getName,"技嘉金牌主板");
        boolean isSuccess = productService.update(wrapper);
        return isSuccess;
    }

    @GetMapping("/testSql/{productArea}")
    public List<Product> testSql(@PathVariable String productArea){
        return productService.testSql(productArea);
    }

    @GetMapping("/testXml/{productArea}")
    public List<Product> testXml(@PathVariable String productArea){
        return productService.testXml(productArea);
    }
}
