package com.ljj.thread;


import org.junit.Test;


class TicketTest {
    @Test
    public void sale(){
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket);
        thread1.start();
    }
}