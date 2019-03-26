package designPattern.listener;

import java.util.EventListener;
import java.util.EventObject;

public class HouseRentListener implements EventListener {

    public void payRent(EventObject event){
        Person person = (Person)event.getSource();
        person.setDeposit(person.getDeposit()-1000);
        System.out.println("还房租：1000元");
    }

}
