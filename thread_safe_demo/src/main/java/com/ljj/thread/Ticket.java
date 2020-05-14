package com.ljj.thread;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {

    private int ticketNum = 100;
    private Object object = new Object();
    //3.1先创建lock接口实现类对象
    private Lock lock = new ReentrantLock(true);//传参决定是否是公平锁：true--公平锁，多个线程都公平拥有执行权；false--非公平锁（默认），独占锁

    @Override
    public void run() {

            while (true) {
                //1.synchronized (object)方法
                /*synchronized (object) {
                    //是否有票
                    if (ticketNum > 0) {
                        //有的话办手续卖票
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //打印出线程名和当前票数，然后票数减一结束本次卖票
                        String name = Thread.currentThread().getName();
                        System.out.println("线程" + name + "销售电影票：" + ticketNum--);
                    }
                }*/
                //2.使用同步方法
                //saleticket();//2.2使用这方法就完事了
                //3.使用同步锁的方法
                //3.2加锁
                lock.lock();
                try {
                    //写可能产生线程安全问题的代码
                    if (ticketNum > 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        String name = Thread.currentThread().getName();
                        System.out.println("线程" + name + "销售电影票：" + ticketNum--);
                    }
                }finally {
                    //3.3解锁
                    //由于不调unlock方法会引起死锁，所以防止程序出错而执行不到unlock，使用try块包住，然后使用finally中解锁，这样就一定能解锁了
                    lock.unlock();
                }


            }

    }

    /**
     * 2.1同步方法
     */
    public synchronized void saleticket(){
            //是否有票
            if (ticketNum > 0) {
                //有的话办手续卖票
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //打印出线程名和当前票数，然后票数减一结束本次卖票
                String name = Thread.currentThread().getName();
                System.out.println("线程" + name + "销售电影票：" + ticketNum--);
            }

    }
}
