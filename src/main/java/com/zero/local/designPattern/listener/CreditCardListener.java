package com.zero.local.designPattern.listener;

import java.util.EventListener;
import java.util.EventObject;

public class CreditCardListener implements EventListener {

    public void payDebt(EventObject event){
        Person person = (Person)event.getSource();
        person.setDeposit(person.getDeposit()-3000);
        System.out.println("信用卡还款：3000元");
    }

}
