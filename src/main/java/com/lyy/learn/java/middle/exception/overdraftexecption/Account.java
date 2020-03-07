package com.lyy.learn.java.middle.exception.overdraftexecption;

/**
 * 银行账户,不带透支额度
 */
public class Account {
    //银行账号余额
    protected double balance;

    public double getBalance() {
        return balance;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amt) {
        this.balance += amt;
    }

    public void withDraw(double amt) throws OverDraftException {
        if (this.balance < amt) {
            throw new OverDraftException("余额不足", amt - this.balance);
        }
        this.balance -= amt;
    }

    public static void main(String[] args) {
        //开户存了1000
        Account a = new Account(1000);
        //存钱1000
        a.deposit(1000);
        //查看余额
        System.out.println(a.getBalance());

        try {
            //取2001
            a.withDraw(2001);
        } catch (OverDraftException e) {
            System.err.println("透支金额：" + e.getDeficit());
            e.printStackTrace();
        }
    }
}
