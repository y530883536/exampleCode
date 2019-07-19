package com.zero.local.basic;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 这个类是测试代码的地方，记得及时清掉测试过代码，并且不要删除这个类
 * @author yechangfeng
 * @date 2018/12/20
 */
public class MainApp {
    public static void main(String[] args) throws Exception {
        /*ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Future<String> submit = threadPoolExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("dsad");
                return "hello";
            }
        });
        threadPoolExecutor.shutdown();*/
        /*int count = 100;
        List<AliexpressProduct> list = new ArrayList<>(300000);
        while(count > 0){
            for(int i=0;i<3000;i++){
                AliexpressProduct p = new AliexpressProduct();
                p.setAddUnit(10);
                p.setAddWeight("sda");
                p.setAeopAeMultimedia("sd");
                p.setAeopAeProductPropertysJson("dssdasd");
                p.setAeopAeProductSkusJson("sdsd");
                list.add(p);
            }
            count --;
        }
        System.out.println("hahaha");*/

        //Arrays.sort可以排序字符串(常用的也就是字符串了)
        /*String str = "de:be:fi:ru:pt:lt:fr:hu:sk:sl:id:sv:ko:el:en:it:es:et:cs:ar:vi:nb:th:ja:da:ro:nl:tr:";
        String[] split = str.split(":");
        Arrays.sort(split);
        for (String s : split) {
            System.out.println(s);
        }*/

        /*DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setGroupingSize(0);
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        Double cnyPrice = Double.valueOf(decimalFormat.format(12.3456));
        System.out.println(cnyPrice);*/

        /*String str = "{'message':'This product price increase is unacceptable. The price of products cannot be greatly increased.','code':1035,'data':{}}-[]";
        str = str.substring(0,str.lastIndexOf("}")+1);
        System.out.println(str);*/

        //alibaba的druid里的StringUtils，可以准确判断是否数字
        /*System.out.println(StringUtils.isNumber("6.0"));
        System.out.println(StringUtils.isNumber("4"));
        System.out.println(StringUtils.isNumber("-4"));
        System.out.println(StringUtils.isNumber("dsa"));
        System.out.println(StringUtils.isNumber("040"));*/

        System.out.println("aaa");
    }

    static class User{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}

