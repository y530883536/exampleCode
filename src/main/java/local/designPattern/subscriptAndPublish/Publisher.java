package local.designPattern.subscriptAndPublish;

import java.util.List;

public interface Publisher {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    List<Subscriber> getSubscriberList();
    void publishMessage(String msg) throws Exception;
    String publisherName();
}
