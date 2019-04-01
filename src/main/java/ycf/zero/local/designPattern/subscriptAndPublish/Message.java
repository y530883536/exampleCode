package ycf.zero.local.designPattern.subscriptAndPublish;

import lombok.Data;

@Data
public class Message {

    public static final int MSG_SUBSCRIBE = 0;
    public static final int MSG_CANCEL_SUBSCRIBE = 1;
    public static final int MSG_NOTIFY = 2;

    private int type;
    private int publisherId;
    private int subscriberId;
    private String content;

}
