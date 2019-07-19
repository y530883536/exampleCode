package com.zero.local.multithreading.functionThread;

public class dailyActivity {
    public void getUp(Integer time){
        System.out.println(time + "点起床了该上班了");
    }

    public void brushTeeth(Integer time){
        System.out.println(time + "点刷牙洗脸");
    }

    public void eat(Integer time){
        System.out.println(time + "点吃饭");
    }

    public void sleep(Integer time){
        System.out.println(time + "点睡觉");
    }
}
