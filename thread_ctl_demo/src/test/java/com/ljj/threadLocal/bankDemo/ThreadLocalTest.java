package com.ljj.threadLocal.bankDemo;


import com.ljj.threadLocal.bankDemo.TBank;
import com.ljj.threadLocal.bankDemo.Transfer;

public class ThreadLocalTest {
    public static void main(String[] args) {
        TBank bank = new TBank();
        Thread thread1 = new Thread(new Transfer(bank),"用户1");
        Thread thread2 = new Thread(new Transfer(bank),"用户2");
        thread1.start();
        thread2.start();
    }

}