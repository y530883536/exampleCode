package com.zero.local.multithreading.semaphoreTest;

import lombok.Data;

import java.util.concurrent.Semaphore;

public class MainApp {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        Thread t1 = new Thread(new Task("task1",3,semaphore));
        Thread t2 = new Thread(new Task("task2",5,semaphore));
        t1.start();
        t2.start();
        try {
            System.out.println("MainThread：尝试获取信号量");
            semaphore.acquire();
            System.out.println("MainThread：获取到信号量了，程序继续执行");
            for(int i=0;i<10;i++){
                System.out.println("MainThread：完成第" + (i+1) + "次任务");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}

@Data
class Task implements Runnable{

    private String name;
    private int pauseTime;
    private Semaphore semaphore;

    public Task(String name, int pauseTime, Semaphore semaphore){
        this.name = name;
        this.pauseTime = pauseTime;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            for(int i=0;i<10;i++){
                System.out.println(name + "：" + "完成第" + (i+1) + "次任务");
                Thread.sleep(1000);
                if(i == pauseTime){
                    System.out.println(name + "：" + "尝试获取信号量");
                    semaphore.acquire();
                    System.out.println(name + "：" + "获取到信号量，程序继续执行");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
