package designPattern.subscriptAndPublish;

public interface Subscriber {
    void subscribeAction(int publisherId,int type);
    void receive(Message message);
    void addPublisher(Publisher publisher);
    void removePublisher(Publisher publisher);
    String subscriberName();
}
