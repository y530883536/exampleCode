package ycf.zero.local.designPattern.bridge.jdbcDriver;

public class MysqlConnection implements Connection{
    @Override
    public void say() {
        System.out.println("mysql驱动");
    }
}

