package com.zero.local.threadLocal;

public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static Person person = new Person();

    public void setTl(){
        threadLocal.set(Thread.currentThread().getName());
    }

    public String getTl(){
        return threadLocal.get();
    }

    public void setName(){
        person.setName(Thread.currentThread().getName());
    }

    public String getName(){
        return person.getName();
    }
}
