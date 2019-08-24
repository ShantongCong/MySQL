---
typora-root-url: img
typora-copy-images-to: img
---


# MYSQL基础语法
## 学习目标
1. 能够理解数据库的概念
2. 能够安装MySQL数据库
3. 能够启动,关闭及登录MySQL
4. 能够使用SQL语句操作数据库
5. 能够使用SQL语句操作表结构
6. 能够使用SQL语句进行数据的添加修改和删除的操作
7. 能够使用SQL语句简单查询数据


# 学习内容
## 1. 数据库的基本知识

### 目标

1. 能够掌握数据库的概念
2. 能够说出常用的数据库

### 讲解

#### 什么是数据库

存储数据的仓库

#### 数据的存储方式
1. **数据保存在内存**

   ```java
   int[] arr = new int[]{1, 2, 3, 4};
   ArrayList<Integer>list = new ArrayList<Integer>();
   list.add(1);
   list.add(2);
   ```

   new出来的对象存储在堆中.堆是内存中的一小块空间

   优点：内存速度快
   缺点：断电/程序退出,数据就清除了.内存价格贵 (临时性存储)

2. **数据保存在普通文件**
   优点：永久保存
   缺点：查找，增加，修改，删除数据比较麻烦，效率低

3. **数据保存在数据库**
   优点：永久保存,通过SQL语句比较方便的操作数据库

#### 数据库的优点
​	数据库是按照特定的格式将数据存储在文件中，通过SQL语句可以方便的对大量数据进行增、删、改、查操作，数据库是对大量的信息进行管理的高效的解决方案。

#### 常见数据库
![](/16f5d1c632d0ad1f.jpeg)
**Oracle**：收费的大型数据库，Oracle(甲骨文)公司的产品。Oracle收购SUN公司，收购MYSQL。
**MYSQL**：开源免费的数据库，小型的数据库.已经被Oracle收购了.MySQL6.x版本也开始收费。
**DB2** ：IBM公司的数据库产品,收费的。常应用在银行系统中.
**SQLServer**：MicroSoft 公司收费的中型的数据库。C#、.net等语言常使用。
**SyBase**：已经淡出历史舞台。提供了一个非常专业数据建模的工具PowerDesigner。
**SQLite**: 嵌入式的小型数据库，应用在手机端。

**常用数据库**：**MYSQL**，**Oracle**
在web应用中，使用的最多的就是MySQL数据库，原因如下：

1. 开源、免费
2. 功能足够强大，足以应付web应用开发（最高支持千万级别的并发访问）

### 小结

1. 说出数据库的概念：存储数据的仓库
2. 说出常用的数据库：MYSQL, Oracle



## 2.数据库的安装

### 目标

能够安装mysql数据库软件

### 讲解

1. 在今天的资料下有Mysql的安装包,找到后双击

    ![img](/clip_image002.jpg) 

2. 将我同意的选框勾选上

    ![1566198505872](/1566198505872.png)

      

3. 选择自定义安装,点击下一步

    ![1566198559169](/1566198559169.png) 

    

4. 根据电脑配置选择要安装的MySql版本,然后点击next

    ![1566198622878](/1566198622878.png) 

    ![1566198640133](/1566198640133.png)

    

    如果出现当前界面,则可以配置安装目录,如果出现的不是这个界面请点击Back返回！！！！![1566198724857](/1566198724857.png)  

    

    如果不是以上界面，那么点击back返回后,**点击高级选项**,配置安装路径,配置成功后点击下一步!!!

    ![1566198936185](/1566198936185.png) 

    ![1566199038957](/1566199038957.png) 

5. 当出现绿色对号时表名安装成功,然后点击下一步

    ![1566199089604](/1566199089604.png) 

    

6. 开始配置mysql,点击下一步

    ![1566199151533](/1566199151533.png) 

    

7. 配置MySql开发模式以及端口号相关配置,然后点击下一步

    ![1566199264418](/1566199264418.png) 

8. 设置密码账户信息,然后点击next

    ![1566199299368](/1566199299368.png) 

9. 使用默认配置就可以了,然后点击下一步

    ![1566199344122](/1566199344122.png) 

10. 日志配置

   ![1566199382936](/1566199382936.png) 

11. 点击Execute安装

    ![1566199441551](/1566199441551.png) 

