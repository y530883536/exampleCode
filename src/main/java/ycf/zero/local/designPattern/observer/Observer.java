package ycf.zero.local.designPattern.observer;

public interface Observer {
    void observe(Subject subject);
    void receiveNotify(String message);
}
