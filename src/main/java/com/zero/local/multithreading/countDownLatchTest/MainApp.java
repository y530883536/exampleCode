package com.zero.local.multithreading.countDownLatchTest;

import lombok.Data;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MainApp {
    public static void main(String[] args) throws Exception{
        //await没有加等待时间，只会傻等
        /*CountDownLatch latch = new CountDownLatch(2);
        Thread t1 = new Thread(new Task("task1",3,latch));
        Thread t2 = new Thread(new Task("task2",5,latch));
        t1.start();
        t2.start();
        System.out.println("MainThread：没有调用await之前线程是正常走着的");
        latch.await();
        System.out.println("MainThread：线程继续往前走");*/

        //await加上等待时间
        CountDownLatch latch = new CountDownLatch(2);
        Thread t1 = new Thread(new Task("task1",6,latch));
        Thread t2 = new Thread(new Task("task2",8,latch));
        t1.start();
        t2.start();
        System.out.println("MainThread：没有调用await之前线程是正常走着的");
        //await()没有返回，await(等待时间)有返回，如果在等待时间内拿到锁则返回true，没有拿到返回false，然后强行破锁而出
        boolean isNotTimeOut = latch.await(3, TimeUnit.SECONDS);
        if(isNotTimeOut){
            System.out.println("MainThread：最大等待时间内拿到锁了，程序继续执行");
        }else{
            System.out.println("MainThread：最大时间过去了仍然没有拿到锁，强行破锁继续执行程序");
        }
        //超时之后latch还能用吗？可以的
        latch.await();
        System.out.println("latch在超时之后还是可以继续使用");
    }
}

@Data
class Task implements Runnable{

    private String name;
    private int pauseTime;
    private CountDownLatch latch;

    public Task(String name, int pauseTime, CountDownLatch latch){
        this.name = name;
        this.pauseTime = pauseTime;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            for(int i=0;i<10;i++){
                System.out.println(name + "：" + "完成第" + (i+1) + "次任务");
                Thread.sleep(1000);
                if(i == pauseTime){
                    latch.countDown();
                    System.out.println(name + "：" + "解开了countDown锁");
                    System.out.println(name + "：调用countDown方法之后会发生什么?调用的线程并不会发生什么，会继续往下走");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
