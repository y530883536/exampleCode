package com.zero.local.threadLocal;

public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void set(){
        threadLocal.set(Thread.currentThread().getName());
    }

    public String get(){
        return threadLocal.get();
    }
}
