package com.cong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC事务
public class Demo02 {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///day04", "root", "root");
            //开启事务

            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();

            String sql = "UPDATE account  SET balance=balance-500 WHERE name='张三'";
            statement.executeUpdate(sql);

            sql = "UPDATE  account  SET balance=balance+500 WHERE name='李四'";
            //为啥不报错？
            statement.executeUpdate(sql);

            System.out.println("转账成功");
            connection.commit();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
