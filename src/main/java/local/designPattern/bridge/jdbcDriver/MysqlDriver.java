package local.designPattern.bridge.jdbcDriver;

public class MysqlDriver implements Driver {
    @Override
    public Connection connect() {
        System.out.println("正在连接mysql数据");
        return new MysqlConnection();
    }

    static {
        DriverManager.registerDriver(new MysqlDriver());
        System.out.println("MysqlDriver被加载了");
    }
}
