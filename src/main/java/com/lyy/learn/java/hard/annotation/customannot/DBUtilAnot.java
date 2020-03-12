package com.lyy.learn.java.hard.annotation.customannot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 非注解方式的DBUtil
 */
@JDBCConfig(ip = "127.0.0.1", database = "how2java", encoding = "UTF-8", loginName = "root", password = "203991")
//@JDBCConfig(ip = "127.0.0.1", database = "how2java", encoding = "UTF-8", loginName = "root", password = "203991")
public class DBUtilAnot{

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        JDBCConfig config = DBUtilAnot.class.getAnnotation(JDBCConfig.class);

        String ip = config.ip();
        int port = config.port();
        String database = config.database();
        String encoding = config.encoding();
        String loginName = config.loginName();
        String password = config.password();

        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);

        return DriverManager.getConnection(url, loginName, password);
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, SQLException {
        Connection c = getConnection();
        System.out.println(c);
    }

}
