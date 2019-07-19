package com.zero.local.multithreading.threadPool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainApp {
    public static void main(String[] args) throws Exception{
        /*ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        for(int i=0;i<8;i++){
            threadPoolExecutor.submit(() -> {
                return "s";
            });
        }
        //Thread.sleep(2000);
        System.out.println(threadPoolExecutor.getPoolSize());
        System.out.println(threadPoolExecutor.getActiveCount());
        System.out.println(threadPoolExecutor.getQueue().size());
        System.out.println(threadPoolExecutor.getTaskCount());
        System.out.println(threadPoolExecutor.getCompletedTaskCount());
        threadPoolExecutor.shutdown();*/

        String str = "http://eston-images.oss-cn-hongkong.aliyuncs.com/eston/b18f2eaa-c69a-4e35-a438-c40124b8284e.jpg";
        List<String> list = JSON.parseArray(str, String.class);
        System.out.println(list);
    }
}
