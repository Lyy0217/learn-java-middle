package com.lyy.learn.java.middle.exception.overdraftexecption;

/**
 * 透支异常
 */
public class OverDraftException extends Exception {
    //透支额
    private double deficit;

    public double getDeficit() {
        return deficit;
    }

    public OverDraftException(String msg, double deficit) {
        super(msg);
        this.deficit = deficit;
    }
}
