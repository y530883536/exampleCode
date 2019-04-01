package ycf.zero.local.basic;

import java.util.Random;

/**
 * @author yechangfeng
 * @date 2018/12/20
 */
public class RandomEnglish {
    public static void main(String[] args) {
        Random random = new Random();
        String val = "";
        for (int i = 0; i < 10; i++) {
            val += (char)(random.nextInt(26) + 65);
        }
        System.out.println(val);
        for (int i = 0; i < 50; i++) {
            System.out.println(random.nextInt(10));
        }
    }
}
