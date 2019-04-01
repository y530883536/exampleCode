package ycf.zero.local.designPattern.observer;

import lombok.Data;

@Data
public class ConcreteObserver implements Observer {

    private String name;

    public ConcreteObserver(String name){
        this.name = name;
    }

    @Override
    public void observe(Subject subject) {
        subject.addObserver(this);
    }

    @Override
    public void receiveNotify(String message) {
        String formatMessage = String.format("%s收到了信息：%s", name, message);
        System.out.println(formatMessage);
    }
}
