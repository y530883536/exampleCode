package com.zero.local.designPattern.observer;

public class MainApp {
    public static void main(String[] args) {
        Subject boss = new ConcreteSubject("老板");
        Observer student1 = new ConcreteObserver("吴智文");
        Observer student2 = new ConcreteObserver("林伟龙");
        student1.observe(boss);
        student2.observe(boss);
        boss.notifyObserver("星期六加班");
    }
}
