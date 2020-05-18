package com.ljj.threadLocal;

/**
 * 线程通讯：
 * 使用Object的方法来实现线程间的通信
 * 实现效果：
 * 线程一打印奇数，线程二打印偶数
 */
public class OddEvenDemo {
    private int i = 0;
    private  Object object = new Object();
    /**
     * 奇数打印方法
     */
    public  void odd(){
        synchronized (object){
            while (i<10)
            {
                if (i%2==1){
                    System.out.println("线程"+Thread.currentThread().getName()+"打印奇数："+i);
                    i++;
                    object.notify();//唤醒奇数线程打印
                }else {
                    try {
                        object.wait();//等待偶数线程打印完毕
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
      }
    public synchronized void even(){
synchronized (object){

    while (i<10)
    {
        if (i%2==0){
            System.out.println("线程"+Thread.currentThread().getName()+"打印偶数："+i);
            i++;
            object.notify();//唤醒偶数线程打印
        }else {
            try {
                object.wait();//等待奇数线程打印完毕
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}}

}
