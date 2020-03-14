package com.lyy.learn.java.middle.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试数据库连接池类
 */
public class TestConnectionPool {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool(3);
        for (int i = 0; i < 100; i++) {
            new WorkingThread("working thread" + i, pool).start();
        }
    }
}

class WorkingThread extends Thread {
    ConnectionPool cp;

    public WorkingThread(String name, ConnectionPool c) {
        super(name);
        this.cp = c;
    }

    @Override
    public void run() {
        Connection c = cp.getConnection();
        System.out.println(this.getName() + ":\t 获取了一根连接，并开始工作");
        try (Statement s = c.createStatement()) {
            //模拟时耗１秒的数据库ＳＱＬ语句
            Thread.sleep(1000);
            s.execute("select * from hero");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //这里不能忘记归还连接
        cp.returnConnection(c);
    }
}
