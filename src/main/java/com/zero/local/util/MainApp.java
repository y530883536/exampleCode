package com.zero.local.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author yechangfeng
 * @date 2018/12/29
 */
public class MainApp {
    public static void main(String[] args) throws Exception{
        Person person = new Person();
        person.setName("com");
        person.setAge(28);
        person.setGender(1);
        Student student = new Student();
        PropertyUtil.setPropertyFor(person,student);
        System.out.println(new Date().getTime());
        Date date = new Date(Long.valueOf("1546078174632"));
        System.out.println(date);

        Date date1 = DateUtil.getDayEndTime(new Date());
        System.out.println(date1);

        System.out.println(trans("asdb"));
        
        String error = " \u8d85\u8fc7\u4e86 100000 \u7684\u6700\u5927\u503c\",\"code\":1000,\"data\":2239";
        String unicode = new String(error.getBytes("UTF-8"), "UTF-8");
        System.out.println(unicode);
    }

    public static String trans(String str){
        str = StringUtils.replace(str, "a", "A");
        str = StringUtils.replace(str, "b", "B");
        return str;
    }
}
