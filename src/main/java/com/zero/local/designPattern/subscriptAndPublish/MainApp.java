package com.zero.local.designPattern.subscriptAndPublish;

public class MainApp {
    public static void main(String[] args) throws Exception{
        CenterController controller = new CenterController();
        Subscriber s1 = new ConcreteSubscriber(0,"叶长丰",controller);
        Subscriber s2 = new ConcreteSubscriber(1,"路栋梁",controller);
        Subscriber s3 = new ConcreteSubscriber(2,"黄春林",controller);
        Subscriber s4 = new ConcreteSubscriber(3,"吴智文",controller);
        Subscriber s5 = new ConcreteSubscriber(4,"林伟龙",controller);
        Publisher p1 = new ConcretePublisher(0,"易世通达",controller);
        Publisher p2 = new ConcretePublisher(1,"仲恺",controller);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    controller.handleMessage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        s1.subscribeAction(0,Message.MSG_SUBSCRIBE);
        s2.subscribeAction(0,Message.MSG_SUBSCRIBE);
        s3.subscribeAction(0,Message.MSG_SUBSCRIBE);
        s1.subscribeAction(1,Message.MSG_SUBSCRIBE);
        s4.subscribeAction(1,Message.MSG_SUBSCRIBE);
        s5.subscribeAction(1,Message.MSG_SUBSCRIBE);
        p1.publishMessage("这周末上班");
        p2.publishMessage("下个月校庆");
        s2.subscribeAction(0,Message.MSG_CANCEL_SUBSCRIBE);
        p1.publishMessage("清明不放假了");
    }
}
