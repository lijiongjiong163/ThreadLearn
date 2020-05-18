package com.ljj.threadLocal;

class comTestTest {
    public static void main(String[] args) {
        final comTest comTest = new comTest();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                comTest.thread1();
            }
        }, "线程1");

        class myRunnable implements Runnable {
            public void run() {
                comTest.thread2();
            }
        }
        Thread thread2 = new Thread(new myRunnable(), "线程2");
        thread1.start();
        thread2.start();
    }
}