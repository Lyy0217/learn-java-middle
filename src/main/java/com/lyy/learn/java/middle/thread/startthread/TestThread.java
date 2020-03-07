package com.lyy.learn.java.middle.thread.startthread;

/**
 * 创建线程的三种方式:
 *
 * 1. 继承Thread类
 * 2. 实现Runnable接口
 * 3. 匿名内部类
 *
 * 启动线程的方法是start(), run()方法并不能启动一个新的线程
 */
public class TestThread {
    public static void main(String[] args) {

        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

//        KillRunnable killRunnable = new KillRunnable(gareen, teemo);
//        new Thread(killRunnable).start();
//
//        KillRunnable killRunnable1 = new KillRunnable(bh, leesin);
//        new Thread(killRunnable1).start();

        //匿名类实现多线程
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (!teemo.isDead()) {
                    gareen.attackHero(teemo);
                }
            }
        };

        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (!leesin.isDead()) {
                    bh.attackHero(leesin);
                }
            }
        };
        t2.start();
    }
}
