package com.zero.local.multithreading.cyclicBarrierTest;

import lombok.Data;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class MainApp {
    public static void main(String[] args) throws Exception{
        CyclicBarrier barrier = new CyclicBarrier(3);
        Thread t1 = new Thread(new Task("task1",6,barrier));
        Thread t2 = new Thread(new Task("task2",9,barrier));
        t1.start();
        t2.start();
        System.out.println("MainThread：正常地在走着");
        //设置超时时间后，如果超时了没拿到锁，barrier就会别破坏，此时所有调用barrier.await的方法的地方都会抛异常
        barrier.await(2, TimeUnit.SECONDS);
        System.out.println("MainThread：解开了barrier锁，继续往下走");
    }
}

@Data
class Task implements Runnable{

    private String name;
    private int pauseTime;
    private CyclicBarrier barrier;

    public Task(String name, int pauseTime, CyclicBarrier barrier){
        this.name = name;
        this.pauseTime = pauseTime;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            for(int i=0;i<10;i++){
                System.out.println(name + "：" + "完成第" + (i+1) + "次任务");
                Thread.sleep(1000);
                if(i == pauseTime){
                    barrier.await();
                    System.out.println(name + "：" + "解开了barrier锁，继续执行任务");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}