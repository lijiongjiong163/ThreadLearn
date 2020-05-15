package com.ljj.thread;


/**
 * 1.object.notify()或者object.wait(),都是让当前操作这个对象（或者说执行这个代码）的对象等待或者去唤醒别人
     * 2.这两个玩意必须放在synchronized (object){}代码块里，不然会报IllegalMonitorStateException
 * 3.要在内部类中使用局部变量，局部变量必须被final修饰
 */
class OddEvenDemoTest {

    public static void main(String[] args) {
       final OddEvenDemo oddEvenDemo = new OddEvenDemo();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                oddEvenDemo.odd();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                oddEvenDemo.even();
            }
        });
        thread1.start();
        thread2.start();
    }
}