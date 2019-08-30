package com.cong.Demo01PreparedSatement;

import com.cong.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//对象关系映射
public class ORMTest {
    @Test
    public void test01() throws SQLException {
        //1. 得到连接对象
        Connection connection = JDBCUtils.getConnection();

        //2. 得到Statement对象
        String sql="SELECT *FROM employee;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //3. 编写SQL语句并执行,保存ResultSet
        ResultSet resultSet = preparedStatement.executeQuery();

        //4. 创建一个集合用于封装所有的记录
        ArrayList<Employee> list=new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            int age = resultSet.getInt("age");

        //5. 每次循环封装一个学生对象
            Employee employee = new Employee();
            employee.setId(id);
            employee.setName(name);
            employee.setAge(age);
            employee.setAddress(address);

        //6. 把数据放到集合中
            list.add(employee);
        }

        //7. 关闭连接
        JDBCUtils.close(connection,preparedStatement);

        //8. 遍历集合，循环输出学生对象
        list.forEach((employee)-> System.out.println("s = " + employee));

    }
}
