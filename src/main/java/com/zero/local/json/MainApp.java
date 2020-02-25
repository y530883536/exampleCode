package com.zero.local.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yechangfeng
 * @date 2018/12/13
 */
public class MainApp {
    public static void main(String[] args) {
        /*JSONObject jsonObject = new JSONObject();
        jsonObject.put("version","2.0");
        Map<String,String> map = new LinkedHashMap<>();
        map.put("effect","allow");
        map.put("action","cos");
        map.put("resource","*");
        jsonObject.put("statement",map);
        System.out.println(jsonObject.toJSONString());*/

        /*String str = "{'productImages':['http://10.100.1.200:8888/public/2019-04-102/2cf89513-c429-4aee-8004-917e61bcf9c2/9FF400007.jpg','http://10.100.1.200:8888/public/2019-04-102/8aefa3fc-caab-409d-8ac3-a3286eaccb8e/9FF400007-0.jpg','http://10.100.1.200:8888/public/2019-04-102/8ba425f0-ebc6-448e-8eec-fcee0a70045b/9FF400007-6.jpg','http://10.100.1.200:8888/public/2019-04-102/972bb537-1b65-40ef-b274-29ac4e473bef/9FF400007-CMB-2.jpg','http://10.100.1.200:8888/public/2019-04-102/29531a87-c1cc-4502-af59-27fa514a7d39/9FF400007-3.jpg','http://10.100.1.200:8888/public/2019-04-102/1f8e858f-9a5e-4cdd-9cf4-c7376aaf89b7/9FF400007-1.jpg','http://10.100.1.200:8888/public/2019-04-102/66936c2c-4f18-486c-b4cc-4403e25fd68b/9FF400007-2.jpg','http://10.100.1.200:8888/public/2019-04-102/5b1609af-8796-4541-89cd-ab34100dd47a/9FF400007-BK-S.jpg','http://10.100.1.200:8888/public/2019-04-102/5375656c-7757-4fee-aec4-a85471e69ce8/9FF400007-BK-XL.jpg','http://10.100.1.200:8888/public/2019-04-102/3637a0c0-0ec3-440c-93d1-473f58215c31/9FF400007-BK-L.jpg','http://10.100.1.200:8888/public/2019-04-102/6aefb193-492e-408c-b083-0a85ab007d56/9FF400007-4.jpg','http://10.100.1.200:8888/public/2019-04-102/7ff66467-4a8b-40ce-81b0-e6f20887ac14/9FF400007-5.jpg','http://10.100.1.200:8888/public/2019-04-102/3c719993-ecae-49bd-86a8-62f978f3129f/9FF400007-BK-M.jpg','http://10.100.1.200:8888/public/2019-04-108/041cb9b7-ebbe-4d08-9607-5555a20f03ef/9FF400007-0.jpg','http://10.100.1.200:8888/public/2019-04-108/6f9ad185-9c91-48dd-9ddf-a5f63082b310/9FF400007-6.jpg','http://10.100.1.200:8888/public/2019-04-108/310dad82-b60a-46c5-b073-fb5c911d5d15/9FF400007.jpg','http://10.100.1.200:8888/public/2019-04-108/9effe655-63f7-4fd8-b29f-f272ceaa3814/9FF400007-CMB-2.jpg','http://10.100.1.200:8888/public/2019-04-108/7b791274-5c95-47ed-a17d-2acbb4576f0d/9FF400007-3.jpg','http://10.100.1.200:8888/public/2019-04-108/f8d35c59-928c-4c84-9816-e10c4482e596/9FF400007-BK-S.jpg','http://10.100.1.200:8888/public/2019-04-108/b594dcf9-05ea-4bae-935e-a8dc99070f51/9FF400007-1.jpg','http://10.100.1.200:8888/public/2019-04-108/faf528bc-6d9c-4e1b-85ed-2f2b2f5ccc01/9FF400007-2.jpg','http://10.100.1.200:8888/public/2019-04-108/a45ba4b1-1c88-40f5-a4ab-a7ec54d7a3ad/9FF400007-4.jpg','http://10.100.1.200:8888/public/2019-04-108/19df9215-e5b8-4d41-9e04-1f471c7ff1ec/9FF400007-BK-XL.jpg','http://10.100.1.200:8888/public/2019-04-108/daeaa1b9-24ae-4d11-a2d9-66d9872f363d/9FF400007-5.jpg','http://10.100.1.200:8888/public/2019-04-108/0e0f9072-50b1-45c8-b467-464836878359/9FF400007-BK-L.jpg','http://10.100.1.200:8888/public/2019-04-108/9c4d7d6d-80e4-4c04-bf25-6b7f0c8c8e9d/9FF400007-BK-M.jpg'],'skus':[{'attribute':'状态：正常<br/> 标签：无','color':'Black','enabled':true,'mainImage':'http://10.100.1.200:8888/public/2019-04-108/f8d35c59-928c-4c84-9816-e10c4482e596/9FF400007-BK-S.jpg','profitMargin':0.25,'size':'S','sku':'9FF400007-BK-S'},{'attribute':'状态：正常<br/> 标签：无','color':'Black','enabled':true,'mainImage':'http://10.100.1.200:8888/public/2019-04-108/9c4d7d6d-80e4-4c04-bf25-6b7f0c8c8e9d/9FF400007-BK-M.jpg','profitMargin':0.25,'size':'M','sku':'9FF400007-BK-M'},{'attribute':'状态：正常<br/> 标签：无','color':'Black','enabled':true,'mainImage':'http://10.100.1.200:8888/public/2019-04-108/0e0f9072-50b1-45c8-b467-464836878359/9FF400007-BK-L.jpg','profitMargin':0.25,'size':'L','sku':'9FF400007-BK-L'},{'attribute':'状态：正常<br/> 标签：无','color':'Black','enabled':true,'mainImage':'http://10.100.1.200:8888/public/2019-04-108/19df9215-e5b8-4d41-9e04-1f471c7ff1ec/9FF400007-BK-XL.jpg','profitMargin':0.25,'size':'XL','sku':'9FF400007-BK-XL'}]}";
        JSONObject jj = JSONObject.parseObject(str);
        Object name = jj.get("name");
        System.out.println(name);*/

        /*String str = "[{\"attribute\":\"状态：草稿<br/> 标签：无\",\"color\":\"Green\",\"enabled\":false,\"mainImage\":\"http://192.168.1.249/meigong24/publicimage/6EE1300421/6EE1300421-GN-3.jpg\",\"msrp\":12.0,\"price\":2.21,\"profitMargin\":0.25,\"quantity\":200,\"shipping\":2.0,\"size\":\"\",\"sku\":\"6EE1300421-GN\"},{\"attribute\":\"状态：草稿<br/> 标签：无\",\"color\":\"White\",\"enabled\":false,\"mainImage\":\"http://192.168.1.249/meigong24/publicimage/6EE1300421/6EE1300421-W-2.jpg\",\"msrp\":12.0,\"price\":2.21,\"profitMargin\":0.25,\"quantity\":200,\"shipping\":2.0,\"size\":\"\",\"sku\":\"6EE1300421-W\"},{\"attribute\":\"状态：草稿<br/> 标签：无\",\"color\":\"Blue\",\"enabled\":false,\"mainImage\":\"http://192.168.1.249/meigong24/publicimage/6EE1300421/6EE1300421-BL-2.jpg\",\"msrp\":12.0,\"price\":2.21,\"profitMargin\":0.25,\"quantity\":200,\"shipping\":2.0,\"size\":\"\",\"sku\":\"6EE1300421-BL\"},{\"attribute\":\"状态：草稿<br/> 标签：无\",\"color\":\"Hot pink\",\"enabled\":false,\"mainImage\":\"http://192.168.1.249/meigong24/publicimage/6EE1300421/6EE1300421-HP-2.jpg\",\"msrp\":12.0,\"price\":2.21,\"profitMargin\":0.25,\"quantity\":200,\"shipping\":2.0,\"size\":\"\",\"sku\":\"6EE1300421-HP\"}]";
        JSONArray jsonArray = JSONObject.parseArray(str);
        System.out.println("sf");
        System.out.println(" hello world ".trim().length());*/

        //User user = JSONObject.parseObject("{\"name\":\"ycf\",\"age\":29}", User.class);
        //Object parse = JSONObject.parse("{\"name\":\"ycf\",\"age\":29}");
        //System.out.println("fff");

        List<User> userList = new ArrayList<>();
        userList.add(new User("ycf",29));
        userList.add(new User("wzw",28));
        String s = JSON.toJSONString(userList);
        System.out.println(s);
        StringBuilder sb = new StringBuilder();
        sb.append("123456");
        String substring = sb.substring(0, sb.length() - 1);
        System.out.println(substring);
    }

    @Data
    static class User{
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
