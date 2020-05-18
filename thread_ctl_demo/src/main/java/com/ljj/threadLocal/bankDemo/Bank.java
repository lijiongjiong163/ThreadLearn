package com.ljj.threadLocal.bankDemo;

/**
 * 普通bank类，线程不安全且线程共享一个对象，大家一存都存一块去了
 */
public class Bank{
    int money = 0;

    /**
     * 查询钱
     * @return 账户余额
     */
    public int getMoney() {
        return money;
    }

    /**
     * 存钱
     * @param money
     */
    public void setMoney(int money) {
        this.money=this.money + money;
    }
}