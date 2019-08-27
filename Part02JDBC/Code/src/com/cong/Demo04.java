package com.cong;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//完全封装
public class Demo04 {
    public static void main(String[] args) {
        while (true){
            //executeUpdate：用于执行增删改
            //executeQuery：用于执行查询
            System.out.println("MySQL操作界面");
            System.out.println("请选择你想要的操作：");
            System.out.println("1.创建表格/开发模式");
            System.out.println("2.插入");
            System.out.println("3.删除");
            System.out.println("4.查看");
            System.out.println("5.改");
            System.out.println("6.删除所有表格");
            Scanner scanner=new Scanner(System.in);
            int i = scanner.nextInt();
            switch (i){
                case 1:
                    operate(1);
                    break;
                case 2:
                    operate(2);
                    break;
                case 3:
                    operate(4);
                    break;
                case 4:
                    operate(3);
                    break;
                case 5:
                    operate(5);
                    break;
                case 6:
                    operate(6);
                    break;

                    default:
                        System.exit(1);
            }



        }


    }
    public static void operate(int flag){
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();

            if (flag==3){
                String sql="SELECT *FROM employee;";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int cid = resultSet.getInt("id");
                    String cname = resultSet.getString("name");
                    String address = resultSet.getString("address");
                    System.out.println(cid+"===="+cname+"===="+address);
                }
            }else if (flag==1){
                 String sql = "CREATE TABLE IF NOT EXISTS employee(" +
                        "id int primary key auto_increment," +
                        "name varchar(20) unique not null," +
                        "age int ," +
                        "address varchar(50)" +
                        ")";
                statement.execute(sql);
                System.out.println("创建表格成功");

            }else if (flag==2){
                String sql = "INSERT  INTO employee VALUES" +
                        "(NULL, '李四4', 21, '南京')," +
                        "(NULL, '王五4', 18, '东京')," +
                        "(NULL, '赵六4', 17, '长安');";
                int i = statement.executeUpdate(sql);
                System.out.println("影响的行数" + i);
                System.out.println("插入成功！");

            }else if(flag==4){
                //删除表格
                String sql = "DELETE FROM employee WHERE id=1;";
                int i = statement.executeUpdate(sql);
                System.out.println("影响的行数:" + i);

            }else if(flag==5){
                String sql = "UPDATE employee set address='上海';";
                int i = statement.executeUpdate(sql);
                System.out.println("影响的行数" + i);
                System.out.println("修改成功！");
            }else if (flag==6){
                String sql = "DROP TABLE employee";
                int i = statement.executeUpdate(sql);
                System.out.println("i = " + i);
            }




        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement);
        }




    }



}
