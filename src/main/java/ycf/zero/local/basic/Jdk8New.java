package ycf.zero.local.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Jdk8New {
    public static void main(String[] args) throws Exception{
        List<String> strList1 = new ArrayList<>();
        strList1.add("a");
        strList1.add("b");
        strList1.add("c");
        //lambda表达式的写法 (参数) -> {代码}
        //strList1.forEach((str) -> System.out.println(str));
        //下面这句的更简略写法，但是感觉会被人打死
        strList1.forEach(System.out::println);
        System.out.println("-----------------------");

        //将字母变成大写
        List<String> strList2 = new ArrayList<>();
        strList2.add("fuck");
        strList2.add("you");
        strList2.add("man");
        //List<String> result1 = strList2.stream().map(String::toUpperCase).collect(Collectors.toList());
        List<String> result1 = strList2.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
        result1.forEach(str -> System.out.println(str));
        System.out.println("-----------------------");

        //将数字变成平方
        List<Integer> intList1 = new ArrayList<>();
        intList1.add(4);
        intList1.add(6);
        intList1.add(8);
        List<Integer> result2 = intList1.stream().map(n -> n * 2).collect(Collectors.toList());
        result2.forEach(i -> System.out.println(i));
        System.out.println("-------------------------");

        //将一片文章里面所有的单词存进一个List中
        /*BufferedReader br = new BufferedReader(new FileReader("D:/article.txt"));
        List<String> result3 = br.lines().flatMap(line -> Stream.of(line.split(" |[.]|,"))).filter(line -> line.length() > 3).collect(Collectors.toList());
        System.out.println("-------------------------");*/

        //mapToInt的用法
        List<Money> moneyList = new ArrayList<>();
        moneyList.add(new Money(500));
        moneyList.add(new Money(900));
        moneyList.add(new Money(200));
        moneyList.add(new Money(1300));
        //int sum = moneyList.stream().mapToInt(Money::getAmount).sum();
        int sum = moneyList.stream().mapToInt(money -> money.getAmount()).sum();
        /*List<Integer> intList2 = new ArrayList<>();
        moneyList.stream().mapToInt(money -> money.getAmount()).forEach(intList2::add);
        intList2.forEach(i -> System.out.println(i));*/
        List<Integer> intList22 = moneyList.stream().map(Money::getAmount).collect(Collectors.toList());
        intList22.forEach(i -> System.out.println(i));
        System.out.println(sum);
        System.out.println("-------------------------");

        //IntStream的用法
        List<Integer> intList3 = new ArrayList<>();
        List<Integer> intList4 = new ArrayList<>();
        List<Integer> intList5 = Collections.synchronizedList(intList4);
        IntStream.range(0, 1000).forEach(intList3::add);
        IntStream.range(0, 1000).parallel().forEach(intList5::add);
        //intList3.forEach(i -> System.out.println(i));
        System.out.println(intList3.size());
        System.out.println(intList4.size());
        System.out.println(intList5.size());
        System.out.println("-------------------------");

        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(1,1,100,"纸巾"));
        orderList.add(new Order(1,2,200,"食用油"));
        orderList.add(new Order(2,3,300,"洗发水"));
        orderList.add(new Order(2,4,400,"大米"));
        orderList.add(new Order(3,5,500,"泡面"));
        orderList.add(new Order(4,6,600,"冰箱"));
        Map<Integer, List<Order>> orderMap = orderList.stream().collect(Collectors.groupingBy(order -> {
            return order.getUserId();
        }));
        System.out.println(orderMap);
    }
}

class Money{
    private int amount;
    public Money(int amount){
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}

class Order{
    private int userId;
    private int orderId;
    private int amount;
    private String productName;
    public Order(int userId, int orderId, int amount, String productName) {
        this.userId = userId;
        this.orderId = orderId;
        this.amount = amount;
        this.productName = productName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
