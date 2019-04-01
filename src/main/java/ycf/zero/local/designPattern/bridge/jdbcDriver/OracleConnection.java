package ycf.zero.local.designPattern.bridge.jdbcDriver;

public class OracleConnection implements Connection{
    @Override
    public void say() {
        System.out.println("垃圾驱动");
    }
}