12. 全部画上绿色对勾之后,安装成功点击finish->next->finish 

    ![1566199486551](/1566199486551.png) 

    ![1566199544791](/1566199544791.png) 

    ![1566199560537](/1566199560537.png)

13. 环境变量,找到MySql的安装目录的bin目录下,将路径复制下来

    ![1566199577831](/1566199577831.png)

    

14. 电脑的高级设置中的路径,将复制的路径添加进去

    window10如下操作

    ![1566199731907](/1566199731907.png) 

    

    


### 小结

1. MySQL安装过程的步骤：按照上述一步一步安装即可

2. MySQL端口号是：3306

3. 管理员名字：root

4. 将mysql的bin目录配置到path环境变量中

   

## 3. 命令行客户端连接服务器

### 目标

1. 能够打开和关闭mysql服务
2. 能够连接到mysql

### 讲解

#### 打开和关闭mysql服务

![1550408825267](/1550408825267.png)
![mysql启动02](/mysql启动02.png)

#### mysql登入连接

![1550289380140](/1550289380140.png)

MySQL是一个需要账户名密码登录的数据库，登陆后使用，它提供了一个默认的root账号，使用安装时设置的密码即可登录
##### 登录格式1：用户名+密码

`mysql -u用户名 -p密码`

例如：

```sql
mysql -uroot -proot
```

![1563977337809](/1563977337809.png)
后输入密码方式：

```sql
mysql -uroot -p
下一行输入密码
```

![1563977468620](/1563977468620.png) 

##### 登录格式2：主机+用户名+密码

`mysql [-h连接的主机ip -P端口3306] -u用户名  -p密码`

例如：

```
mysql -h 192.168.1.251 -P 3306 -u root -proot
```

![1563977796936](/1563977796936.png) 



退出MySQL：`exit或者quit`
![1563978101423](/1563978101423.png) 



###### 指定主机连接异常

**错误**

指定主机IP地址登入出现 1130错误，如下：

![1566096288923](/1566096288923.png) 

**解决方法：**

1. 先在MySQL所在电脑，正常使用用户名+密码方式登入

2. 输入以下命令

    ```sql
    GRANT ALL PRIVILEGES ON *.* TO 'root'@'需要连接ip' IDENTIFIED BY 'root密码' WITH GRANT OPTION;
    ```

如下图

![1566096336147](/1566096336147.png) 

**解决后在目标电脑上重新指定IP登入**

![1566096439397](/1566096439397.png) 

### 小结

1. 打开和关闭mysql服务？
2. 连接到本机的mysql？`mysql -uroot -proot`
3. 连接到指定主机的mysql？mysql  **[**-h 连接的主机ip -P端口3306**]** **-u 用户名 -p 密码**

## 4. 图形界面Navicat客户端

### 目标

1. 能够掌握Navicat的安装
2. 能够使用Navicat连接mysql数据库

### 讲解

![1550289366973](/1550409365086.png)

​	在dos窗口中使用sql语句操作mysql数据库相对来说，太麻烦了，我们在实际开发中不会使用dos窗口来操作的，一定要使用可视化工具来操作mysql数据库，而会有多种可视化工具来操作mysql数据库，比如：Navicat、SQLyog等。我们这里使用Navicat可视化工具。



1. 解压和双击

   ![1566265169370](/1566265169370.png) 

2. 在解压文件中找到以下文件，双击即可运行，建议放到你专门的文件夹中。

   ![1566265256334](/1566265256334.png) 

3. 建立与数据库的连接，如下	![](/%E5%92%8C%E6%95%B0%E6%8D%AE%E5%BA%93%E5%BB%BA%E7%AB%8B%E8%BF%9E%E6%8E%A5.PNG)

### 小结

1. 使用Navicat连接mysql? 在链接界面输入数据账号,密码,端口号
2. 如果ip地址是localhost连接不上数据库，可以使用127.0.0.1尝试

## 5. 卸载

步骤如下

1. 找到mysql的安装目录：在mysql的安装目录中。找到my.ini 文件。找到datadir 并且记录路径。 

    ```java
    datadir=D:/DeveloperKits/MySQL/MySQL Server 5.6/Data
    ```

    说明：

    - datadir路径是用来保存mysql的数据文件的目录，以后我们向Mysql数据库存储的数据都会存放到这个路径；
    - 在安装数据库的时候，要求这个路径的下的data文件夹要和数据库在同一文件夹下，这样在卸载的时候会比较方便，直接删除即可。如果没有安装到同一目录，那么找到该data文件夹进行删除；

