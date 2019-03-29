package local.designPattern.subscriptAndPublish;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Slf4j
public class CenterController {

    private BlockingQueue<Message> messageQueue = new ArrayBlockingQueue<>(1000);
    private List<Subscriber> subscriberList = new ArrayList<>();
    private List<Publisher> publisherList = new ArrayList<>();

    public void sendMessage(Message message) throws Exception{
        messageQueue.put(message);
    }

    public void handleMessage() throws Exception{
        while(true){
            Message message = messageQueue.take();
            Publisher publisher = getPublisher(message.getPublisherId());
            Subscriber subscriber = getSubscriber(message.getSubscriberId());
            String subscribeStr = "'%s'用户订阅了频道'%s'";
            String cancelSubscribeStr = "'%s'用户取消订阅了频道'%s'";
            switch(message.getType()) {
                case Message.MSG_SUBSCRIBE:
                    publisher.addSubscriber(subscriber);
                    subscriber.addPublisher(publisher);
                    log.info("'{}'用户订阅了频道'{}'",subscriber.subscriberName(),publisher.publisherName());
                    break;
                case Message.MSG_CANCEL_SUBSCRIBE:
                    publisher.removeSubscriber(subscriber);
                    subscriber.removePublisher(publisher);
                    log.info("'{}'用户取消订阅了频道'{}'",subscriber.subscriberName(),publisher.publisherName());
                    break;
                case Message.MSG_NOTIFY:
                    for (Subscriber sub : publisher.getSubscriberList()) {
                        sub.receive(message);
                    }
                    break;
                default:
            }
        }
    }

    public Subscriber getSubscriber(int subscriberId){
        return subscriberList.get(subscriberId);
    }

    public Publisher getPublisher(int publisherId){
        return publisherList.get(publisherId);
    }

    public void addSubscriber(Subscriber subscriber){
        subscriberList.add(subscriber);
    }

    public void addPublisher(Publisher publisher){
        publisherList.add(publisher);
    }
}
