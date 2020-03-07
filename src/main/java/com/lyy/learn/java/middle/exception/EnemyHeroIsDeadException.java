package com.lyy.learn.java.middle.exception;

/**
 * 自定义异常
 * @des： 一个英雄攻击另一个英雄的时候，如果发现另一个英雄已经死了，就抛出：EnemyHeroIsDeadException
 */
public class EnemyHeroIsDeadException extends Exception{

    public EnemyHeroIsDeadException() {
    }

    public EnemyHeroIsDeadException(String message) {
        super(message);
    }
}