2. 打开电脑控制面板–>找到程序和功能–>找到Mysql

    双击卸载mysql

3. 删除mysql的安装目录，删除mysql的数据文件目录datadir.第一步中记录的文件目录。

    注意：mysql默认的数据文件目录，在ProgramData这个目录下，并且ProgramData这个目录是隐藏目录，需要设置显示隐藏目录。

    删除ProgramData下的mysql的相关目录。

4. 打开运行窗口-----》输入regedit----》打开注册表-----》删除

    HKEY_LOCAL_MACHINE\SYSTEM\ControlSet001\Services\Eventlog\Application\MySQL文件夹

注意：一般情况下执行前3步即可，如果还不能安装，就执行步骤4，运行regedit,试着删除注册表中的数据，或者也可以使用360或者安全管家清理垃圾试试。

## 6. 服务器与数据库、表、记录的关系

### 目标

能够理解mysql服务器与数据库、表、记录的关系

### 讲解

![1550409365086](/1550409365086.png)

### 小结

mysql服务器与数据库、表、记录的关系？

MySQL服务器可以管理多个数据库

一个数据库可以管理多张表

一张表可以管理多个记录

mysql服务器中可以有多个数据仓库, 数据仓库中可以有多张表, 一张表中可以有多条记录!


## 7. SQL语句的分类和语法

### 目标

1. 能够掌握SQL的概念和作用

### 讲解

#### 什么是SQL
结构化查询语言(**S**tructured **Q**uery **L**anguage)简称SQL。很多人会把它读成“sequel”，数据库系统导论中一书中提到，更倾向与发音“ess –cue –ell” 。

SQL语句就是对数据库进行操作的一种语言。



通过SQL语句我们可以**方便**的操作数据库、表、数据。

SQL是数据库管理系统都需要遵循的规范。不同的数据库生产厂商都支持SQL语句，但都有特有内容。
![SQL规范](/SQL规范.png)

#### SQL语句分类
1. DDL(Data Definition Language)数据定义语言
   用来定义数据库对象：数据库，表，列等。==关键字：create, drop,alter等==

2. DML(Data Manipulation Language)数据操作语言
   用来对数据库中表的数据进行增删改。==关键字：insert, delete, update等==

3. DQL(Data Query Language) 数据查询语言
   对数据库进行数据查询，==关键字：select。==

4. DCL(**Data Control Language**)数据控制语言(了解)

   是用来设置或更改数据库用户或角色权限的语句，这个比较少用到。

#### SQL通用语法
1. SQL语句可以单行或多行书写，以分号结尾。

2. 可使用空格和缩进来增强语句的可读性。

3. MySQL数据库的SQL语句不区分大小写，关键字建议使用大写。
   ```sql
   SELECT * FROM student; 
   ```

4. 3种注释

   ```mysql
   单行注释: -- 注释内容   
   多行注释: /* 注释内容 */
   mysql特有的单行注释: #注释内容
   ```

   
### 小结

1. SQL的作用？对数据库进行操作的语句,增删改查
2. SQL的分类？
   DDL:操作数据和表及字段
   DML:对表中的记录进行增删改
   DQL:对表中的记录进行查询
3. SQL的语法特点？
   可以写一行,也可以写成多行,最好是以;结尾
   关键字建议大写
   可以任意缩进
   单行注释: -- 开头  # 开头
   多行注释: /*  */

## 8. DDL：创建数据库

### 目标

能够掌握创建数据库的三种语法

### 讲解

#### 创建数据库

【语法格式】

1. 直接创建数据库

   ```mysql
   CREATE DATABASE 数据库名;
   ```

2. 判断是否存在并创建数据库

   ```sql
   CREATE DATABASE IF NOT EXISTS 数据库名;
   ```

3. 创建数据库并指定字符集(编码表)

   ```sql
   CREATE DATABASE 数据库名 character set 字符集;
   ```


【练习】

* 直接创建数据库db1
  ```sql
  CREATE DATABASE db1;
  ```
  ![直接创建数据库](/直接创建数据库.png) 

