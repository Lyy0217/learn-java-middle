package com.lyy.learn.java.middle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC:
 * 一：Hello Jdbc
 * 步骤：
 * 1. 初始化驱动
 * 2. 建立与数据库的连接
 * 3. 创建statement
 * 4. 执行sql语句
 * 5. 关闭连接
 * 6. 使用try-with-resource的方式，自动关闭连接
 */
public class TestJdbc {

    public static void main(String[] args) {
//        Statement s = null;
//        Connection c = null;
        //1. 初始化驱动
        //驱动类：com.mysql.jdbc.Driver
        //就在包：mysql-connector-java-5.0.8-bin,jar中.maven导入中
        //如果么有maven对该包的导入，就会报：ClassNotFoundException
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection c = DriverManager
                .getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "203991");
            Statement s = c.createStatement();
        )
        {


            //2. 建立与数据库的connection连接
            // 这里需要提供：
            // 数据库所处于的ip:127.0.0.1 (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 how2java
            // 编码方式 UTF-8
            // 账号 root
            // 密码 203991


//            System.out.println("连接成功，获取连接对象： " + c);

            //3. 创建statement，用于执行sql语句。比如增删改查
            // 注意使用的是 java.sql.Statement
            // 不要误用了 com.mysql.jdbc.Statement;

//            System.out.println("获取 Statement对象： " + s);

            //准备sql语句
            // 注意字符串要用单引号'
            String sql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
            s.execute(sql);
            System.out.println("执行插入语句成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            // 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
//            // 先关闭Statement
//            if (s != null) {
//                try {
//                    s.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            //后关闭connection
//            if (c != null) {
//                try {
//                    c.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

    }
}
