package com.ljj.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程通讯：
 * 使用condition的方法来实现线程间的通信
 * 实现效果：
 * 线程一打印奇数，线程二打印偶数
 */
public class OddEvenDemo2 {
    private int i = 0;
    private Lock lock = new ReentrantLock();//这里使用独占锁
    private Condition condition = lock.newCondition();


    /**
     * 奇数打印方法
     */
    public void odd() {
        lock.lock();
        try {

            while (i < 10) {
                if (i % 2 == 1) {
                    System.out.println("线程" + Thread.currentThread().getName() + "打印奇数：" + i);
                    i++;
                    condition.signal();//唤醒奇数线程打印
                } else {
                    try {
                        condition.await();//等待偶数线程打印完毕
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        } finally {
            lock.unlock();
        }
    }

    public synchronized void even() {

        lock.lock();
        try {

            while (i < 10) {
                if (i % 2 == 0) {
                    System.out.println("线程" + Thread.currentThread().getName() + "打印偶数：" + i);
                    i++;
                    condition.signal();//唤醒奇数线程打印
                } else {
                    try {
                        condition.await();//等待偶数线程打印完毕
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        } finally {
            lock.unlock();
        }


    }


}

