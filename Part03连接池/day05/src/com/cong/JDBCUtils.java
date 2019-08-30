package com.cong;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Properties;
//工具类
public class JDBCUtils {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private JDBCUtils() {
    }

    public static Connection getConnection() throws SQLException {
        Properties pro = new Properties();

        try (
                FileInputStream fileInputStream = new FileInputStream("pro.properties");
        ) {
            pro.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = pro.getProperty("url");
        Connection connection = DriverManager.getConnection(url, pro);
        return connection;
    }


    public static void close(Connection connection, PreparedStatement preparedStatement, Closeable... source) {
        for (Closeable closeable : source) {
            try {
                if (closeable != null)
                    closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
