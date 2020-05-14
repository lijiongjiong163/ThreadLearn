package org.example.creation;


import java.util.Date;

public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread()+",时间："+ new Date().getTime());
        }
    }
}
