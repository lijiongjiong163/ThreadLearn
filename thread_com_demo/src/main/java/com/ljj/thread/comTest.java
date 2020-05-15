package com.ljj.thread;

/**
 * 测试：
 * 线程1拿对象1的锁，线程2拿对象2的锁，然后用线程1调对象2的wait方法会咋样呢。
 * 结论：会报IllegalMonitorStateException，说明当前线程只有拥有这个对象的锁的时候才能使用它的notify或者wait方法
 */
public class comTest {
    Object object1 = new Object();
    Object object2 = new Object();
    public void thread1(){
        synchronized (object1){
            int i =1;
            while (true){
                try {
                    Thread.sleep(1000);

                System.err.println(Thread.currentThread().getName()+"打印："+i++);
                if (i==10){
                    object2.wait();
                }
                if (i==20){
                    object2.notify();
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public void thread2(){
        synchronized (object2){
            int i =1;
            while (true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"打印："+i++);
            }
        }
    }


}
