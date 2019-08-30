package com.cong.Demo01PreparedSatement;

import com.cong.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Test01 {
    //增
    @Test
    public void test01() throws SQLException {
        //如何识别操作某个数据库
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into employee (name,age,address) VALUES (?,?,?)";

        //获得sql预编译对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //插入第一条数据
        preparedStatement.setString(1, "张1");
        preparedStatement.setInt(2, 18);
        preparedStatement.setString(3, "上海");
        preparedStatement.executeUpdate();

        int i1 = preparedStatement.executeUpdate();
        System.out.println("i1 = " + i1);

        JDBCUtils.close(connection, preparedStatement);
    }

    @Test
    public void test02() throws SQLException {

        //获取连接
        Connection conn = JDBCUtils.getConnection();
        //插入数据语句
        String sql = "insert into employee (name,age,address) VALUE (?,?,?);";
        //获取SQL预编译对象
        PreparedStatement preSate = conn.prepareStatement(sql);
        //插入第一条数据
        preSate.setString(1, "刘德华");
        preSate.setInt(2, 57);
        preSate.setString(3, "香港");
        int i1 = preSate.executeUpdate();
        //插入第二条数据
        System.out.println("插入数据：" + i1);
        preSate.setString(1, "张学友");
        preSate.setInt(2, 55);
        preSate.setString(3, "澳门");
        int i2 = preSate.executeUpdate();
        System.out.println("插入数据：" + i2);
        //插入第三条数据
        preSate.setString(1, "黎明");
        preSate.setInt(2, 52);
        preSate.setString(3, "香港");
        int i3 = preSate.executeUpdate();
        System.out.println("插入数据：" + i3);
        //关流
        JDBCUtils.close(conn, preSate);

    }

    //删
    @Test
    public void test03() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "DELETE FROM employee WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 5);
        //改变了几行
        int i = preparedStatement.executeUpdate();
        System.out.println("i = " + i);

        JDBCUtils.close(connection, preparedStatement);

    }

    //查看
    @Test//土味查看
    public void test04() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "SELECT *FROM employee WHERE age>?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,53);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name")+"==== " + resultSet.getInt("age"));
        }

    }
}





