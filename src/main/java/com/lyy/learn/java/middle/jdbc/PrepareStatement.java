package com.lyy.learn.java.middle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 预编译statement：
 * <p>
 * preparedStatement的优点：
 * <p>
 * 1. 参数设置：statement需要字符串拼接，可读性和维护性都比较差。而preparedStatement可读性好，不易犯错
 * 2. 性能更高
 * 3. 防止SQL注入式攻击
 * <p>
 * execute与executeUpdate的区别：
 * <p>
 * 不同1：
 * execute可以执行查询语句
 * 然后通过getResultSet，把结果集取出来
 * executeUpdate不能执行查询语句
 * <p>
 * 不同2:
 * execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等
 * executeUpdate返回的是int，表示有多少条数据受到了影响
 */
public class PrepareStatement {
    public static void main(String[] args) {
        try {
            //初始化Mysql的驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "insert into hero values(null,?,?,?)";
        String sql2 = "select * from hero where name = ?";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root", "203991");
             Statement s = c.createStatement();
             // 根据sql语句创建PreparedStatement
             PreparedStatement ps = c.prepareStatement(sql2);
        ) {

            // 假设name是用户提交来的数据
            String name = "'盖伦' OR 1=1";
            String sql0 = "select * from hero where name = " + name;

            // 拼接出来的SQL语句就是
            // select * from hero where name = '盖伦' OR 1=1
            // 因为有OR 1=1，所以恒成立
            // 那么就会把所有的英雄都查出来，而不只是盖伦
            // 如果Hero表里的数据是海量的，比如几百万条，把这个表里的数据全部查出来
            // 会让数据库负载变高，CPU100%，内存消耗光，响应变得极其缓慢
            System.out.println(sql0);

            ResultSet rs0 = s.executeQuery(sql0);
            while (rs0.next()) {
                String heroName = rs0.getString("name");
                System.out.println(heroName);
            }

            s.execute(sql0);

            // 使用预编译Statement就可以杜绝SQL注入

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            // 查不出数据出来
            while (rs.next()) {
                String heroName = rs.getString("name");
                System.out.println(heroName);
            }


            //Statement执行10次，需要10次将sql语句传输到数据库端
            //数据库需要对每一次传输来的sql语句进行编译处理
//            for (int i = 0; i < 10; i++) {
//                String sql10 = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + i + ")";
//                s.execute(sql10);
//            }


            //preparedStatement执行10次，只需要1次把sql语句传输到数据库端，
            //数据库对待 ？的sql语句进行预编译

            //每次执行只需要传输参数到数据库端
            //1. 网络传输量比statement更小
            //2. 数据库不需要再进行编译，速度更快
//            for (int i = 0; i < 10; i++) {
//                // 设置参数
//                ps.setString(1, "timo4");
//                ps.setFloat(2, 23.45F);
//                ps.setInt(3, 20);
//                //执行
//                ps.execute();
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
