package com.cong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//JUBC工具类
public class JDBCUtils {
    private static final String name="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql:///day04";
    private static final String user="root";
    private static final String psw="root";

    static {
        try {
            Class.forName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, psw);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(AutoCloseable...resource){
        for (AutoCloseable autoCloseable : resource) {
            try {
                autoCloseable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




}
