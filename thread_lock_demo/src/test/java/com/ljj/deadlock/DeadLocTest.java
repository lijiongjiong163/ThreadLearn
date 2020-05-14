package com.ljj.deadlock;



class DeadLocTest {

    public static void main(String[] args) {
        DeadLockRunnable runnable1 = new DeadLockRunnable(1);
        DeadLockRunnable runnable2 = new DeadLockRunnable(2);
        Thread thread1 = new Thread(runnable1, "线程1");
        Thread thread2 = new Thread(runnable2, "线程2");
        thread1.start();
        thread2.start();
    }
}