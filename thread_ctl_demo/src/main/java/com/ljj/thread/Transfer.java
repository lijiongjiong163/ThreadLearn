package com.ljj.thread;

/**
 * 转账行为
 */
public class Transfer implements Runnable{
    private TBank bank;//threadLocal实现Bank
    //private Bank bank;//普通bank

    public Transfer(TBank bank) {
        this.bank = bank;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            bank.setMoney(10);
            System.out.println(Thread.currentThread().getName()+"存款成功，当前余额"+bank.getMoney());
        }
    }
}