* 判断是否存在并创建数据库db2
  ```sql
  CREATE DATABASE IF NOT EXISTS db2;
  ```
  ![判断是否存在并创建数据库](/判断是否存在并创建数据库.png) 

* 创建数据库db3并指定字符集为gbk
  ```sql
  CREATE DATABASE db2 CHARACTER SET gbk;
  ```
  ![创建数据库并指定字符集](/创建数据库并指定字符集.png) 

#### 查看数据库

【语法格式】

1. 查看所有的数据库
```mysql
SHOW DATABASES;
```
   ![查看所有数据库](/查看所有数据库.png)
2. 查看某个数据库的定义信息
```mysql
SHOW CREATE DATABASE 数据库名;
```
   ![查看某个数据库的定义信息](/查看某个数据库的定义信息.png)

### 小结

1. 创建数据库语法：CREATE DATABASE 数据库名;
2. 查看有哪些数据库：SHOW DATABASES;



## 9. DDL：修改和删除数据库

### 目标

1. 能够修改数据库的字符集
2. 能够删除数据库

### 讲解

#### 修改数据库字符集

【语法格式】

ALTER 表示修改

```mysql
ALTER DATABASE 数据库 [DEFAULT] CHARACTER SET 新的字符集;
```

defualt 可不写

【练习】

将db3数据库的字符集改成utf8
```mysql
ALTER DATABASE db3 DEFAULT CHARACTER SET utf8;
```
![修改数据库字符集](/修改数据库字符集.png) 

#### 删除数据库

【语法格式】

DROP:表示删除数据库或表

```sql
DROP DATABASE 数据库名;
```

【练习】

删除db2数据库
```sql
DROP DATABASE db2;
```
![删除数据库](/删除数据库.png) 

### 小结

1. 修改数据库的字符集格式？

    alter database 数据库 character set 新的字符集;

2. 删除数据库格式？

    drop database 数据库名;

## 10. DDL使用数据库

### 目标

1. 能够掌握切换数据库语法
2. 能够查看正在使用的数据库

### 讲解

【语法格式】

1. 查看正在使用的数据库

   ```mysql
   select -- 查询
   SELECT DATABASE();
   ```

2. ## 使用/切换数据库

   ```mysql
   USE 数据库名;
   ```

【练习】
* 查看正在使用的数据库
  ```mysql
  SELECT DATABASE();
  ```
  ![查看正在使用的数据库](/查看正在使用的数据库.png) 
* 使用db1数据库
  ```mysql
  USE db1;
  ```
  ![使用db1数据库](/使用db1数据库.png) 

### 小结

| DDL语句操作 | 关键字                               |
| ----------- | ------------------------------------ |
| 创建        | create database 数据库名;            |
| 修改        | alter database character set 字符集; |
| 查看        | show databases;                      |
| 删除        | drop database 数据库名;              |



## 11. DDL创建表

### 目标

1. 能够掌握SQL创建表
2. 能够掌握快速创建一个表结构相同的表

### 讲解

>**前提先使用某个数据库**（db1）
#### 创建表

【语法格式】

需要用到关键字说明：

```sql
CREATE -- 表示创建
TABLE -- 表示表
```

建表语法

```mysql
CREATE TABLE 表名 (字段名1 字段类型1, 字段名2 字段类型2...);
```

建议写成如下格式:
```mysql
CREATE TABLE 表名 (
    字段名1 字段类型1, 
    字段名2 字段类型2
);


public class 类名{
类型 名字；
}

```
#### MySQL数据类型

MySQL中的我们常使用的数据类型如下：

![1563895547469](/1563895547469.png) 

详细的数据类型如下(不建议详细阅读！)

![1550410505421](/1550410505421.png)

【练习】 

创建student表包含id,name,birthday字段

```sql
CREATE TABLE student (
      id INT,
      name VARCHAR(20),
      birthday DATE
);
```



#### 快速创建一个表结构相同的表

【语法格式】

```sql
CREATE TABLE 表名 LIKE 其他表;
```

【练习】

- 快速创建s1表，s1表结构和student表结构相同

    ```sql
    CREATE TABLE s1 LIKE student;
    ```

### 小结

1. 创建表语句：

    ```mysql
    create table 表名( 列名1 类型1 , 列名2 类型2 ,.... )
    ```

    

2. 常用数据类型：int, double, varchar, date

