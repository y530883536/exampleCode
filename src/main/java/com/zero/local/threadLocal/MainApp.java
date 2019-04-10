package com.zero.local.threadLocal;

public class MainApp {
    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();

        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.setTl();
                    System.out.println(Thread.currentThread().getName() + "-TL:" + test.getTl());
                    /*test.setName();
                    System.out.println(Thread.currentThread().getName() + "-name:" + test.getName());*/
                }
            },"t"+i);
            t1.start();
        }

    }
}
