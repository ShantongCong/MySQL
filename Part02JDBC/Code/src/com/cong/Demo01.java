package com.cong;


import java.sql.*;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///day04", "root", "root");
        Statement statement = connection.createStatement();

        //增
        String sql="INSERT INTO category VALUES (null,'小米手机');";
        int i = statement.executeUpdate(sql);
        System.out.println("改变了几行" + i);

        //删
        sql="DELETE FROM category WHERE cname='小米手机';";
        int i1 = statement.executeUpdate(sql);
        System.out.println("i1 = " + i1);

        //改
        sql="UPDATE category SET cname='手机' WHERE cid=3";
        int i2 = statement.executeUpdate(sql);
        System.out.println("i2 = " + i2);

        //查
        sql="SELECT *FROM  category;";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int cid = resultSet.getInt("cid");
            String cname = resultSet.getString("cname");
            System.out.println(cid+"===="+cname);
        }

        //释放资源
        statement.close();
        connection.close();





    }
}