3. 快速创建表:

    ```mysql
    create table 表名 like 其他表;
    ```

      

## 12. DDL查看表

### 目标

1. 能够查看某个数据库中的所有表
2. 能够查看表结构

### 讲解

【语法格式】

1. 查看某个数据库中的所有表

   ```mysql
   SHOW TABLES;
   ```

2. 查看表结构

   ```sql
   DESC 表名;
   ```

3. 查看创建表的SQL语句

   ```mysql
   SHOW CREATE TABLE 表名;
   ```

【练习】

* 查看mysql数据库中的所有表
  ```mysql
  USE mysql;
  SHOW TABLES;
  ```
  ![查看某个数据库中的所有表](/查看某个数据库中的所有表.png) 

* 查看数据库db1中查看student表的结构
  ```sql
  DESC student;
  ```
  ![查看student表的结构](/查看student表的结构.png)  
* 查看数据库db1中student的创建表SQL语句
  ```sql
  USE db1;
  SHOW CREATE TABLE student;
  ```
  ![查看student的创建表SQL语句](/查看student的创建表SQL语句.png) 

### 小结

1. 查看某个数据库中的所有表：show tables;
2. 查看表结构：desc 表名;
3. 查看创建表的SQL语句：show create table 表名;

## 13. DDL删除表

### 目标

1. 能够掌握删除表语法

### 讲解

#### 删除表

【语法格式】

1. 直接删除表

   ```sql
   DROP TABLE 表名;
   ```

2. 判断表是否存在并删除表

   ```sql
   DROP TABLE IF EXISTS 表名;
   ```

【练习】

1. 直接删除表s1表

	```sql
	DROP TABLE s1;
	```
![直接删除表](/直接删除表.png) 

2. 判断表是否存在并删除s1表

	```sql
	DROP TABLE IF EXISTS s1;
	```
![判断表存在并删除](/判断表存在并删除.png) 

### 小结

1. 删除表语法：DROP TABLE 表名;

## 14. DDL修改表结构

### 目标

能够掌握修改表结构的语法

### 讲解

> 修改表结构使用不是很频繁，只需要了解，等需要使用的时候再回来查即可
#### 1. 添加表列

   【语法格式】

   ```sql
ALTER TABLE 表名 ADD 字段名 类型;
   ```

   【练习】

   为student表添加一个新的字段remark,类型为varchar(20)
   ```sql
ALTER TABLE student ADD remark VARCHAR(20);
   ```
   ![添加字段](/添加字段.png) 

#### 2. 修改列类型

   【语法格式】

   ```sql
ALTER TABLE 表名 MODIFY 字段名 新的类型;
   ```



   【练习】

   将student表中的remark字段的改成varchar(100)
   ```sql
ALTER TABLE student MODIFY remark VARCHAR(100);
   ```
   ![修改字段类型](/修改字段类型.png) 

#### 3. 修改列名

   【语法格式】

   ```sql
ALTER TABLE 表名 CHANGE 旧字段名 新字段名 类型;
   ```

   【练习】

   将student表中的remark字段名改成intro，类型varchar(30)
   ```sql
ALTER TABLE student CHANGE remark intro varchar(30);
   ```
   ![修改表字段名称](/修改表字段名称.png) 

#### 4. 删除列

   【语法格式】

   ```sql
ALTER TABLE 表名 DROP 字段名;
   ```

   【练习】

   删除student表中的字段intro
   ```sql
ALTER TABLE student DROP intro;
   ```
   ![删除字段](/删除字段.png) 

#### 5. 修改表名

   【语法格式】

```sql
RENAME TABLE 表名 TO 新表名;
```

   【练习】

   将学生表student改名成student2
   ```sql
RENAME TABLE student TO student2;
   ```
   ![修改表名](/修改表名.png) 

#### 6. 修改字符集

   【格式语法】

   ```sql
ALTER TABLE 表名 character set 字符集;
   ```

   【练习】

   将sutden2表的编码修改成gbk
   ```sql
ALTER TABLE student2 character set gbk;
   ```
![修改字符集](/修改字符集.png) 

### 小结

1. 所有修改表前面的语法都是相同的？ALTER TABLE 表名
2. 添加一列：add 字段名 类型
3. 修改类型：modify 字段名 新的类型
4. 修改字段名和类型：change 旧字段名 新字段名 类型
5. 删除一列：drop 字段名
6. 修改表名：rename

