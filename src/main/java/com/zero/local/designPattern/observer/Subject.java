package com.zero.local.designPattern.observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(String message);
}
