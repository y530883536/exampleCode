package com.zero.local.basic;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

public class ReadLineUtils {
    public static void main (String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(new File("C:/aaa.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
        String msg;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(StringUtils.isNotEmpty((msg = br.readLine()))){
            sb.append(msg).append(",");
            count++;
        }
        System.out.println(sb.toString());
        System.out.println(count);
    }
}