## 15. DML插入记录(重点)

### 目标

能够掌握往表中添加记录

### 讲解

【准备】

创建student表包含id,name,age,sex,address字段。

```sql
CREATE TABLE student (
      id INT,
      name VARCHAR(20),
      age int,
      sex char(2),
      address varchar(50)
);
```

#### 插入全部字段

【语法格式】

* 所有的字段名都写出来

  ```sql
  INSERT -- 表示往表里插入记录
  INSERT INTO 表名 (字段名1, 字段名2...) VALUES (字段值1, 字段值2...);
  ```

* 不写字段名

  ```sql
  INSERT INTO 表名 VALUES (字段值1, 字段值2...);
  ```

【练习】

1. 所有的字段名都写出来

    ```sql
     INSERT INTO student (NAME, id, age, sex, address) VALUES ('李四', 2, 23, '女', '广州');
    ```

    ![所有字段都添加数据](/所有字段都添加数据.png)

2. 不写字段名

    ```java
    INSERT INTO student VALUES (3, '王五', 18, '男', '北京');
    ```

    ![添加所有字段数据](/添加所有字段数据.png)



#### 插入部分数据

【语法格式】

```sql
INSERT INTO 表名 (字段名1, 字段名2...) VALUES (字段值1, 字段值2...);
```


没有添加数据的字段会使用NULL

关键字说明
```sql
INSERT INTO 表名 – 表示往哪张表中添加数据
(字段名1, 字段名2, …)  --  要给哪些字段设置值
VALUES (值1, 值2, …); -- 设置具体的值
```

【练习】

* 插入部分数据，往学生表中添加 id, name, age, sex数据

    ```java
    INSERT INTO student (id, NAME, age, sex) VALUES (1, '张三', 20, '男');
    ```



![添加部分数据](/添加部分数据.png) 



#### 插入数据时注意

> - 值与字段必须对应，个数相同，类型相同
> - 值的数据大小必须在字段的长度范围内
> - ==除了数值类型外，其它的字段类型的值必须使用引号引起。（建议单引号）==
> - 如果要插入空值，可以不写字段，或者插入null

### 小结

1. 向表中添加一条完整记录：
   所有的字段都写出来: INSERT INTO 表名 (字段1, 字段2, ....) VALUES (值1, 值2, ...);
   不写字段名: INSERT INTO 表名 VALUES  (值1, 值2, ...);

2. 可以在values后面加上多个括号内部放入数据，插入多行数据。每个括号之间需要有逗号

   ![1566639183935](/1566639183935.png) 

3. 向表中添加一条记录部分列：必须写字段名,否则不知道添哪个字段.
   INSERT INTO 表名 (字段1, 字段2, ....) VALUES (值1, 值2, ...);

   如果全部要插入，可以省略字段


## 16. DML更新表记录

### 目标

能够掌握更新表记录

### 讲解

【语法格式】

1. 不带条件修改数据

   ```sql
   UPDATE 表名 SET 字段名=新的值;
   ```

2. 带条件修改数据

   ```sql
   UPDATE 表名 SET 字段名=新的值 WHERE 条件
   ```

3. 关键字说明
   ```sql
   UPDATE: 表示修改记录 
   SET: 要改哪个字段
   WHERE: 设置条件
   ```


【练习】

1. 不带条件修改数据，将所有的性别改成女
  ```sql
  UPDATE student SET sex='女';
  ```
  ![修改所有数据](/修改所有数据.png) 

2. 带条件修改数据，将id号为2的学生性别改成男
  ```sql
  UPDATE student SET sex='男' WHERE id=2;
  ```
  ![带条件修改](/带条件修改.png)

3. 一次修改多个列，把id为3的学生，年龄改成26岁，address改成北京
  ```sql
  UPDATE student SET age=26, address='北京' WHERE id=3;
  ```
  ![一次性修改2个字段](/一次性修改2个字段.png)

### 小结

1. 不带条件的更新数据库记录：

    ```mysql
    UPDATE TABLE SET 字段名=新的值;
    ```

2. 带条件：

    ```mysql
    UPDATE TABLE SET 字段名1=新的值1,字段名2 = 新的值2,...  WHERE 条件;
    ```

    

## 17. DML删除表记录

### 目标

能够掌握删除表记录

### 讲解

