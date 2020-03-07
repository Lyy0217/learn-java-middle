package com.lyy.learn.java.middle.thread.startthread;

/**
 * 创建多线程：继承Thread的线程类
 */
public class KillThread extends Thread {

    Hero hero1;
    Hero hero2;

    public KillThread(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    @Override
    public void run() {
        while (!hero2.isDead()) {
            hero1.attackHero(hero2);
        }
    }
}
