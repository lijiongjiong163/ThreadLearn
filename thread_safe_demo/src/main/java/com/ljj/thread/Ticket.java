package com.ljj.thread;

public class Ticket implements Runnable{
    private int ticketNum = 100;
    public void run() {
        while (true){
            //是否有票
            if (ticketNum>0){
                //有的话办手续卖票
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //打印出线程名和当前票数，然后票数减一结束本次卖票
                String name = Thread.currentThread().getName();
                System.out.println("线程"+name+"销售电影票："+ticketNum--);



            }
        }

    }
}