【语法格式】

1. 不带条件删除数据【删除整表数据】

   ```sql
   DELETE -- 删除记录
   DELETE FROM 表名;
   ```

2. 带条件删除数据【删除指定数据】

   ```sql
   DELETE FROM 表名 WHERE 条件;
   ```

3. truncate删除表记录

   ```sql
   TRUNCATE TABLE 表名;
   ```

   >truncate和delete的区别：
   >* delete是将表中的数据一条一条删除
   >* truncate是将整个表摧毁，重新创建一个新的表,新的表结构和原来表结构一模一样
   >* ![truncate](/truncate.png)


【练习】
* 带条件删除数据，删除id为3的记录
  ```sql
  DELETE FROM student WHERE id=3;
  ```

  ![删除满足条件的记录](/删除满足条件的记录.png) 

* 不带条件删除数据,删除表中的所有数据
  ```sql
  DELETE FROM student;
  ```
  ![删除所有记录](/删除所有记录.png) 

### 小结

1. 指定条件删除：DELETE FROM 表名 WHERE 条件;

2. 没有条件删除所有的记录：DELETE FROM 表名;【删除所有记录】

3. 删除表结构再创建表：TRUNCATE TABLE 表名;

    

## 18. DQL没有条件的简单查询

### 目标

能够掌握简单查询

### 讲解

>注意：查询不会对数据库中的数据进行修改，只是一种显示数据的方式。
#### 查询表中所有列数据

##### 1.写出查询每列的名称

【语法格式】

```sql
SELECT -- 表示查询

SELECT 字段名1, 字段名2, ... FROM 表名;
```

【练习】

查询student中所有信息

```java
SELECT id, NAME ,age, sex, address FROM student;
```

   ![查询所有列](/查询所有列.png) 

##### 2.使用*表示所有列

【语法格式】

```sql
SELECT * FROM 表名;
```

【练习】

```sql
SELECT * FROM student;
```
![查询所有列](/查询所有列.png) 

#### 查询表中指定列数据

【语法格式】

查询指定列的数据,多个列之间以逗号分隔
```sql
SELECT 字段名1, 字段名2 FROM 表名;
```

【练习】
查询student表中的name 和 age 列

```sql
SELECT NAME, age FROM student;
```
![查询指定字段](/查询指定字段.png) 

#### 别名查询

【语法格式】

1. 查询时给列、表指定别名需要使用AS关键字
2. 使用别名的好处是方便观看和处理查询到的数据
   `SELECT 字段名1 AS 别名, 字段名2 AS 别名... FROM 表名;`
   `SELECT 字段名1 AS 别名, 字段名2 AS 别名... FROM 表名 AS 表别名;`
   注意:

   >查询给表取别名目前还看不到效果，需要到多表查询的时候才能体现出好处
   >AS关键字可以省略


【练习】
* 查询sudent表中name 和 age 列，name列的别名为”姓名”，age列的别名为”年龄”

    ```mysql
    SELECT NAME AS 姓名, age AS 年龄 FROM student;
    ```

    ![查询字段别名](/查询字段别名.png) 

#### 清除重复值

DISTINCT可以在查询字段名之前加上，表示去重

【语法格式】

查询指定列并且结果不出现重复数据

```sql
SELECT DISTINCT 字段名 FROM 表名;
```

【练习】

查询address列并且结果不出现重复的address

```sql
SELECT DISTINCT address 城市 FROM student;
```
![1550289641391](/1550289641391.png) 

#### 查询结果参与运算

【语法格式】

1. 某列数据和固定值运算

   ```sql
   SELECT 列名1 FROM 表名;
   SELECT 列名1 + 固定值 FROM 表名;
   ```

2. 某列数据和其他列数据参与运算

   ```sql
   SELECT 列名1 + 列名2 FROM 表名;
   ```

   >注意: 参与运算的必须是数值类型

【练习】

需求: 
添加数学，英语成绩列，给每条记录添加对应的数学和英语成绩 , 查询的时候将数学和英语的成绩相加.

实现：

* 修改student表结构,添加数学和英语成绩列
  ```sql
  ALTER TABLE student ADD math INT;
  ALTER TABLE student ADD english INT;
  ```
* 给每条记录添加对应的数学和英语成绩
     ![添加数学和英语成绩](/添加数学和英语成绩.png)
