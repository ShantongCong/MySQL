package com.cong.Demo02c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo01 {
    @Test
    public void test01() throws SQLException {
        // 方式一: 使用默认配置（default-config）
        // 使用无参构造：new ComboPooledDataSource();
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Connection connection = comboPooledDataSource.getConnection();
        String sql = "INSERT INTO day05.student VALUES (null,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, "张三");
        preparedStatement.setInt(2, 25);
        preparedStatement.setDouble(3, 99.5);

        int i = preparedStatement.executeUpdate();
        System.out.println("改动的行数为:" + i);
        connection.close();
    }

    @Test
    public void test02() throws SQLException {
        // 方式二： 使用命名配置（named-config：配置名）
        // 使用有参构造：new ComboPooledDataSource("配置名");
        ComboPooledDataSource otherc3p0 = new ComboPooledDataSource("otherc3p0");
        Connection connection = otherc3p0.getConnection();
        String sql = "INSERT INTO day05.student VALUES (null,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "李四");
        preparedStatement.setInt(2, 28);
        preparedStatement.setDouble(3, 49.5);
        int i = preparedStatement.executeUpdate();
        System.out.println("i = " + i);

        preparedStatement.close();
        connection.close();

    }

    @Test
    public void test03() throws SQLException {
        //1.默认方法
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        for (int i = 0; i < 10; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            System.out.println(connection);
        }
        System.out.println("=========");
        ComboPooledDataSource otherc3p0 = new ComboPooledDataSource("otherc3p0");
        for (int i = 0; i < 11; i++) {
            Connection connection = otherc3p0.getConnection();
            System.out.println(connection);
        }


    }
}
