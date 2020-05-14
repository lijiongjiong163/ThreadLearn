package com.ljj.thread;


import org.junit.Test;


public class TicketTest {
    @Test
    public void sale(){
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket,"窗口1");
        thread1.start();
    }
}