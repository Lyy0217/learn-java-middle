package com.lyy.learn.java.middle.thread.startthread;

/**
 * 实现Runnable接口的线程
 */
public class KillRunnable implements Runnable {
    private Hero hero1;
    private Hero hero2;

    public KillRunnable(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public void run() {
        while (!hero2.isDead()) {
            hero1.attackHero(hero2);
        }
    }
}
