package local.json;

import com.alibaba.fastjson.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yechangfeng
 * @date 2018/12/13
 */
public class MainApp {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version","2.0");
        Map<String,String> map = new LinkedHashMap<>();
        map.put("effect","allow");
        map.put("action","cos");
        map.put("resource","*");
        jsonObject.put("statement",map);
        System.out.println(jsonObject.toJSONString());
    }
}
