package designPattern.bridge.jdbcDriver;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Class.forName("designPattern.bridge.jdbcDriver.MysqlDriver");
        Connection connection = DriverManager.getConnection();
        connection.say();
    }
}
