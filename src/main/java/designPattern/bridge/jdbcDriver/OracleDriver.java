package designPattern.bridge.jdbcDriver;

public class OracleDriver implements Driver {

    @Override
    public Connection connect() {
        System.out.println("正在连接垃圾数据库");
        return new OracleConnection();
    }

    static{
        DriverManager.registerDriver(new MysqlDriver());
        System.out.println("OracleDriver被加载了");
    }
}
