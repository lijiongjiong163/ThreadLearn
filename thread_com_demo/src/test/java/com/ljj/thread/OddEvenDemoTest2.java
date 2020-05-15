package com.ljj.thread;


public class OddEvenDemoTest2 {
    int i = 1000;
    public static void main(String[] args) {
       final OddEvenDemo2 oddEvenDemo = new OddEvenDemo2();
        final OddEvenDemoTest2 oddEvenDemoTest2 = new OddEvenDemoTest2();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                oddEvenDemo.odd();
                Inner inner = oddEvenDemoTest2.new Inner();
                inner.print();
                oddEvenDemoTest2.i=500;
                inner.print();

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
    class Inner{
        void print(){
            System.out.println("内部类调用i："+i);

        }
    }
}