* 查询math + english的和
  ```sql
  SELECT math + english FROM student;
  ```
  ![查询math和english的和](/查询math和english的和.png) 

  >结果确实将每条记录的math和english相加，但是效果不好看

* 查询math + english的和使用别名”总成绩”
  ```sql
  SELECT math + english 总成绩 FROM student;
  ```
  ![组合查询结果取别名](/组合查询结果取别名.png)  

* 查询所有列与math + english的和并使用别名”总成绩”
  ```sql
  SELECT *, math + english 总成绩 FROM student;
  ```
  ![查询所有列数据和参与运算](/查询所有列数据和参与运算.png) 

* 查询姓名、年龄，将每个人的数学增加10分
  ```sql
  SELECT name, math + 10 FROM student;
  ```

### 小结

1. 简单查询格式：SELECT 字段名 FROM 表名;
2. 定义别名：SELECT 字段名 AS 别名 FROM 表名;
3. 去除重复行：SELECT DISTINCT 字段名  FROM 表名;
4. 数值列，可以进行计算，不会影响表中数据



| DML语句操作 | 关键字                                       |
| ----------- | -------------------------------------------- |
| 添加        | INSERT INTO 表名 (字段名...) VALUES (值...); |
| 修改        | UPDATE 表名 SET 字段名=新的值 WHERE 条件;    |
| 删除        | DELETE FROM 表名 WHERE 条件;                 |
| 查询        | SELETE 字段名 FROM 表名;                     |



## 19. 蠕虫复制

### 目标

了解蠕虫复制

### 讲解

蠕虫复制：从已有的数据表中获取数据，然后将数据进行新增操作，数据成倍（以指数形式）的增加。

【语法格式】

```sql
INSERT INTO 表名 SELECT * FROM 表名;
```

【作用】

将`表名2`中的数据复制到`表名1`中，一般来讲会在本表中进行测试。

【练习】

1. 创建student2表，student2结构和student表结构一样

2. 将student表中中数据插入到student2表中

3. 在student2表中测试复制自身数据插入到本表中【多执行几次，观察数据变化】。

    

* 创建student2表，student2结构和student表结构一样

    ```mysql
    CREATE TABLE student2 LIKE student;
    ```

* 将student表中的数据添加到student2表中

    ```mysql
    INSERT INTO student2 SELECT * FROM student;
    ```

* 在student2表中测试复制自身数据插入到本表中【多执行几次，观察数据变化】。

    ```mysql
    INSERT INTO student2 SELECT * FROM student2;
    ```

    

注意：如果只想复制student表中name,age字段数据到student2表中使用如下格式

```mysql
INSERT INTO student2(NAME, age) SELECT NAME, age FROM student;
```

未选中的列以null补齐

![蠕虫复制](/蠕虫复制.png) 


## 总结

1. 能够理解数据库的概念
   存储数据的仓库
2. 能够安装MySQL数据库
   一直下一步:解压,复制
   配置MYSQL服务器:下一步
3. 能够启动,关闭及登录MySQL
   在服务里面找到MySql,右键启动/关闭
   登录MySQL: mysql -uroot -proot
4. 能够使用SQL语句操作数据库
   创建数据库: CREATE DATABASE 数据库名;
   查看所有数据库: SHOW DATABASES;
   删除数据库: DROP DATABASE 数据库名;
   切换数据库: USE 数据库名;
5. 能够使用SQL语句操作表结构
   创建表: CREATE TABLE 表名 (字段名 类型, 字段名 类型, ...);
   查看所有表: SHOW TABLES;
   修改表: ALTER TABLE 表名;
      添加一列: ADD 字段名 类型
      修改字段类型: MODIFY 字段名 新的类型;
      修改字段名: CHANGE 旧字段名 新字段名 新的类型;
      删除一列: DROP 字段名;
   修改表名: REANME TABLE 表名 TO 新表名
   删除表: DROP TABLE 表名;
6. 能够使用SQL语句进行数据的添加修改和删除的操作
   添加数据: INSERT INTO 表名 (字段名) VALUES (值);
   修改数据: UPDATE 表名 SET 字段名=新的值 WHERE 条件;
   删除数据: DELETE FROM 表名 WHERE 条件;
7. 能够使用SQL语句简单查询数据
   SELECT 字段名1, 字段名2, ... FROM 表名;