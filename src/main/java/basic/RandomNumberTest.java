package basic;


import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.Date;
import java.util.Random;

/**
 * @author yechangfeng
 * @date 2018/12/11
 */
public class RandomNumberTest {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            System.out.println(Math.random());
        }
        System.out.println(System.currentTimeMillis()/1000);
    }
}
