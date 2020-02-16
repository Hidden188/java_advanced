package javaDB;

import java.sql.*;
import java.util.Properties;

public class TestDerby {

    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            System.out.println("Loaded the EmbeddedDriver");
            Properties properties = new Properties();
            properties.setProperty("user", "user");
            properties.setProperty("password", "password");
            Connection conn = DriverManager.getConnection("jdbc:derby:helloDB;create=true", properties);
            System.out.println("create derbyDB");
            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            //statement.execute("create table users(name varchar(20), password varchar(20))");
            statement.execute("insert into users(name, password) values('xiaoming', '123456')");
            statement.execute("insert into users(name, password) values('xiaohua', '876543')");
            System.out.println("---------------------查询---------------------");
            ResultSet resultSet = statement.executeQuery("select name, password from users");
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("password"));
            }
            resultSet.close();
            statement.close();
            conn.commit();
            conn.close();
            DriverManager.getConnection("jdbc:derby:helloDB;shutDown=true");




        } catch (InstantiationException | SQLException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }

}
