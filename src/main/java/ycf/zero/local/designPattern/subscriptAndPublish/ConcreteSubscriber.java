package ycf.zero.local.designPattern.subscriptAndPublish;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ConcreteSubscriber implements Subscriber {

    private int id;
    private String name;
    private CenterController controller;
    private List<Publisher> publisherList = new ArrayList<>();

    public ConcreteSubscriber(int id, String name, CenterController controller) {
        this.id = id;
        this.name = name;
        this.controller = controller;
        controller.addSubscriber(this);
    }

    @Override
    public void subscribeAction(int publisherId,int type){
        Message message = new Message();
        message.setPublisherId(publisherId);
        message.setSubscriberId(id);
        message.setType(type);
        try {
            controller.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void receive(Message message) {
        Publisher publisher = controller.getPublisher(message.getPublisherId());
        String str = "'%s'收到了来自%s的信息'%s'";
        String formatStr = String.format(str, name, publisher.publisherName(), message.getContent());
        System.out.println(formatStr);
    }

    @Override
    public void addPublisher(Publisher publisher) {
        publisherList.add(publisher);
    }

    @Override
    public void removePublisher(Publisher publisher) {
        publisherList.remove(publisher);
    }

    @Override
    public String subscriberName() {
        return name;
    }

}
