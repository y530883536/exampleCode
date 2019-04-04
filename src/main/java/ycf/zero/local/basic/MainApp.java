package ycf.zero.local.basic;

import ycf.zero.toToSix.model.Product;

import java.util.*;

/**
 * 这个类是测试代码的地方，记得及时清掉测试过代码，并且不要删除这个类
 * @author yechangfeng
 * @date 2018/12/20
 */
public class MainApp {
    public static void main(String[] args) throws Exception {
        List<User> list = new ArrayList<>();
        User user = new User("ycf");
        list.add(user);
        user = null;
        System.out.println(list.get(0).getName());
        System.out.println(System.getProperty("user.dir"));
    }
}

class User{
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
