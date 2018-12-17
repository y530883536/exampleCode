package json;

import com.alibaba.fastjson.JSONObject;

/**
 * @author yechangfeng
 * @date 2018/12/13
 */
public class MainApp {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("url","https://www.baidu.com");
        System.out.println(jsonObject.toJSONString());
        System.out.println(jsonObject.toString());
    }
}
