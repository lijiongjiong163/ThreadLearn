package com.ljj.deadlock;

/**
 * 死锁实例
 */
public class DeadLockRunnable implements Runnable{

    private int flag;
    private static Object object1 = new Object();
    private static Object object2 = new Object();

    public DeadLockRunnable(int flag) {
        this.flag = flag;
    }

    public void run() {
        if (flag==1){
            synchronized (object1){
                System.out.println(Thread.currentThread().getName()+"已获取obj1，等待获取obj2");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2){
                    System.out.println(Thread.currentThread().getName()+"已获取obj1和obj2");
                }
            }
        }else {
            synchronized (object2){
                System.out.println(Thread.currentThread().getName()+"已获取obj2，等待获取obj1");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1){
                    System.out.println(Thread.currentThread().getName()+"已获取obj1和obj2");
                }
            }

        }
    }
}
