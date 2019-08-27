package com.cong;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo03JUBCUtilsTest {
    public static void main(String[] args) {
        //createTable();
//        addEmployee();
		updateEmployee();
//		deleteEmployee();


    }

    public static void createTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS employee(" +
                    "id int primary key auto_increment," +
                    "name varchar(20) unique not null," +
                    "age int ," +
                    "address varchar(50)" +
                    ")";
            statement.execute(sql);
            System.out.println("创建表格成功");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement);
        }
    }


    public static void addEmployee() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql = "INSERT  INTO employee VALUES" +
                    "(NULL, '李四4', 21, '南京')," +
                    "(NULL, '王五4', 18, '东京')," +
                    "(NULL, '赵六4', 17, '长安');";
            int i = statement.executeUpdate(sql);
            System.out.println("影响的行数" + i);
            System.out.println("插入成功！");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement);
        }
    }

    public static void updateEmployee() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql = "UPDATE employee set address='上海';";
            int i = statement.executeUpdate(sql);
            System.out.println("影响的行数" + i);
            System.out.println("修改成功！");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement);
        }
    }
}
