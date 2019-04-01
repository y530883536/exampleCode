package ycf.zero.local.basic;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author yechangfeng
 * @date 2018/12/12
 */
public class MapOrder {
    public static void main(String[] args) {
        //TreeMap内部会对key做升序排列
        Map<String,String> map = new TreeMap<>();
        map.put("FFF","dsad");
        map.put("RRR","dsad");
        map.put("AAA","dsad");
        map.put("EEE","dsad");
        map.put("BBB","dsad");
        map.put("fff","dsad");
        map.put("ccc","dsad");
        map.put("yyy","dsad");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        StringBuilder sb = new StringBuilder("12345");
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);

        System.out.println(map);
    }
}
