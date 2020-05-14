package com.ljj.thread;


import org.junit.Test;


public class TicketTest {

    public static void main(String[] args) {


        System.out.println(Thread.currentThread().getName());
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket,"窗口1");
        Thread thread2 = new Thread(ticket,"窗口2");
        Thread thread3 = new Thread(ticket,"窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("什么鬼");
    }
}