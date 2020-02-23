package com.zero.local.multithreading.functionThread;

import java.util.concurrent.*;
import java.util.function.Consumer;

public class MainApp {
    public static void main(String[] args) throws Exception{
        ExecutorService dailyPool = Executors.newFixedThreadPool(5);
        ExecutorService entertainmentPool = Executors.newFixedThreadPool(5);
        LinkedBlockingQueue<Consumer<Integer>> taskQueue = new LinkedBlockingQueue<>();
        dailyActivity daily = new dailyActivity();
        EntertainmentActivity entertainment = new EntertainmentActivity();

        taskQueue.put(daily::getUp);
        taskQueue.put(daily::brushTeeth);
        taskQueue.put(daily::eat);
        taskQueue.put(daily::sleep);
        taskQueue.put(entertainment::bilibili);
        taskQueue.put(entertainment::hitThePlane);
        taskQueue.put(entertainment::eatChicken);
        taskQueue.put(entertainment::majsoul);

        while(true){
            try {
                Consumer<Integer> consumer = taskQueue.take();
                dailyPool.submit(()->{
                   consumer.accept(8);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
