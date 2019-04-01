package ycf.zero.local.designPattern.subscriptAndPublish;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ConcretePublisher implements Publisher {

    private int id;
    private String name;
    private CenterController controller;
    private List<Subscriber> subscriberList = new ArrayList<>();

    public ConcretePublisher(int id, String name, CenterController controller) {
        this.id = id;
        this.name = name;
        this.controller = controller;
        controller.addPublisher(this);
    }

    @Override
    public void addSubscriber(Subscriber subscriber){
        subscriberList.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber){
        subscriberList.remove(subscriber);
    }

    @Override
    public List<Subscriber> getSubscriberList(){
        return subscriberList;
    }

    @Override
    public void publishMessage(String content) throws Exception{
        Message message = new Message();
        message.setType(Message.MSG_NOTIFY);
        message.setPublisherId(id);
        message.setContent(content);
        controller.sendMessage(message);
    }

    @Override
    public String publisherName() {
        return name;
    }

}
