package com.cong;

import java.sql.Connection;

//从数据库中获取数据模拟登陆
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) throws Exception {
        Connection connection = JDBCUtils.getConnection();
        Statement statement = connection.createStatement();//要传给数据库来查找

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的账号：");
        String userName = scanner.nextLine();
        System.out.println("请输入你的密码：");
        String passWord = scanner.nextLine();

        String sql="SELECT *FROM USER WHERE username="+userName+"&&"+"password="+passWord+";";
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            System.out.println("登陆成功！");
        }else System.out.println("账号密码错误，请重新登陆！");


    }
}
