package ycf.zero.local.designPattern.observer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ConcreteSubject implements Subject {

    private List<Observer> observerList = new ArrayList<>();
    private String name;

    public ConcreteSubject(String name) {
        this.name = name;
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
        for (Observer observer : observerList) {
            observer.receiveNotify(message);
        }
    }
}
