package com.zero.local.threadLocal;

public class MainApp {
    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.set();
                System.out.println(test.get());
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.set();
                System.out.println(test.get());
            }
        });
        t2.start();

        test.set();
        System.out.println(test.get());
    }
}
