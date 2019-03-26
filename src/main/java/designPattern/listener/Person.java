package designPattern.listener;

import lombok.Data;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;

@Data
public class Person {

    private int deposit;
    private List<EventListener> listenerList = new ArrayList<>();

    public Person(){
        listenerList.add(new HouseRentListener());
        listenerList.add(new CreditCardListener());
    }

    public void receiveSalary(int salary){
        deposit = deposit + salary;
        System.out.println("拿到工资：" + salary + "元");
        //EventListener没有任何方法，这里要判断EventListener的具体类型去进行不同的逻辑判断
        EventObject event = new EventObject(this);
        for (EventListener listener : listenerList) {
            if(listener instanceof CreditCardListener) {
                CreditCardListener creditCardListener = (CreditCardListener)listener;
                creditCardListener.payDebt(event);
            }
            if(listener instanceof HouseRentListener){
                HouseRentListener houseRentListener = (HouseRentListener)listener;
                houseRentListener.payRent(event);
            }
        }
        System.out.println("现在存款为：" + deposit + "元");
    }
}
