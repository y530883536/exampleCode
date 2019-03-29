package local.designPattern.bridge.jdbcDriver;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Class.forName("local.designPattern.bridge.jdbcDriver.MysqlDriver");
        Connection connection = DriverManager.getConnection();
        connection.say();
    }
}
