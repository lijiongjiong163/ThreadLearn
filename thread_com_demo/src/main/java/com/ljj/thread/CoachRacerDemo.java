package com.ljj.thread;

import java.sql.SQLOutput;
import java.util.concurrent.CountDownLatch;

/**
 * 教练运动员实例---实现countDownLatch进行线程通讯
 */
public class CoachRacerDemo {
    private CountDownLatch countDownLatch = new CountDownLatch(3);//设置要等待的运动员是3个

    /**
     * 运动员方法
     */
    public void recer(){
        String name = Thread.currentThread().getName();
        System.out.println(name+"开始准备。。。");
        try {
            Thread.sleep(1000);//正在准备
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"准备完成。。。");
         countDownLatch.countDown();
        System.out.println(name+"：快点呀，等的花儿都谢了");
    }

    /**
     * 教练方法
     */
    public void coach(){
        String name = Thread.currentThread().getName();
        System.out.println(name+"已就位，等待运动员");
        try {
            //调用countDownLatch的await方法等待其他线程
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("全部就位，开始训练！！！！");

    }
}
