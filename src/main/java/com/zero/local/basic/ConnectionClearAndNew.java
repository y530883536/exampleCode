package com.zero.local.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectionClearAndNew {
    public static void main(String[] args) {
        /*Map<String,String> map1 = new HashMap<>();
        map1.put("1","one");
        Map<String,Map> map2 = new HashMap<>();
        map2.put("map",map1);
        map1.put("2","two");
        Map<String,Map> map3 = map2.get("map");
        for (Map.Entry<String, Map> entry : map3.entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println(map3.size());
        map1.clear();
        System.out.println(map3.size());*/

        Map<String,List> listMap = new HashMap();
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        listMap.put("list",list);
        List list1 = listMap.get("list");
        System.out.println(list1.size());
        list.clear();
        //list = new ArrayList<>();
        List list2 = listMap.get("list");
        System.out.println(list2.size());
    }
}
