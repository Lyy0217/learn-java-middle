package com.lyy.learn.java.middle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Jdbc的查询语句
 */
public class JdbcQuery {
    public static void main(String[] args) {

        //1. 加载mysql驱动
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("加载mysql驱动成功");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        //2. 连接数据库
//        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8"
//                , "root", "203991");
//             Statement s = c.createStatement()
//        ) {
//            String name = "dashen";
//            //正确的密码是：thisispassword
//            String password = "thisispassword";
//
////            String sql = "select * from user where name ='" + name + "' and password = '" + password + "'";
//            String sql = "select count(*) from hero";
//            // 执行查询语句，并把结果集返回给ResultSet
//            ResultSet rs = s.executeQuery(sql);
//            if (rs.next()) {
//                int total = rs.getInt(1);
//                System.out.println("hero中的总数为：" + total);
//            } else {
//                System.out.println("账号密码不正确");
//            }
//            while (rs.next()) {
////                int id = rs.getInt("id");
////                String name = rs.getString(2);
////                float hp = rs.getFloat("hp");
////                int damage = rs.getInt(4);
////                System.out.printf("%d\t %s\t %f\t %d%n", id, name, hp, damage);
//
//                // 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
//                // rs.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        list(0,5);
    }

    public static void list(int start, int count){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "203991"); Statement s = c.createStatement();) {

            String sql = "select * from hero limit " +start + "," + count;

            // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");// 可以使用字段名
                String name = rs.getString(2);// 也可以使用字段的顺序
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t %s\t %f\t %d%n", id, name, hp, damage);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
