package com.zero.local.designPattern.bridge.jdbcDriver;

import java.util.ArrayList;
import java.util.List;

public class DriverManager {
    public static final List<Driver> driverList = new ArrayList<>();

    public static Connection getConnection(){
        for (Driver driver : driverList) {
            return driver.connect();
        }
        return null;
    }

    public static void registerDriver(Driver driver){
        driverList.add(driver);
    }
}
