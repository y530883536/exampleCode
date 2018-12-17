package basic;

import com.alibaba.fastjson.JSONObject;

import java.math.BigInteger;

/**
 * @author yechangfeng
 * @date 2018/12/17
 */
public class NullTest {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        //jsonObject.put("id",10001);
        jsonObject.put("aaa","dasdad");
        BigInteger id = jsonObject.getBigInteger("id");
        System.out.println(id);
    }
}
