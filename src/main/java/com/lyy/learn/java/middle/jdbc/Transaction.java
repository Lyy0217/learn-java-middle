package com.lyy.learn.java.middle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc的事务。MYSQL 表的类型必须是INNODB才支持事务
 * c.setAutoCommit(false)关闭自动提交事务
 * c.setCommit():手动提交
 */
public class Transaction {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "203991");
             Statement s = c.createStatement()) {

            c.setAutoCommit(false);
            //没有事务的前提下
            //假设业务操作时，加血，减血各做一次
            //结束后，英雄的血量不变

            //加血的SQL
            String sql1 = "update hero set hp = hp +1 where id = 21";
            s.execute(sql1);

            //减血的SQL
            //不小心写错写成了 updata(而非update)

            String sql2 = "updata hero set hp = hp -1 where id = 21";
            s.execute(sql2);

            c.commit();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
